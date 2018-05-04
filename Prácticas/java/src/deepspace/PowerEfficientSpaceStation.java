/**
 *
 * @author elena
 */

package deepspace;

public class PowerEfficientSpaceStation extends SpaceStation {
    private static final float EFFICIENCYFACTOR= 1.1f;
    
    public PowerEfficientSpaceStation(SpaceStation station){
        super(station);
    }
    
    public float fire(){
        return super.fire()*EFFICIENCYFACTOR;
    }
    
    public float protection(){
        return super.protection()*EFFICIENCYFACTOR;
    }
    
    public Transformation setLoot(){
        return Transformation.NOTRANSFORM;
    }
}
