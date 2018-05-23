/**
 * @author Elena Merelo
 */

package deepspace;

import java.util.ArrayList;

class Hangar{
    private int maxElements;
    private ArrayList<Weapon> weapons;
    private ArrayList<ShieldBooster> shieldBoosters;
    
    //Constructores 
    Hangar(int capacity){
        maxElements= capacity;
        weapons= new ArrayList<>();
        shieldBoosters= new ArrayList<>();
    }
    
    Hangar(Hangar h){
        maxElements= h.maxElements;
        weapons= new ArrayList<>(h.weapons);
        shieldBoosters= new ArrayList<>(h.shieldBoosters);
    }
    
    //getters
    HangarToUI getUIversion(){
        return new HangarToUI(this);
    }
    
    public int getMaxElements(){
        return maxElements;
    }
    
    public ArrayList<Weapon> getWeapons(){
        return weapons;
    }
    
    public ArrayList<ShieldBooster> getShieldBoosters(){
        return shieldBoosters;
    }
    
    /**
     * @brief  Devuelve true si aún hay espacio para añadir elementos y por lo
     * tanto no se ha llegado a la capacidad máxima.
    */
    private boolean spaceAvalaible(){
        return weapons.size() + shieldBoosters.size() < maxElements;
    }
    
    /**
     * @brief Añade el arma al hangar si queda espacio en el Hangar, devolviendo 
     * true en ese caso. Devuelve false en cualquier otro caso.
    */
    public boolean addWeapon(Weapon w){
        if(spaceAvalaible() == true){
            weapons.add(w);
            return true;
        }
        return false;
    }
    
    /**
     * @brief Añade el potenciador de escudo al hangar si queda espacio. Devuelve 
     * true si ha sido posible añadir el potenciador, false en otro caso.
    */
    public boolean addShieldBooster(ShieldBooster s){
        if(spaceAvalaible() == true){
            shieldBoosters.add(s);
            return true;
        }
        return false;
    }
    
    /** 
     * @brief Elimina el arma número w del hangar y la devuelve, siempre que
     * ésta exista. Si el índice suministrado es incorrecto devuelve null.
    */
    public Weapon removeWeapon(int w){
        if(w >= 0 && w < weapons.size())
            return weapons.remove(w);
        
        return null; 
    }
    
    /**
     * @brief Elimina el potenciador de escudo número s del hangar y lo devuelve, 
     * siempre que éste exista. Si el índice suministrado es incorrecto devuelve null.
    */
    public ShieldBooster removeShieldBooster(int s){
        if(s >= 0 && s < shieldBoosters.size())
           return shieldBoosters.remove(s);
        
        return null;  
    }
    
    
    public String toString(){
        String s= "Hangar-- maxElements: " + maxElements + ", shieldBoosters: " + shieldBoosters;
        StringBuilder sb = new StringBuilder("Weapons: ");
        // Append each weapon to the returning String
        for(Weapon w: weapons)
            sb.append(w).append("\n");
        return s + sb.toString();
    
    }
}




