/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

import java.util.ArrayList;

/**
 *
 * @author Profesor
 */
public class DamageToUI {
    private int nWeapons;
    private ArrayList<WeaponType> weapons;
    private int nShields;

    DamageToUI(Damage d) {
        nWeapons=d.getNWeapons();
        nShields=d.getNShields();
        ArrayList<WeaponType> tmp=d.getWeapons();
        if (tmp!=null) {
            weapons=(ArrayList<WeaponType>) (tmp.clone());
        }
        else
            weapons=null;
    }
    
    

    public int getNWeapons() {
        return nWeapons;
    }

    public ArrayList<WeaponType> getWeapons() {
        return weapons;
    }

    public int getNShields() {
        return nShields;
    }
    
    public String getWeaponInfo() {
      String out = "";
      
      if (nWeapons == -1) {
          out += weapons.toString();
      } else {
          out += nWeapons;
      }
      return out;
    }
    
}
