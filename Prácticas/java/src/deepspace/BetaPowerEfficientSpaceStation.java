/**
 *
 * @author elena
 */

package deepspace;  

public class BetaPowerEfficientSpaceStation extends PowerEfficientSpaceStation {
    private static final float EXTRAEFFICIENCY= 1.2f;
    private Dice dice;
  
    
    public BetaPowerEfficientSpaceStation(SpaceStation station){
        super(station);
        dice= new Dice();
    }
    
    @Override
    public float fire(){
        float fire= super.fire();
        return dice.extraEfficiency() ? fire*EXTRAEFFICIENCY : fire;
    }
    
    @Override
    public BetaPowerEfficientSpaceStationToUI getUIversion(){
        return new BetaPowerEfficientSpaceStationToUI(this);
    }
    
}
