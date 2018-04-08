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
    
    //Constructor
    SpaceStation(String n, SuppliesPackage supplies){
        name= n;
        ammoPower= supplies.getAmmoPower();
        fuelUnits= supplies.getFuelUnits();
        shieldPower= supplies.getShieldPower();
        nMedals= 0;
        weapons= new ArrayList<>();
        shieldBoosters= new ArrayList<>();
    }
    
    //Getters
    public float getAmmoPower(){
        return ammoPower;
    }
    
    public float getFuelUnits(){
        return fuelUnits;
    }
    
    public Hangar getHangar(){
        return hangar;
    }
    
    public String getName(){
        return name;
    }
    
    public int getNMedals(){
        return nMedals;
    }
    
    public Damage getPendingDamage(){
        return pendingDamage;
    }
    
    public ArrayList<ShieldBooster> getShieldBoosters(){
        return shieldBoosters;
    }
    
    public float getShieldPower(){
        return shieldPower;
    }
    
    public SpaceStationToUI getUIversion(){
        return new SpaceStationToUI(this);
    }
    
    public ArrayList<Weapon> getWeapons(){
        return weapons;
    }
    
    /**
     * @brief Fija la cantidad de combustible al valor pasado como parámetro sin
     * que nunca se exceda el límite.
     */
    private void assignFuelValue(float f){
        if(f < MAXFUEL)
            fuelUnits= f;
        else 
            fuelUnits= MAXFUEL;
    }
    
    /**
     * @brief Si el daño pendiente (pendingDamage) no tiene efecto fija la
     * referencia al mismo a null.
     */
    private void cleanPendingDamage(){
        if(pendingDamage.hasNoEffect())
            pendingDamage= null;
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
        Weapon w= new Weapon("w", null, 0);
        if(hangar != null || !hangar.getWeapons().isEmpty())
            w= hangar.removeWeapon(i);
            if(w != null)
                weapons.add(w);
    }
    
    public void mountShieldBooster(int i){
        ShieldBooster sb= new ShieldBooster("sb", 0.0f, 0);
        if(hangar != null || !hangar.getShieldBoosters().isEmpty())
            sb= hangar.removeShieldBooster(i);
            if(sb != null)
                shieldBoosters.add(sb);
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
       weapons.removeIf(w -> w.getUses() == 0);
       shieldBoosters.removeIf(s -> s.getUses() == 0);
    }
    
    //Próxima práctica
    public float fire(){
        throw new UnsupportedOperationException();
    }
    
    public float protection(){
        throw new UnsupportedOperationException();
    }
    
    public ShotResult receiveShot(float shot){
        throw new UnsupportedOperationException();
    }
    
    public void setLoot(Loot loot){
        throw new UnsupportedOperationException();
    }
    
    public void discardWeapon(int i){
        throw new UnsupportedOperationException();
    }
    
    public void discardShieldBooster(int i){
        throw new UnsupportedOperationException();
    }
}





