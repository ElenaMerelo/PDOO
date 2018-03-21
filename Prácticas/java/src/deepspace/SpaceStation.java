/** 
 * @author Elena Merelo
 */
package deepspace;

import java.util.ArrayList;

class SpaceStation {
    private final int MAXFUEL= 100;
    private final float SHIELDLOSSPERUNITSHOT= 0.1f;    
    private float ammoPower, fuelUnits, shieldPower;
    private String name;
    private int nMedals;
    private Damage pendingDamage;
    private ArrayList<Weapon> weapons;
    private ArrayList<ShieldBooster> shieldBoosters;
    private Hangar hangar;
    
    /**
     * @brief Fija la cantidad de combustible al valor pasado como parámetro sin
     * que nunca se exceda el límite.
     */
    private void assignFuelValue(float f){
        if(f < MAXFUEL)
            fuelUnits= f;
    }
    
    /**
     * @brief Si el daño pendiente (pendingDamage) no tiene efecto fija la
     * referencia al mismo a null.
     */
    private void cleanPendingDamage(){
        if(pendingDamage.hasNoEffect())
            pendingDamage= null;
    }
    
    //Constructor
    SpaceStation(String n, SuppliesPackage supplies){
        name= n;
        ammoPower= supplies.getAmmoPower();
        fuelUnits= supplies.getFuelUnits();
        shieldPower= supplies.getShieldPower();
        
    }
}
