import java.util.Random;

/**
 * @author elena
 * @brief Esta clase tiene la responsabilidad de tomar todas las decisiones 
 * que dependen del azar en el juego. Es como una especie de dado, pero algo 
 * más sofisticado, ya que no proporciona simplemente un número del 1 al 6, sino 
 * decisiones concretas en base a una serie de probabilidades establecidas.
 */
class Dice {
    private final float NHANGARSPROB, NSHIELDSPROB, NWEAPONSPROB, FIRSTSHOTPROB;
    private Random generator;
    
    //Constructores
    Dice(){
        this.generator= new Random();
        this.NHANGARSPROB=0.25f;
        this.NSHIELDSPROB=0.25f;
        this.NWEAPONSPROB=0.33f;
        this.FIRSTSHOTPROB=0.5f;
    }
    
    /*
     * @brief Devuelve 0 con una probabilidad de NHANGARSPROB y 1 en caso contrario. 
     * Este método determina el número de hangares que recibirá una estación espacial al ser creada.
    */
    int initWithNHangars(){
        if( generator.nextFloat() <= NHANGARSPROB )
            return 0;
        return 1;
    }
    
    /*
     * @brief Devuelve 1 con una probabilidad de NWEAPONSPROB, 2 con la misma probabilidad 
     * y 3 con una probabilidad de (1-2* NWEAPONSPROB). Este método determina el
     * número de armas que recibirá una estación espacial al ser creada.
    */
    int initWithWeapons(){
        float n= 1 - 2*NWEAPONSPROB;
        if ( generator.nextFloat() <= NWEAPONSPROB )
            return 1;
        if (generator.nextFloat() > NWEAPONSPROB && generator.nextFloat() <= n )
            return 2;
        return 3; 
    }
    
    /*
     * @brief Devuelve 0 con una probabilidad de NSHIELDSPROB y 1 en caso contrario.
     * Este método determina el número de potenciadores de escudo que recibirá 
     * una estación espacial al ser creada.
    */
    int initWithNShields(){
        return generator.nextFloat() <= NSHIELDSPROB ? 0: 1;
    }
    
    /*
     * @brief Genera un número aleatorio del intervalo [0,nPlayers-1]. Determina 
     * el jugador (su índice) que iniciará la partida.
    */
    int whoStarts(int nPlayers){
        return generator.nextInt(nPlayers-1);
    }
    
    /*
     * @brief Genera SPACESTATION con una probabilidad de FIRSTSHOTPROB y ENEMYSTARSHIP 
     * en otro caso. Determina quién (de los dos tipos de personajes del juego) 
     * dispara primero en un combate: la estación espacial o la nave enemiga.
    */
    GameCharacter firstShot(){
        GameCharacter primero= generator.nextFloat() <= FIRSTSHOTPROB ? GameCharacter.SPACESTATION : GameCharacter.ENEMYSTARSHIP;
        return primero;
    }
    
    /*
     * @brief Devuelve true con una probabilidad de speed y false en caso contrario 
     * (se asume que speed será un número entre 0 y 1). Determina si la estación
     * espacial se moverá para esquivar un disparo. La probabilidad de moverse 
     * será mayor cuanto más cerca está la velocidad potencial actual de la estación 
     * espacial de su velocidad máxima potencial.
    */
    boolean spaceStationMoves(float speed){
        boolean prob= generator.nextFloat() <= speed ? true : false;
        return prob;
    }
    
    
    
            
}
