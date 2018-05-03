package deepspace;

import java.util.ArrayList;

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
    
    /**
     * @brief Devuelve una versión ajustada del objeto a las colecciones de 
     * armas y potenciadores de escudos suministradas como parámetro.
     * Partiendo del daño representado por el objeto que recibe este mensaje, se devuelve una copia del
     * mismo pero reducida si es necesario para que no implique perder armas o potenciadores de escudos
     * que no están en las colecciones de los parámetros.
    */
    @Override
    public NumericDamage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
        int n_shields= Math.min(s.size(), super.getNShields());
        int n_weapons= Math.min(nWeapons, w.size());
        
        return new NumericDamage(n_weapons, n_shields);
    }
    
    /**
     * @brief Si la instancia dispone de una lista de tipos concretos de armas,
     * intenta eliminar el tipo del arma pasada como parámetro de esa lista. En otro caso simplemente
     * decrementa en una unidad el contador de armas que deben ser eliminadas. Ese contador no puede
     * ser inferior a cero en ningún caso.
    */
    @Override
    public void discardWeapon(Weapon w){
        if(nWeapons > 0)
            nWeapons--;    
    }
    
    /**
     * @brief Devuelve true si el daño representado no tiene ningún efecto, no 
     * implica la pérdida de ningún tipo de accesorio (armas o potenciadores de escudo).
    */
    @Override
    public boolean hasNoEffect(){
        return super.hasNoEffect() && nWeapons == 0;
    }
}
