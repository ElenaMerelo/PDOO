/**
 *
 * @author elena
 */

package deepspace;

public class PowerEfficientSpaceStation extends SpaceStation {
    private static final float EFFICIENCYFACTOR= 1.10f;
    
    public PowerEfficientSpaceStation(SpaceStation station){
        super(station);
    }
    
    public float fire(){
        float f= EFFICIENCYFACTOR;
        for(Weapon w: super.weapons)
          f *= w.useIt();  
        
        return super.ammoPower*f;
    }
}
