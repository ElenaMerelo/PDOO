package deepspace;

/**
 *
 * @author Profesor
 */

public class ShieldToUI {
    private float boost;
    private int uses;

    ShieldToUI (ShieldBooster s) {
        boost=s.getBoost();
        uses=s.getUses();
    }    

    public float getBoost() {
        return boost;
    }

    public int getUses() {
        return uses;
    }
    
    
}
