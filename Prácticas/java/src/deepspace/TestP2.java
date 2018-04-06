/**
 * @author Elena Merelo
 */

package deepspace;

import java.util.ArrayList;
import java.util.Arrays;

class TestP2 {
    public static void main(String args[]){
        Weapon l= new Weapon("l", WeaponType.LASER, 3);
        Weapon m= new Weapon("m", WeaponType.MISSILE, 2);
        Weapon p= new Weapon("p", WeaponType.PLASMA, 1);
        
        ArrayList<Weapon> w= new ArrayList<>(Arrays.asList(l, m, p));
        
        //Hangar
        Hangar h1= new Hangar(5);
        Hangar h2= new Hangar(h1);

        if(h1.getMaxElements() != 5 || !h1.getWeapons().isEmpty() || !h1.getShieldBoosters().isEmpty())
            System.out.println("Error construyendo h1");

        if(h2.getMaxElements() != 5 || !h2.getWeapons().isEmpty() || !h2.getShieldBoosters().isEmpty())
            System.out.println("Error construyendo h2");
        
        for(Weapon i: w){
            h1.addWeapon(i);
        }
         
         
         
         
         
         
    }
    
}
