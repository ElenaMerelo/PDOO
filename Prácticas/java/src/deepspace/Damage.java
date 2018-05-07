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

public abstract class Damage {
    private int nShields;
    
    Damage(int n){
        nShields= n;
    }
    
    public int getNShields(){
        return nShields;
    }
    
    public void discardShieldBooster(){
        if(nShields > 0)
            nShields--;
    }
    
    public boolean hasNoEffect(){
        return nShields == 0;
    }
    
    public int adjust_shields(ArrayList<ShieldBooster> s){
        return Math.min(s.size(), nShields);
    }
    
    @Override
    public String toString(){
        return "nShields- " + nShields;
    }
    
    public abstract DamageToUI getUIversion();
   
    public abstract Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s);
    
    public abstract void discardWeapon(Weapon w);
    
    public abstract Damage copy(Damage d);


}
