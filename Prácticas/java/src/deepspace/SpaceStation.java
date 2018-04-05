/** 
 * @author Elena Merelo
 */
package deepspace;

import java.util.ArrayList;

class SpaceStation {
    private static final int MAXFUEL= 100;
    private static final float SHIELDLOSSPERUNITSHOT= 0.1f;    
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
    
    public boolean receiveWeapon(Weapon w){
        if(hangar != null)
           return hangar.addWeapon(w);
        
        return false;
    }
    
    public boolean receiveShieldBooster(ShieldBooster s){
        if(hangar != null)
            return hangar.addShieldBooster(s);
        return false;       
    }
    
    public void receiveHangar(Hangar h){
        if(hangar == null)
            hangar= h;
    }
    
    public void discardHangar(){
        hangar= null;
    }
    
    public void receiveSupplies(SuppliesPackage s){
        ammoPower += s.getAmmoPower();
        shieldPower += s.getShieldPower();
        assignFuelValue(fuelUnits + s.getFuelUnits());
    }
    
    public void setPendingDamage(Damage d){
        pendingDamage= d.adjust(weapons, shieldBoosters);
    }
    
    public void mountWeapon(int i){
        if(hangar != null)
            if(hangar.removeWeapon(i) != null)
                weapons.add(hangar.removeWeapon(i));
    }
    
    public void mountShieldBooster(int i){
        if(hangar != null)
            if(hangar.removeShieldBooster(i) != null)
                shieldBoosters.add(hangar.removeShieldBooster(i));
    }
    
    public void discardWeaponInHangar(int i){
        if(hangar != null)
            hangar.removeWeapon(i);  
    }
    
    public void discardShieldBoosterInHangar(int i){
        if(hangar != null)
            hangar.removeShieldBooster(i);  
    }
    
    public float getSpeed(){
        return fuelUnits/MAXFUEL;
    }
    
    public void move(){
        if(fuelUnits - fuelUnits*getSpeed() <= 0)
            fuelUnits= 0;
        else
            fuelUnits -= fuelUnits*getSpeed();
    }
    
    public boolean validState(){
        return pendingDamage == null || pendingDamage.hasNoEffect() == true;
    }
    
    public void cleanUpMountedItems(){
        for(Weapon w: weapons)
    }
    
    
}





