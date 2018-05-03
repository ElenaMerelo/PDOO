/**
 *
 * @author elena
 */

package deepspace;
import java.util.ArrayList;

public class SpaceCity extends SpaceStation {
    private SpaceStation base;
    private ArrayList<SpaceStation> collaborators;
    
    public SpaceCity(SpaceStation base, ArrayList<SpaceStation> rest){
        super(base);
        this.base= base;
        this.collaborators= rest;
    }
    
    public ArrayList<SpaceStation> getCollaborators(){
        return collaborators;
    }
    
    public float fire(){
        float f= 0;
        
        for(SpaceStation s: collaborators)
            f += s.fire();
        
        f += base.fire();
        
        return f;
    }
    
    public float protection(){
        float p= 0;
        
        for(SpaceStation s: collaborators)
            p += s.protection();
        
        p += base.protection();
        
        return p;
    }
    
    public Transformation setLoot(Loot l){
        super.setLoot(l);
        return Transformation.NOTRANSFORM;
    }
}
