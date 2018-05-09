/**
 * @author Elena Merelo
 */
package deepspace;

import java.util.ArrayList;

public class GameUniverse {
    private static final int WIN= 10;
    private int currentStationIndex;
    private int turns;
    private EnemyStarShip currentEnemy;
    private GameStateController gameState;
    private Dice dice;
    private SpaceStation currentStation;
    private ArrayList<SpaceStation> spaceStations;
    private boolean haveSpaceCity;
    
    //Constructor 
    public GameUniverse(){
        gameState= new GameStateController();
        turns= 0;
        dice= new Dice();
    }
    
    //Getters
    public GameUniverseToUI getUIversion(){
        return new GameUniverseToUI(currentStation, currentEnemy);
    }

    public GameState getState() {
        return gameState.getState();
    } 
    
    private boolean correct_game_state(){
        return gameState.getState() == GameState.INIT || gameState.getState() == GameState.AFTERCOMBAT;
    }
    
    public void discardHangar(){
        if(correct_game_state())
            currentStation.discardHangar();
    }
    
    public void discardShieldBooster(int i){
        if(correct_game_state())
            currentStation.discardShieldBooster(i);
    }
    
    public void discardShieldBoosterInHangar(int i){
        if(correct_game_state())
            currentStation.discardShieldBoosterInHangar(i);
    } 
    
    public void discardWeapon(int i){
        if(correct_game_state())
            currentStation.discardWeapon(i);
    }
    
    public void discardWeaponInHangar(int i){
        if(correct_game_state())
            currentStation.discardWeaponInHangar(i);
    }
    
    public boolean haveAWinner(){
        return currentStation.getNMedals() == WIN;
    }
    
    public void mountShieldBooster(int i){
        if(correct_game_state())
            currentStation.mountShieldBooster(i);
    }
    
    public void mountWeapon(int i){
        if(correct_game_state())
            currentStation.mountWeapon(i);
    }
    
    /**
     * @brief Se realiza un combate entre la estación espacial y el enemigo que 
     * se reciben como parámetros. Se sigue el procedimiento descrito en las reglas 
     * del juego: sorteo de quién dispara primero, posibilidad de escapar, asignación 
     * del botín, anotación del daño pendiente, etc. Se devuelve el resultado del combate.
    */
    CombatResult combat(SpaceStation station, EnemyStarShip enemy){
        boolean enemyWins;
        CombatResult combatResult;
        ShotResult result;
        
        if(dice.firstShot() == GameCharacter.ENEMYSTARSHIP){
            result= station.receiveShot(enemy.fire());
            
            if(result == ShotResult.RESIST){
                result= enemy.receiveShot(station.fire());
                enemyWins= result == ShotResult.RESIST;
            }
            else enemyWins= true;  
        }
        else{
            result= enemy.receiveShot(station.fire());
            enemyWins= result == ShotResult.RESIST;
        }
        
        if(enemyWins){
            boolean moves= dice.spaceStationMoves(station.getSpeed());
            
            if(!moves){
                station.setPendingDamage(enemy.getDamage());
                combatResult= CombatResult.ENEMYWINS;
            }
            else{
                station.move();
                combatResult= CombatResult.STATIONESCAPES;
            }
        }
        else{
            Loot l= enemy.getLoot();
            Transformation t= station.setLoot(l);
            combatResult= CombatResult.STATIONWINS;
            if(t == Transformation.GETEFFICIENT){
                makeStationEfficient();
                combatResult= CombatResult.STATIONWINSANDCONVERTS;

            }
            else if(t == Transformation.SPACECITY){
                createSpaceCity();
                combatResult= CombatResult.STATIONWINSANDCONVERTS;
            }
        }
        
        gameState.next(turns, spaceStations.size());
        return combatResult;
    }
    
    /** 
     * @brief Inicia una partida. Recibe una colección con los nombres de los jugadores. 
     * Para cada jugador, se crea una estación espacial y se equipa con suministros, 
     * hangares, armas y potenciadores de escudos tomados de los mazos de cartas
     * correspondientes. Se sortea qué jugador comienza la partida, se establece 
     * el primer enemigo y comienza el primer turno. 
     */
    public void init(ArrayList<String> names){
        if(gameState.getState() == GameState.CANNOTPLAY){
            spaceStations= new ArrayList<>();
            CardDealer dealer= CardDealer.getInstance();
            int nh, nw, ns;
            
            for(String name: names){
                SuppliesPackage supplies= dealer.nextSuppliesPackage();
                
                SpaceStation station= new SpaceStation(name, supplies);
                nh= dice.initWithNHangars();
                nw= dice.initWithNWeapons();
                ns= dice.initWithNShields();
              
                station.setLoot(new Loot(0, nh, nw, ns, 0));
                spaceStations.add(station);
            }
            
            currentStationIndex= dice.whoStarts(names.size());
            
            currentStation= spaceStations.get(currentStationIndex);
            currentEnemy= dealer.nextEnemy();
            
            gameState.next(turns, spaceStations.size());
        }
    }
    
    /**
     * @brief Si la aplicación se encuentra en un estado en donde el combatir está
     * permitido, se realiza un combate entre la estación espacial que tiene el 
     * turno y el enemigo actual. Se devuelve el resultado del combate.
     */
    public CombatResult combat(){
        GameState state= gameState.getState();
        
        if(state == GameState.BEFORECOMBAT || state == GameState.INIT)
            return combat(currentStation, currentEnemy);
        
        else return CombatResult.NOCOMBAT;
    }
    
    /**
     * @brief Se comprueba que el jugador actual no tiene ningún daño pendiente 
     * de cumplir, en cuyo caso se realiza un cambio de turno al siguiente jugador 
     * con un nuevo enemigo con quien combatir, devolviendo true. Se devuelve false 
     * en otro caso.
     */
    public boolean nextTurn(){
        if(gameState.getState() == GameState.AFTERCOMBAT){
            if(currentStation.validState()){
                currentStationIndex= (currentStationIndex +1)%spaceStations.size();
                turns++;
                
                currentStation= spaceStations.get(currentStationIndex);
                currentStation.cleanUpMountedItems();
                
                CardDealer dealer= CardDealer.getInstance();
                currentEnemy= dealer.nextEnemy();
                
                gameState.next(turns, spaceStations.size());
                
                return true;
            }
            else return false;
        }
        else return false;
    }
    
    private void makeStationEfficient(){
        currentStation= dice.extraEfficiency()? new BetaPowerEfficientSpaceStation(currentStation) : new PowerEfficientSpaceStation(currentStation); 
    }
    
    private void createSpaceCity(){
        if(!haveSpaceCity){
            currentStation= new SpaceCity(currentStation, spaceStations);
            haveSpaceCity = true;
            // spaceStations.set(currentStationIndex, currentStation);
        }
    }
}


















