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
        NHANGARSPROB=0.25f;
        NSHIELDSPROB=0.25f;
        NWEAPONSPROB=0.33f;
        FIRSTSHOTPROB=0.5f;
    }
            
}
