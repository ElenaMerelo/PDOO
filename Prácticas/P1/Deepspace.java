/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

/**
 *
 * @author elena
 */

public class Deepspace {
    /**
     * @brief Representa todos los resultados posibles de un combate entre una estación espacial y una nave enemiga.
     */
    public enum CombatResult { ENEMYWINS, NOCOMBAT, STATIONSCAPES, STATIONWINS }

    /**
     * @brief Representa a los dos tipos de personajes del juego 
     */
    public enum GameCharacter { ENEMYSTARSHIP, SPACESTATION }
    
    /**
     * @brief Representa el resultado de un disparo recibido por una nave enemiga o una estación espacial.
     */
    public enum ShotResult { DONOTRESIST, RESIST }
    
    /**
     * @brief Representa los tipos de armas del juego y su potencia de disparo.
     */
    public enum WeaponType {
        LASER(2.0), MISSILE(3.0), PLASMA(4.0);
        
        private float power;
        
        WeaponType(float another_power){
            this.power= another_power;
        }
        
        float getPower(){
            return power;
        }
        
    }
    
    /**
     * @brief Representa el botín que se obtiene al vencer a una nave enemiga. Puede incluir cantidades
     * que representen un número de paquetes de suministros, armas, potenciadores de escudo, hangares
     * y/o medallas.
     */
    class Loot{
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
    
    /**
     * @brief Representa un paquete de suministros para una estación espacial. Puede contener
     * armamento, combustible y/o energía para los escudos.
    */
    class SuppliesPackage{
        private float ammoPower, fuelUnits, shieldPower;
        
        SuppliesPackage(float ammo, float fuel, float power){
            ammoPower= ammo;
            fuelUnits= fuel;
            shieldPower= power;
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
