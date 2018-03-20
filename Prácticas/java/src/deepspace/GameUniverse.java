/**
 * @author Elena Merelo
 */
package deepspace;

import java.util.ArrayList;

class GameUniverse {
    private static int WIN= 10;
    private int currentStationIndex;
    private int turns;
    private EnemyStarShip currentEnemy;
    private GameStateController gameState;
    private Dice dice;
    private SpaceStation currentStation;
    private ArrayList<SpaceStation> spaceStations;
    
    //Constructor 
    public GameUniverse(){
        gameState= new GameStateController();
        turns= 0;
        dice= new Dice();
    }
    
    //Getters
    public GameUniverseToUI getUIversion(){
        return new GameUniverseToUI(this);
    }

    public GameStateController getGameState() {
        return gameState;
    }
    
    //Se abordará en la siguiente práctica
    CombatResult combat(SpaceStation station, EnemyStarShip enemy){
        throw new UnsupportedOperationException();
    }
    
    //Siguiente práctica
    public CombatResult combat(){
        throw new UnsupportedOperationException();
    }
    
    public void discardHangar(){
        if(gameState == GameState.INIT || gameState == GameState.AFTERCOMBAT)
            currentStation.discardHangar();
    }
    
    public void discardShieldBooster(int i){
        if(gameState == GameState.INIT || gameState == GameState.AFTERCOMBAT)
            currentStation.discardShieldBooster(i);
    }
    
    public void discardShieldBoosterInHangar(int i){
        if(gameState == GameState.INIT || gameState == GameState.AFTERCOMBAT)
            currentStation.discardShieldBoosterInHangar(i);
    } 
    
    
    
    
}


















