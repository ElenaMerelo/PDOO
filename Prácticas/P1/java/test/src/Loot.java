/**
 * @author elena
 * @brief Representa el botín que se obtiene al vencer a una nave enemiga. Puede incluir cantidades
 * que representen un número de paquetes de suministros, armas, potenciadores de escudo, hangares
 * y/o medallas.
*/

class Loot {
    private int nSupplies, nWeapons, nShields, nHangars, nMedals;
        
    Loot(int supplies, int weapons, int shields, int hangars, int medals){
        nSupplies= supplies;
        nWeapons= weapons;
        nShields= shields;
        nHangars= hangars;
        nMedals= medals;
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
}
