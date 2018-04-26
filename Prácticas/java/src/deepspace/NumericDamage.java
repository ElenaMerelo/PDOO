package deepspace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author elena
 */
public class NumericDamage extends Damage {
    private int nWeapons;
    
    //Constructores
    NumericDamage(int nw, int ns){
        super(ns);
        nWeapons= nw;
    }
    
    @Override
    public NumericDamageToUI getUIversion(){
        return new NumericDamageToUI(this);
    }
    
    public int getNWeapons(){
        return nWeapons;
    }
    
    /**
     * @brief Devuelve una versión ajustada del objeto a las colecciones de 
     * armas y potenciadores de escudos suministradas como parámetro.
     * Partiendo del daño representado por el objeto que recibe este mensaje, se devuelve una copia del
     * mismo pero reducida si es necesario para que no implique perder armas o potenciadores de escudos
     * que no están en las colecciones de los parámetros.
    */
    public NumericDamage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
        int n_shields= Math.min(s.size(), super.getNShields());
        int n_weapons= Math.min(nWeapons, w.size());
        
        return new NumericDamage(n_weapons, n_shields);
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
