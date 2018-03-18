package deepspace;

/**
 *
 * @author Profesor
 */

public class WeaponToUI {
    private WeaponType type;
    private float power;
    private int uses;  
    
    WeaponToUI(Weapon w) {
        type=w.getType();
        power=w.power();
        uses=w.getUses();
    }  

    public WeaponType getType() {
        return type;
    }

    public float getPower() {
        return power;
    }

    public int getUses() {
        return uses;
    }
    
}
