/**
 * @author Elena Merelo
 * @brief Prueba del funcionamiento de la práctica 1
 */
package deepspace;

//Para leer datos desde teclado
import java.util.Scanner;

public class TestP1 {
    public static void main(String args[]){
        //Loot
        Loot l= new Loot(2, 533, 1000, 46, 1);
        if(l.getNSupplies() != 2)
            System.out.println("Error en getNSupplies");
        
        if(l.getNWeapons() != 533)
            System.out.println("Error en getNWeapons");
        
        if(l.getNShields() != 1000)
            System.out.println("Error en getNShields");
        
        if(l.getNHangars() != 46)
            System.out.println("Error en getNHangars");
        
        if(l.getNMedals() != 1)
            System.out.println("Error en getNMedals");
        
        System.out.println(l);
       
        //SuppliesPackage 
        SuppliesPackage s1= new SuppliesPackage(1.3f, 6.666666f, 9.234f);
        SuppliesPackage s2= new SuppliesPackage(s1);
        
        if(s1.getAmmoPower() != 1.3f && s2.getAmmoPower() != s1.getAmmoPower())
            System.out.println("Error en getAmmoPower de s1");
        
        if(s1.getFuelUnits() != 6.666666f && s2.getFuelUnits() != s1.getFuelUnits())
            System.out.println("Error en getFuelUnits de s1");
        
        if(s1.getShieldPower() != 9.234f && s2.getShieldPower() != s1.getShieldPower())
            System.out.println("Error en getShieldPower de s1");
        
        if(s2.getAmmoPower() != s1.getAmmoPower() || s2.getFuelUnits() != s1.getFuelUnits() || s2.getShieldPower() != s1.getShieldPower())
            System.out.println("Error en constructor de copia de SuppliesPackage");
        
        //ShieldBooster 
        ShieldBooster sh1= new ShieldBooster("Chachi shield", 45.67f, 3);
        ShieldBooster sh2= new ShieldBooster(sh1);
        
        if(sh1.getBoost() != 45.67f)
            System.out.println("Error en getBoost de sh1");
        
        if(sh1.getUses() != 3)
            System.out.println("Error en getUses de sh1");
        
        for(int i= 0; i< 3; i++){
            if(sh1.useIt() != sh1.getBoost())
                System.out.println("Error en useIt iteración " + i);
        }
        if(sh1.useIt() != 1.0f)
            System.out.println("Error en useIt cuando uses = 0");
        
        if(sh2.getBoost() != sh1.getBoost())
            System.out.println("Error en constructor de copia de ShieldBooster");
        
        System.out.println(sh1);
        System.out.println(sh2);
        
        //Weapon 
        //MISSILE
        Weapon w1= new Weapon("patata nuclear", WeaponType.MISSILE, 2);
        Weapon w2= new Weapon(w1);
        
        if(!w1.getName().equals("patata nuclear"))
            System.out.println("Error en getName de w1");
        
        if(WeaponType.MISSILE != w1.getType())
            System.out.println("Error en getType de w1");
        
        if(2 != w1.getUses())
            System.out.println("Error en getUses de w1");
        
        if(w1.power() != 3.0f)
            System.out.println("Error en power de w1");
        
        if(!w2.getName().equals(w1.getName()) || w2.getType() != w1.getType() || w2.getUses() != w1.getUses())
            System.out.println("Error en constructor de copia de Weapon MISSILE");
        
        
        for(int i= 0; i< 2; i++){
            if(w1.useIt() != w1.power())
                System.out.println("Error en useIt de w1, iteración " + i);
        }
        
        if(w1.useIt() != 1.0f)
            System.out.println("Error en useIt de w1 cuando uses = 0");
        
        System.out.println(w1);
        System.out.println(w2);
        
        //LASER
        Weapon l1= new Weapon("Láser tóh potente", WeaponType.LASER, 3);
        Weapon l2= new Weapon(l1);
        
        if(!l1.getName().equals("Láser tóh potente"))
            System.out.println("Error en getName de l1");
        
        if(WeaponType.LASER != l1.getType())
            System.out.println("Error en getType de l1");
        
        if(3 != l1.getUses())
            System.out.println("Error en getUses de l1");
        
        if(l1.power() != 2.0f)
            System.out.println("Error en power de l1");
        
        if(!l2.getName().equals(l1.getName()) || l2.getType() != l1.getType() || l2.getUses() != l1.getUses())
            System.out.println("Error en constructor de copia de Weapon LASER");
        
        
        for(int i= 0; i< 3; i++){
            if(l1.useIt() != l1.power())
                System.out.println("Error en useIt de l1, iteración " + i);
        }
        
        if(l1.useIt() != 1.0f)
            System.out.println("Error en useIt de l1 cuando uses = 0");
        
        System.out.println(l1);
        System.out.println(l2);
        
        //PLASMA
        Weapon p1= new Weapon("Te vas a quedar plasmado", WeaponType.PLASMA, 1);
        Weapon p2= new Weapon(p1);
        
        if(!p1.getName().equals("Te vas a quedar plasmado"))
            System.out.println("Error en getName de p1");
        
        if(WeaponType.PLASMA != p1.getType())
            System.out.println("Error en getType de p1");
        
        if(1 != p1.getUses())
            System.out.println("Error en getUses de p1");
        
        if(p1.power() != 4.0f)
            System.out.println("Error en power de p1");
        
        if(!p2.getName().equals(p1.getName()) || p2.getType() != p1.getType() || p2.getUses() != p1.getUses())
            System.out.println("Error en constructor de copia de Weapon PLASMA");
        
        
        for(int i= 0; i< 1; i++){
            if(p1.useIt() != p1.power())
                System.out.println("Error en useIt de p1, iteración " + i);
        }
        
        if(p1.useIt() != 1.0f)
            System.out.println("Error en useIt de l1 cuando uses = 0");
        
        System.out.println(p1);
        System.out.println(p2);
        
        
        /*
        Enunciado: Crea una instancia de la clase Dice, llama a cada método 100 veces y 
        calcula cuántas veces se obtiene cada uno de los valores posibles. 
        Comprueba si se cumplen a nivel práctico las instrucciones relativas a 
        las probabilidades de cada evento.
        */
        Dice d= new Dice();
        
        Scanner reader= new Scanner (System.in);
        System.out.print("Introduzca número de jugadores: ");
        
        int num_players= reader.nextInt();
        float speed= 0.75f;
        
        /* En la posición 0: prob de que salga 0 en initWithNHangars, pos1: prob de que salga 1,
        pos2: prob de 0 en initWithNShields, pos3: prob de 1, pos4: prob de 1 en initWithNWeapons,
        pos5: prob de 2, pos6: prob de 3, pos7: prob true en spaceStationMoves, pos8: prob false,
        pos9: prob de que salga GameCharacter.SPACESTATION en firstShot, pos10:
        prob de GameCharacter.ENEMYSTARSHIP
        */
        int[] prob;
        
        prob= new int[11];
        
        for(int i= 0; i< 11; i++)
            prob[i]= 0;
       
        for(int i= 0; i< 100; i++){
            //Prueba de initWithNHangars()
            if(d.initWithNHangars() == 0)
               prob[0]++;
            
            else if(d.initWithNHangars() == 1)
                prob[1]++;
            
            //Prueba de initWithNShields
            if(d.initWithNShields() == 0)
               prob[2]++;
            
            else if(d.initWithNShields() == 1)
                prob[3]++;
            
            //Prueba de initWithNWeapons()
            if(d.initWithNWeapons() == 1)
               prob[4]++;
  
            if(d.initWithNWeapons() == 2)
                prob[5]++;
            
            if (d.initWithNWeapons() == 3)
                prob[6]++;
            
            //Prueba de spaceStationMoves()
            if(d.spaceStationMoves(speed) == true)
                prob[7]++;
           
            else if(d.spaceStationMoves(speed) == false)
                prob[8]++;
            
            //Prueba de firstShot()
            if(d.firstShot() == GameCharacter.SPACESTATION)
                prob[9]++;
            
            else if(d.firstShot() == GameCharacter.ENEMYSTARSHIP)
                prob[10]++;
            
            //Prueba de whoStarts()
            if(d.whoStarts(num_players) < 0 || d.whoStarts(num_players) > num_players -1)
                System.out.println("Error en whoStarts iteración " + i);
        }
        
        System.out.println("Hay un " + prob[0] + "% de que salga el hangar 0, y un " + prob[1] +  "% de que salga el 1");
        System.out.println("Hay un " + prob[4] + "% de que salga la weapon 1, un " + prob[5] +  "% de que salga 2 y un " + prob[6] + "% de que salga 3");
        System.out.println("Hay un " + prob[2] + "% de que salga el shield 0, y un " + prob[3] +  "% de que salga 1");
        System.out.println("Hay un " + prob[7] + "% de que se mueve la spaceStation, y un " + prob[8] +  "% de que no lo haga");
        System.out.println("Hay un " + prob[9] + "% de que dispare primero spaceStation, y un " + prob[10] +  "% de que lo haga enemyStarship");

        
      
        
        
    }
    
}
