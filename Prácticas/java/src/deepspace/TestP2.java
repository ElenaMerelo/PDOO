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
        
        ArrayList<Weapon> w1= new ArrayList<>(Arrays.asList(l));
        ArrayList<Weapon> w2= new ArrayList<>(Arrays.asList(l, m));
        ArrayList<Weapon> w3= new ArrayList<>(Arrays.asList(l, m, p));
        ArrayList<ArrayList<Weapon>> w= new ArrayList<>(Arrays.asList(w1, w2, w3));
        
        ShieldBooster sb1= new ShieldBooster("sb1", 2.3f, 3);
        ShieldBooster sb2= new ShieldBooster("sb2", 3.2f, 2);
        ArrayList<ShieldBooster> s1= new ArrayList<>(Arrays.asList(sb1));
        ArrayList<ShieldBooster> s2= new ArrayList<>(Arrays.asList(sb1, sb2));
        ArrayList<ArrayList<ShieldBooster>> s= new ArrayList<>(Arrays.asList(s1, s2));
        
        /*-----------------------------Hangar---------------------------------*/
        Hangar h1= new Hangar(5);
        Hangar h2= new Hangar(h1);
        
        //constructores
        if(h1.getMaxElements() != 5 || !h1.getWeapons().isEmpty() || !h1.getShieldBoosters().isEmpty())
            System.out.println("Error construyendo h1");

        if(h2.getMaxElements() != 5 || !h2.getWeapons().isEmpty() || !h2.getShieldBoosters().isEmpty())
            System.out.println("Error construyendo h2");
        
        //addWeapon
        int j= 0;
        
        for(Weapon i: w3){
            if(!h1.addWeapon(i))
                System.out.println("No hay más espacio en el hangar");
            
            if(!w.get(j).equals(h1.getWeapons()))
                System.out.println("Error al añadir weapon a h1");
            
            j++;
        }
        
        //addShieldBooster
        j= 0;
        
        for(ShieldBooster i: s2){
            if(!h1.addShieldBooster(i))
                System.out.println("No hay más espacio en el hangar");
            
            if(!s.get(j).equals(h1.getShieldBoosters()))
                System.out.println("Error al añadir shieldBooster iteración " + j);
            
            j++;
        }
        
        if(h1.addShieldBooster(sb2))
            System.out.println("Hay espacio en el hangar");
        
        //removeWeapon
        int n_weapons= h1.getWeapons().size();
        
        if(h1.removeWeapon(n_weapons) != null || h1.removeWeapon(-1) != null)
            System.out.println("Hay un arma en h1.getWeapons().size() o en la posición -1");
        
        //Eliminamos elemento en la mitad
        ArrayList<Weapon> w4= new ArrayList<>(Arrays.asList(l, p));
        if(!h1.removeWeapon(n_weapons -2).equals(m))
            System.out.println("Error al eliminar weapon de la mitad");
        
        if(!h1.getWeapons().equals(w4))
            System.out.println("No se ha modificado h1.weapons tras eliminar weapon de la mitad");
        
        //Eliminamos elemento al final 
        n_weapons= h1.getWeapons().size();
        if(!h1.removeWeapon(n_weapons -1).equals(p))
            System.out.println("Error al eliminar weapon del final");
        
        if(!h1.getWeapons().equals(w1))
            System.out.println("No se ha modificado h1.weapons tras eliminar weapon del final");
        
        //Eliminamos el elemento restante 
        n_weapons= h1.getWeapons().size();
        if(!h1.removeWeapon(n_weapons -1).equals(l))
            System.out.println("Error al eliminar weapon restante");
        
        if(!h1.getWeapons().isEmpty())
            System.out.println("No se ha modificado h1.weapons tras eliminar weapon del final");
        
        //removeShieldBooster 
        int n_shield_boosters= h1.getShieldBoosters().size();
        
        if(h1.removeShieldBooster(n_shield_boosters) != null || h1.removeShieldBooster(-1) != null)
            System.out.println("Hay un arma en h1.getShieldBoosters().size()");
        
        //Eliminamos elemento del final
        if(!h1.removeShieldBooster(n_shield_boosters -1).equals(sb2))
            System.out.println("Error al eliminar shield booster del final");
        
        if(!h1.getShieldBoosters().equals(s1))
            System.out.println("No se ha modificado h1.shieldBoosters tras eliminar del final");
        
        //Eliminamos elemento al final 
        n_shield_boosters= h1.getShieldBoosters().size();
        if(!h1.removeShieldBooster(n_shield_boosters -1).equals(sb1))
            System.out.println("Error al eliminar shield booster del final");
        
        if(!h1.getShieldBoosters().isEmpty())
            System.out.println("No se ha modificado h1.shieldBoosters tras eliminar elemento restante");
        
        /*-----------------------------Damage---------------------------------*/ 
        WeaponType laser= WeaponType.LASER;
        WeaponType missile= WeaponType.MISSILE;
        WeaponType plasma= WeaponType.PLASMA;
        
        ArrayList<WeaponType> wt= new ArrayList<>(Arrays.asList(laser, laser, laser, missile, missile, plasma));
        
        //constructores 
        Damage d1= new Damage(3, 1);
        Damage d3= new Damage(wt, 2);
        Damage d1_copy= new Damage(d1);
        Damage d3_copy= new Damage(d3);
        
        if(d1.getNShields() != 1 || d1.getNWeapons() != 3 || d1.hasNoEffect() || d1.getWeapons() != null)
            System.out.println("Error al construir d1");
        
        if(d3.getNShields() != 2 || !d3.getWeapons().equals(wt) || d3.hasNoEffect() || d3.getNWeapons() != 0)
            System.out.println("Error al construir d3");
        
        if(d1_copy.getNShields() != 1 || d1_copy.getNWeapons() != 3 || d1_copy.hasNoEffect() || d1_copy.getWeapons() != null)
            System.out.println("Error al construir d1_copy");
        
        if(d3_copy.getNShields() != 2 || !d3_copy.getWeapons().equals(wt) || d3_copy.hasNoEffect() || d3_copy.getNWeapons() != 0)
            System.out.println("Error al construir d3_copy");
        
        //adjust
        ArrayList<Weapon> w5= new ArrayList<>(Arrays.asList(l, l, m, m, m));
       
        if(d1.adjust(w5, s2).getNWeapons() != 3 || d1.adjust(w5,s2).getNShields() != 1 || d1.adjust(w5,s2).getWeapons() != null)
            System.out.println("Error en primer adjust de d1");
        
        if(d1.adjust(w2, s1).getNWeapons() != 2 || d1.adjust(w2,new ArrayList<ShieldBooster>()).getNShields() != 0 || d1.adjust(w2,s1).getWeapons() != null )
            System.out.println("Error en segundo adjust de d1");
        
        ArrayList<WeaponType> adjusted= new ArrayList<>(Arrays.asList(laser, laser, missile, missile));
        if(d3.adjust(w5, s1).getNWeapons() != 0 || d3.adjust(w5, s1).getNShields() != 1 || !d3.adjust(w5, s1).getWeapons().equals(adjusted) )
            System.out.println("Error en adjust de d3");
        
        //discard* en caso de numericWeapons
        for(int i= 0; i< 3; i++){
            d1.discardWeapon(l);
            if(d1.getNWeapons() != 3- i -1)
                System.out.println("Error en discardWeapon de d1 iteración " + i + "d1.getNWeapons(): " + d1.getNWeapons());
        }
        
        d1.discardShieldBooster();
        if(d1.getNShields() != 0 || !d1.hasNoEffect())
            System.out.println("Error en discardShieldBooster");
        
        //discard* en caso de specificWeapons
        d3.discardWeapon(l);
        
        if(!d3.getWeapons().equals(new ArrayList<WeaponType>(Arrays.asList(laser, laser, missile, missile, plasma))))
            System.out.println("Error en discardWeapon(l) de d3, d3.getWeapons: " + d3.getWeapons());
        
        d3.discardWeapon(m);
        
        if(!d3.getWeapons().equals(new ArrayList<WeaponType>(Arrays.asList(laser, laser, missile, plasma))))
            System.out.println("Error en discardWeapon(l) de d3, d3.getWeapons: " + d3.getWeapons());
        
        d3.discardWeapon(p);
        
        if(!d3.getWeapons().equals(new ArrayList<WeaponType>(Arrays.asList(laser, laser, missile))))
            System.out.println("Error en discardWeapon(l) de d3, d3.getWeapons: " + d3.getWeapons());
        
        d3.discardWeapon(l);
        d3.discardWeapon(l);
        d3.discardWeapon(m);
        
        if(!d3.getWeapons().equals(new ArrayList<>()))
            System.out.println("Error en discardWeapon(l) de d3, d3.getWeapons: " + d3.getWeapons());
        
        d3.discardShieldBooster();
        
        if(d3.getNShields() != 1)
            System.out.println("Error en discarShieldBooster de d3");
        
        d3.discardShieldBooster();
        
        if(!d3.hasNoEffect())
            System.out.println("Error en hasNoEffect de d3");
    
        /*----------------------------EnemyStarShip--------------------------------*/ 
        Damage d2= new Damage(7, 3);
        Damage d4= new Damage(wt, 2);
        Loot l1= new Loot(1, 2, 3, 4, 5);

        EnemyStarShip e1= new EnemyStarShip("e1", 1.2f, 3.4f, l1, d2);
        EnemyStarShip e2= new EnemyStarShip("e2", 2.2f, 1.1f, l1, d4);
        EnemyStarShip e1_copy= new EnemyStarShip(e1);
        EnemyStarShip e2_copy= new EnemyStarShip(e2);
        
        //Constructores 
        if(!e1.getName().equals("e1") || e1.getAmmoPower() != 1.2f || e1.getShieldPower() != 3.4f || !e1.getLoot().equals(l1) || !e1.getDamage().equals(d2))
            System.out.println("Error en constructor de e1");
        
        if(!e2.getName().equals("e2") || e2.getAmmoPower() != 2.2f || e2.getShieldPower() != 1.1f || !e2.getLoot().equals(l1) || !e2.getDamage().equals(d4))
            System.out.println("Error en constructor de e2");
        
        if(!e1_copy.getName().equals("e1") || e1_copy.getAmmoPower() != 1.2f || e1_copy.getShieldPower() != 3.4f || !e1_copy.getLoot().equals(l1) || !e1_copy.getDamage().equals(d2))
            System.out.println("Error en constructor de e1_copy");
        
        if(!e2_copy.getName().equals("e2") || e2_copy.getAmmoPower() != 2.2f || e2_copy.getShieldPower() != 1.1f || !e2_copy.getLoot().equals(l1) || !e2_copy.getDamage().equals(d4))
            System.out.println("Error en constructor de e2_copy");
        
        //fire and protection 
        if(e1.fire() != e1.getAmmoPower() || e2.fire() != e2.getAmmoPower())
            System.out.println("Error en fire");
        
        if(e1.protection() != e1.getShieldPower() || e2.protection() != e2.getShieldPower())
            System.out.println("Error en protection");
        
        //receiveShot
        if(!e1.receiveShot(3.5f).equals(ShotResult.DONOTRESIST))
            System.out.println("Error en receiveShot cuando shot> shieldPower");
        
        if(!e1.receiveShot(3.4f).equals(ShotResult.RESIST))
            System.out.println("Error en receiveShot cuando shot< shieldPower");
        
        
        
        
        
    }
}
