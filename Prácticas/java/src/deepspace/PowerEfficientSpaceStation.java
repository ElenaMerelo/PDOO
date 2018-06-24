/**
 *
 * @author elena
 */

package deepspace;

public class PowerEfficientSpaceStation extends SpaceStation {
    private static final float EFFICIENCYFACTOR= 1.1f;
    
    PowerEfficientSpaceStation(SpaceStation station){
        super(station);
    }
    
    @Override
    public float fire(){
        return super.fire()*EFFICIENCYFACTOR;
    }
    
    @Override
    public float protection(){
        return super.protection()*EFFICIENCYFACTOR;
    }
    
    @Override
    public Transformation setLoot(Loot l){
        if(super.setLoot(l) == Transformation.GETEFFICIENT)
            return Transformation.GETEFFICIENT;
        else return Transformation.NOTRANSFORM;
    }
    
    public PowerEfficientSpaceStationToUI getUIversion(){
        return new PowerEfficientSpaceStationToUI(this);
    }
}
