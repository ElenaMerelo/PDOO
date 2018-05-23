/**
 *
 * @author elena
 */

package deepspace;

import java.util.ArrayList;

public class NumericDamage extends Damage {
    private int nWeapons;
    
    //Constructores
    NumericDamage(int nw, int ns){
        super(ns);
        nWeapons= nw;
    }
    
    @Override
    public NumericDamage copy(Damage d){
        return new NumericDamage(((NumericDamage) d).getNWeapons(), d.getNShields());
    }
    
    @Override
    public NumericDamageToUI getUIversion(){
        return new NumericDamageToUI(this);
    }
    
    public int getNWeapons(){
        return nWeapons;
    }
    

    @Override
    public NumericDamage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
        int n_shields= super.adjust_shields(s);
        int n_weapons= Math.min(nWeapons, w.size());
        
        return new NumericDamage(n_weapons, n_shields);
    }
    
    @Override
    public void discardWeapon(Weapon w){
        if(nWeapons > 0)
            nWeapons--;    
    }
    
    @Override
    public boolean hasNoEffect(){
        return super.hasNoEffect() && nWeapons == 0;
    }
    
    @Override 
    public String toString(){
        return "nShields- " + super.toString() + ", nWeapons- " + nWeapons;
    }
}
