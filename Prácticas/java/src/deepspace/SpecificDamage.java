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
    public SpecificDamageToUI getUIversion(){
        return new SpecificDamageToUI(this);
    }
    
    public ArrayList<WeaponType> getWeapons(){
        return weapons;
    }
    
    /**
     * @brief Devuelve una versión ajustada del objeto a las colecciones de 
     * armas y potenciadores de escudos suministradas como parámetro.
     * Partiendo del daño representado por el objeto que recibe este mensaje, se devuelve una copia del
     * mismo pero reducida si es necesario para que no implique perder armas o potenciadores de escudos
     * que no están en las colecciones de los parámetros.
    */
    public Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
        int n_shields= Math.min(s.size(), super.getNShields());
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
    
    /**
     * @brief Si la instancia dispone de una lista de tipos concretos de armas,
     * intenta eliminar el tipo del arma pasada como parámetro de esa lista. En otro caso simplemente
     * decrementa en una unidad el contador de armas que deben ser eliminadas. Ese contador no puede
     * ser inferior a cero en ningún caso.
    */
    public void discardWeapon(Weapon w){
        weapons.remove(w.getType());       
    }
    
    
    /**
     * @brief Devuelve true si el daño representado no tiene ningún efecto, no 
     * implica la pérdida de ningún tipo de accesorio (armas o potenciadores de escudo).
    */
    public boolean hasNoEffect(){
        return super.hasNoEffect() && weapons.isEmpty();
    }
}
