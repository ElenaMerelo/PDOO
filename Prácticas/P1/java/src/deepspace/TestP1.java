/**
 * @author Elena Merelo
 * @brief Prueba del funcionamiento de la práctica 1
 */
package deepspace;

//Para leer datos desde teclado
import java.util.Scanner;

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
            System.out.println(sh1);
            System.out.println("useIt(): " + sh1.useIt());
        }
        
        //Prueba de la clase Weapon 
        //MISSILE
        Weapon w1= new Weapon("patata nuclear", WeaponType.MISSILE, 2);
        Weapon w2= new Weapon(w1);
        
        System.out.println("w1: Type: " + w1.getType() + ", uses: " + w1.getUses() 
                + ", name: " + w1.getName());
        
        System.out.println("w2: Type: " + w2.getType() + ", uses: " + w2.getUses() 
                + ", name: " + w2.getName());
        
        for(int i= 0; i< 4; i++){
            System.out.println(w1);
            System.out.println("Use: " + w1.useIt());
        }
        
        //LASER
        Weapon l1= new Weapon("Láser tóh potente", WeaponType.LASER, 3);
        Weapon l2= new Weapon(l1);
        
        System.out.println("l1: Type: " + l1.getType() + ", uses: " + l1.getUses() 
                + ", name: " + l1.getName());
        
        System.out.println("l2: Type: " + l2.getType() + ", uses: " + l2.getUses() 
                + ", name: " + l2.getName());
        
        for(int i= 0; i< 4; i++){
            System.out.println(l1);
            System.out.println("Use: " + l1.useIt());
        }
        
        //PLASMA
        Weapon p1= new Weapon("Te vas a quedar plasmado", WeaponType.PLASMA, 1);
        Weapon p2= new Weapon(p1);
        
        System.out.println("p1: Type: " + p1.getType() + ", uses: " + p1.getUses() 
                + ", name: " + p1.getName());
        
        System.out.println("p2: Type: " + p2.getType() + ", uses: " + p2.getUses() 
                + ", name: " + p2.getName());
        
        for(int i= 0; i< 4; i++){
            System.out.println(p1);
            System.out.println("Use: " + p1.useIt());
        }
        
        /*Crea una instancia de la clase Dice, llama a cada método 100 veces y 
        calcula cuantas veces se obtiene cada uno de los valores posibles. 
        Comprueba si se cumplen a nivel práctico las instrucciones relativas a 
        las probabilidades de cada evento.*/
        Dice d= new Dice();
        Scanner reader= new Scanner (System.in);
        System.out.print("Introduzca número de jugadores: ");
        int num_players= reader.nextInt();
        
        int prob_hangar_0= 0, prob_hangar_1= 0, prob_shield_0= 0, prob_shield_1= 0;
        int prob_weapon_1= 0, prob_weapon_2= 0, prob_weapon_3= 0, prob_true= 0, prob_false= 0;
        float speed= 0.75f;
        int prob_space_station= 0, prob_enemy_starship= 0;
        
        for(int i= 0; i< 100; i++){
            //Prueba de initWithNHangars()
            if(d.initWithNHangars() == 0)
               prob_hangar_0++;
            
            if(d.initWithNHangars() == 1)
                prob_hangar_1++;
            
            //Prueba de initWithNWeapons()
            if(d.initWithNWeapons() == 1)
               prob_weapon_1++;
  
            if(d.initWithNWeapons() == 2)
                prob_weapon_2++;
            
            if (d.initWithNWeapons() == 3)
                prob_weapon_3++;
            
            
            //Prueba de initWithNShields
            if(d.initWithNShields() == 0)
               prob_shield_0++;
            
            if(d.initWithNShields() == 1)
                prob_shield_1++;
            
            //Prueba de whoStarts()
            System.out.println("Empieza el jugador: " + d.whoStarts(num_players));
            
            //Prueba de firstShot()
            if(d.firstShot() == GameCharacter.SPACESTATION)
                prob_space_station++;
            
            if(d.firstShot() == GameCharacter.ENEMYSTARSHIP)
                prob_enemy_starship++;
            
            //Prueba de spaceStationMoves()
            if(d.spaceStationMoves(speed) == true)
                prob_true++;
           
            if(d.spaceStationMoves(speed) == false)
                prob_false++;
        }
        
        System.out.println("Hay un " + prob_hangar_0 + "% de que salga el hangar 0, y un " + prob_hangar_1 +  "% de que salga el 1");
        System.out.println("Hay un " + prob_weapon_1 + "% de que salga la weapon 1, un " + prob_weapon_2 +  "% de que salga 2 y un " + prob_weapon_3 + "% de que salga 3");
        System.out.println("Hay un " + prob_shield_0 + "% de que salga el shield 0, y un " + prob_shield_1 +  "% de que salga 1");
        System.out.println("Hay un " + prob_true + "% de que se mueve la spaceStation, y un " + prob_false +  "% de que no lo haga");
        System.out.println("Hay un " + prob_space_station + "% de que dispare primero spaceStation, y un " + prob_enemy_starship +  "% de que lo haga enemyStarship");

        
      
        
        
    }
    
}
