/**
 * @author Elena Merelo
 * @brief Los objetos de esta clase representan el daño producido a una estación espacial por una nave
 * enemiga cuando se pierde un combate. Cada instancia indicará la pérdida de una cantidad de
 * potenciadores de escudo y por otro lado, o bien una cantidad de tipos indeterminados de armas o un
 * conjunto de tipos de armas concretas que se deben eliminar.
 * Todas las instancias deben ser unas independientes de otras y por lo tanto no deben compartir
 * instancias de objetos mutables (modificables).
 */

package deepspace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

class Damage {
    private int nShields;
    private int nWeapons;
    private ArrayList<WeaponType> weapons;
    
    //Constructores
    private Damage(int nw, int ns, ArrayList<WeaponType> w){
        nShields= ns;
        
        if(w != null){
            weapons= new ArrayList<>(w);
            nWeapons= 0;
        }
        else{
            weapons= null;
            nWeapons= nw;
        }
    }
    
    Damage(int w, int s){
        this(w, s, null);
    }
    
    Damage(ArrayList<WeaponType> w, int s){
        this(0, s, w);
    }
    
    Damage(Damage d){
        this(d.getNWeapons(), d.getNShields(), d.getWeapons());   
    }
    
    //Getters
    DamageToUI getUIversion(){
        return new DamageToUI(this);
    }
    
    public int getNShields(){
        return nShields;
    }
    
    public int getNWeapons(){
        return nWeapons;
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
        int n_shields= Math.min(s.size(), nShields);
        
        if(weapons != null){
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
            return new Damage(adjusted, n_shields);
                
        }
       
        else{
            int n_weapons= Math.min(nWeapons, w.size());
            return new Damage(n_weapons, n_shields);
        }
        
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
        if(weapons != null)    //Si tenemos una lista de tipos concretos de armas
            weapons.remove(w.getType());
        
        else{
            if(nWeapons > 0)
                nWeapons--;
        }    
    }
    
    
    /** 
     * @brief Decrementa en una unidad el número de potenciadores de escudo que
     * deben ser eliminados. Ese contador no puede ser inferior a cero en ningún caso.
    */
    public void discardShieldBooster(){
        if(nShields > 0)
            nShields--;
    }
    
    /**
     * @brief Devuelve true si el daño representado no tiene ningún efecto, no 
     * implica la pérdida de ningún tipo de accesorio (armas o potenciadores de escudo).
    */
    public boolean hasNoEffect(){
        if(weapons == null)
            return nWeapons== 0 && nShields == 0;
        else 
            return weapons.isEmpty() && nShields ==  0;
    }
    
}
