/**
 * @author Elena Merelo
 * @brief Prueba del funcionamiento de la práctica 1
 */
package deepspace;

public class TestP1 {
    public static void main(String args[]){
        Loot l= new Loot(2, 533, 1000, 46, 1);
        System.out.println(l.getNSupplies() + " supplies, " + l.getNWeapons() +
              " weapons, " + l.getNShields() + " shields, " +
                + l.getNHangars() + " hangars, " + l.getNMedals() + " medals.");
        
        System.out.println(l);
       
    }
}
