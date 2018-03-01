/**
 * @author Elena Merelo
 * @brief Prueba del funcionamiento de la práctica 1
 */
package deepspace;

public class TestP1 {
    public static void main(String args[]){
        //Prueba de la clase Loot
        Loot l= new Loot(2, 533, 1000, 46, 1);
        System.out.println(l.getNSupplies() + " supplies, " + l.getNWeapons() +
              " weapons, " + l.getNShields() + " shields, " +
                + l.getNHangars() + " hangars, " + l.getNMedals() + " medals.");
        
        System.out.println(l);
       
        //Prueba de la clase SuppliesPackage 
        SuppliesPackage s1= new SuppliesPackage(1.3f, 6.666666f, 9.234f);
        SuppliesPackage s2= new SuppliesPackage(s1);
        
        System.out.println("s1: " + s1.getAmmoPower() + " ammoPower, " + s1.getFuelUnits() +
              " fuelUnits, " + s1.getShieldPower() + " shieldPower." );
        
        System.out.println("s2: " + s2.getAmmoPower() + " ammoPower, " + s2.getFuelUnits() +
              " fuelUnits, " + s2.getShieldPower() + " shieldPower." );
        
        //Prueba de la clase ShieldBooster 
        ShieldBooster sh1= new ShieldBooster("Chachi shield", 45.67f, 3);
        ShieldBooster sh2= new ShieldBooster(sh1);
        
        System.out.println("sh1: " + sh1.getName() + ": " + sh1.getBoost() + " boost, " + 
                sh1.getUses() + " uses." );
        
        System.out.println("sh2: " + sh2.getName() + ": " + sh2.getBoost() + " boost, " + 
                sh2.getUses() + " uses." );
        
        for(int i= 0; i< 4; i++){
            System.out.println("useIt(): " + sh1.useIt());
            System.out.println(sh1);
        }
        
        //Prueba de la clase Weapon 
        Weapon w1= new Weapon("patata nuclear", WeaponType.MISSILE, 2);
        Weapon w2= new Weapon(w1);
        
        System.out.println("w1: Type: " + w1.getType() + ", uses: " + w1.getUses() 
                + ", name: " + w1.getName());
        
        System.out.println("w2: Type: " + w2.getType() + ", uses: " + w2.getUses() 
                + ", name: " + w2.getName());
        
        for(int i= 0; i< 4; i++){
            System.out.println("Use: " + w1.useIt());
            System.out.println(w1);
        }
        
        //Prueba de la clase Dice 
        Dice d1= new Dice();
        
        System.out.println("Game started with " + d1.initWithNHangars() + " hangars, "
                + d1.initWithWeapons() + " weapons, " + d1.initWithNShields() + " shields.");
    }
}
