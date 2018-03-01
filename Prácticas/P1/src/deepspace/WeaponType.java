/**
 * @author elena
 * @brief Representa los tipos de armas del juego y su potencia de disparo.
 */
package deepspace;

public enum WeaponType {
    LASER(2.0f), MISSILE(3.0f), PLASMA(4.0f);
        
    private float power;

    WeaponType(float another_power){
        this.power= another_power;
    }

    float getPower(){
        return power;
    }
    
}
