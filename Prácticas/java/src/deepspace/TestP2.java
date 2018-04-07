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
        
        //Prueba de los constructores
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
        
         
         
    }
    
}
