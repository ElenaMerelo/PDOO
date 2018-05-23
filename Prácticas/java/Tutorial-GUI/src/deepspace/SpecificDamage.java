/**
 *
 * @author elena
 */

package deepspace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class SpecificDamage extends Damage {
    private ArrayList<WeaponType> weapons;
    
    SpecificDamage(ArrayList<WeaponType> w, int s){
        super(s);
        weapons= w;
    }
    
    @Override
    public SpecificDamage copy(Damage d){
        return new SpecificDamage(((SpecificDamage )d).getWeapons(), d.getNShields());
    }
    
    //Getters
    @Override
    public SpecificDamageToUI getUIversion(){
        return new SpecificDamageToUI(this);
    }
    
    public ArrayList<WeaponType> getWeapons(){
        return weapons;
    }
    
    @Override
    public SpecificDamage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
        int n_shields= super.adjust_shields(s);
        int freq;

        ArrayList<WeaponType> types= new ArrayList<>(Arrays.asList(WeaponType.LASER, WeaponType.MISSILE, WeaponType.PLASMA));
        ArrayList<WeaponType> adjusted= new ArrayList<>();

        //Obtenemos al array con los tipos de armas de w
        ArrayList<WeaponType> wt= new ArrayList<>();
        for(Weapon i: w)
            wt.add(i.getType());

        for(WeaponType i: types){
            if(arrayContainsType(w, i) != -1){
                freq= Math.min(Collections.frequency(wt, i), Collections.frequency(weapons, i));

                //Una vez obtenida la frecuencia mínima de ocurrencias del weaponType i lo metemos en adjusted
                for(int k= 0; k < freq; k++)
                    adjusted.add(i);
            }

            else
                freq= 0;

        }
        return new SpecificDamage(adjusted, n_shields);  
    }
    
    /**
     * @brief Devuelve el índice de la posición de la primera arma de la 
     * colección de armas (primer parámetro) cuyo tipo coincida con el tipo indicado
     * por el segundo parámetro. Devuelve -1 si no hay ninguna arma en la 
     * colección del tipo indicado por el segundo parámetro.
    */
    private int arrayContainsType(ArrayList<Weapon> w, WeaponType t){
        for(int i= 0; i< w.size(); i++){
            if(w.get(i).getType() == t)
                return i;
        }
        return -1;   
    }

    public void discardWeapon(Weapon w){
        weapons.remove(w.getType());       
    }
    
    public boolean hasNoEffect(){
        return super.hasNoEffect() && weapons.isEmpty();
    }
    
    @Override
    public String toString(){
        return super.toString() + "Weapons- " + weapons;
    }
}
