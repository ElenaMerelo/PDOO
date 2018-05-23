package deepspace;

/**
 *
 * @author Profesor
 */
public abstract class DamageToUI {
    private int nShields;

    DamageToUI(Damage d) {
        nShields=d.getNShields();
    }

    public int getNShields() {
        return nShields;
    }
    
    public abstract String getWeaponInfo();
    
    
}
