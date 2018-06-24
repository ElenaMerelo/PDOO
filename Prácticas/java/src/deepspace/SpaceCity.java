/**
 *
 * @author elena
 */

package deepspace;
import java.util.ArrayList;

public class SpaceCity extends SpaceStation {
    private SpaceStation base;
    private ArrayList<SpaceStation> collaborators;
    
    SpaceCity(SpaceStation base, ArrayList<SpaceStation> rest){
        super(base);
        this.base= base;
        this.collaborators= rest;
    }
    
    public ArrayList<SpaceStation> getCollaborators(){
        return collaborators;
    }
    
    @Override
    public float fire(){
        float f= super.fire();
        
        for(SpaceStation s: collaborators)
            f += s.fire();
        
        return f;
    }
    
    @Override
    public float protection(){
        float p= super.protection();
        
        for(SpaceStation s: collaborators)
            p += s.protection();
        
        return p;
    }
    
    @Override
    public Transformation setLoot(Loot l){
        super.setLoot(l);
        return Transformation.NOTRANSFORM;
    }
    
    @Override
    public SpaceCityToUI getUIversion(){
        return new SpaceCityToUI(this);
    }
}
