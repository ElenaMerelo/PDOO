/**
 *
 * @author elena
 */

package deepspace;
import java.util.Random;

public class BetaPowerEfficientSpaceStation extends PowerEfficientSpaceStation {
    private static final float EXTRAEFFICIENCY= 1.2f;
    private Dice dice;
    private Random generator;
    
    public BetaPowerEfficientSpaceStation(SpaceStation station){
        super(station);
    }
    
    @Override
    public float fire(){
        float fire= super.fire();
        return dice.extraEfficiency() ? fire*EXTRAEFFICIENCY : fire;
    }
    
    @Override
    public BetaPowerEfficientSpaceStationToUI getUIVersion(){
        return new BetaPowerEfficientSpaceStationToUI(this);
    }
    
}
