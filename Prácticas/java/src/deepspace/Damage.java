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

class Damage {
    private int nShields;
    private int nWeapons;
    private ArrayList<WeaponType> weapons;
    
    //Constructores 
    Damage(int s, int w){
        nWeapons= w;
        nShields= s;
    }
    
    Damage(int s, ArrayList<WeaponType> w){
        nShields= s;
        nWeapons= w.size();
        weapons= w;
    }
    
    Damage(Damage d){
        this(d.nShields, d.weapons);
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
    
    /*
     * @brief Devuelve una versión ajustada del objeto a las colecciones de 
     * armas y potenciadores de escudos suministradas como parámetro.
     * Partiendo del daño representado por el objeto que recibe este mensaje, se devuelve una copia del
     * mismo pero reducida si es necesario para que no implique perder armas o potenciadores de escudos
     * que no están en las colecciones de los parámetros.
    */
    private Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
        nShields= s.size();
        nWeapons= w.size();
        
        //Tenemos que recorrer la colección de armas pasada como parámetro y ajustarla
        // a nuestro arraylist de weapontype
        return this;
    }
    
    /*
     * @brief Devuelve el índice de la posición de la primera arma de la 
     * colección de armas (primer parámetro) cuyo tipo coincida con el tipo indicado
     * por el segundo parámetro. Devuelve -1 si no hay ninguna arma en la 
     * colección del tipo indicado por el segundo parámetro.
    */
    private int arrayContainsType(ArrayList<Weapon> w, WeaponType t){
        return w.indexOf(t);
    }
    
    /*
     * @brief Si la instancia dispone de una lista de tipos concretos de armas,
     * intenta eliminar el tipo del arma pasada como parámetro de esa lista. En otro caso simplemente
     * decrementa en una unidad el contador de armas que deben ser eliminadas. Ese contador no puede
     * ser inferior a cero en ningún caso.
    */
    public void discardWeapon(Weapon w){
        for(int i= 0; i< weapons.size(); i++){
            if(weapons.get(i) == w.getType())
                weapons.remove(i);
            else{
                if(nWeapons > 0)
                    nWeapons--;
            }   
        }
    }
    
    /* 
     * @brief Decrementa en una unidad el número de potenciadores de escudo que
     * deben ser eliminados. Ese contador no puede ser inferior a cero en ningún caso.
    */
    public void discardShieldBooster(){
        if(nShields > 0)
            nShields--;
    }
    
    /* 
     * @brief Devuelve true si el daño representado no tiene ningún efecto, no 
     * implica la pérdida de ningún tipo de accesorio (armas o potenciadores de escudo).
    */
    public boolean hasNoEffect(){
        return nWeapons== 0 && nShields == 0;
    }
    
    
    
    
    
}
