
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
        generator= new Random();
        NHANGARSPROB=0.25f;
        NSHIELDSPROB=0.25f;
        NWEAPONSPROB=0.33f;
        FIRSTSHOTPROB=0.5f;
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
        if ( generator.nextFloat() < NWEAPONSPROB )
            return 1;
        if (generator.nextFloat() >= NWEAPONSPROB && generator.nextFloat() < n )
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
        return generator.ints(0, nPlayers-1).findFirst().getAsInt();
    }
    
    
    
            
}
