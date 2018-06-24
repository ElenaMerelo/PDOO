/**
 * @author elena
 * @brief Representa el botín que se obtiene al vencer a una nave enemiga. Puede incluir cantidades
 * que representen un número de paquetes de suministros, armas, potenciadores de escudo, hangares
 * y/o medallas.
*/
package deepspace;

class Loot {
    private int nSupplies, nWeapons, nShields, nHangars, nMedals;
    private boolean getEfficient, spaceCity;
    
    Loot(int supplies, int weapons, int shields, int hangars, int medals){
        this.nSupplies= supplies;
        this.nWeapons= weapons;
        this.nShields= shields;
        this.nHangars= hangars;
        this.nMedals= medals;
        this.getEfficient= false;
        this.spaceCity= false;
    }
    
    Loot(int supplies, int weapons, int shields, int hangars, int medals, boolean ef, boolean city){
        this(supplies, weapons, shields, hangars, medals);
        this.getEfficient= ef;
        this.spaceCity= city;
    }
    
    Loot(Loot l){
        this(l.nSupplies, l.nWeapons, l.nShields, l.nHangars, l.nMedals, l.getEfficient, l.spaceCity);
    }

    //Consultores 
    public int getNSupplies(){
        return nSupplies;
    }

    public int getNWeapons(){
        return nWeapons;
    }

    public int getNShields(){
        return nShields;
    }

    public int getNHangars(){
        return nHangars;
    }

    public int getNMedals(){
        return nMedals;
    }
    
    public boolean getEfficient(){
        return getEfficient;
    }
    
    public boolean spaceCity(){
        return spaceCity;
    }
    
    public String toString(){
        return "Loot: " + nSupplies + " supplies, " + nWeapons + " weapons, " + nShields
                + " shields, " + nHangars + " hangars, " + nMedals + " medals, getEfficient: " + getEfficient + "spaceCity: " + spaceCity;
    }
    
    LootToUI getUIversion(){
        return new LootToUI(this);
    }
}
