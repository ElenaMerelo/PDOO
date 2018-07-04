/** 
 * @author Elena Merelo
 */
package deepspace;

import java.util.ArrayList;

class SpaceStation implements SpaceFighter{
    private static final int MAXFUEL= 100;
    private static final float SHIELDLOSSPERUNITSHOT= 0.1f;
    private static int reanimaciones= 0;
    private float ammoPower, fuelUnits, shieldPower;
    private String name;
    private int nMedals;
    private Damage pendingDamage;
    private ArrayList<Weapon> weapons;
    private ArrayList<ShieldBooster> shieldBoosters;
    private Hangar hangar;
    
    //Constructores 
    SpaceStation(String n, SuppliesPackage supplies){
        name= n;
        ammoPower= supplies.getAmmoPower();
        assignFuelValue(supplies.getFuelUnits());
        shieldPower= supplies.getShieldPower();
        nMedals= 0;
        weapons= new ArrayList<>();
        shieldBoosters= new ArrayList<>();
        hangar= null;
        pendingDamage= null;
    }
    
    SpaceStation(SpaceStation station){
        this(station.name, new SuppliesPackage(station.ammoPower, station.fuelUnits, station.shieldPower));
        nMedals= station.nMedals;
        weapons= new ArrayList(station.weapons);
        shieldBoosters= new ArrayList(station.shieldBoosters); 
        if (station.hangar != null)
            hangar= new Hangar(station.hangar);
        
        if (station.pendingDamage != null )
            pendingDamage= station.pendingDamage.copy();
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
    
    SpaceStationToUI getUIversion(){
        return new SpaceStationToUI(this);
    }
    
    public ArrayList<Weapon> getWeapons(){
        return weapons;
    }
    
    public boolean isBoundToWin(){
        return nMedals > 4 && weapons.size() > 2 && shieldBoosters.size() > 2;
    }
    
    //Si todas las armas y escudos de la estación tienen un único uso sobrante devuelve true
    public boolean needsHelp(){
        if((weapons.isEmpty() && shieldBoosters.isEmpty()) || hangar != null) return false;
        
        else{
            for(Weapon w: weapons)
                if(w.useIt() > 1)
                    return false;

            for(ShieldBooster s: shieldBoosters)
                if(s.useIt() > 1)
                    return false;
            
            return true;
        }
    }
    
    public void fixUses(){
        for(Weapon w: weapons)
            w.boostUses();
        
        for(ShieldBooster s: shieldBoosters)
            s.boostUses();
    }
    
    /**
     * @brief Fija la cantidad de combustible al valor pasado como parámetro sin
     * que nunca se exceda el límite.
     */
    private void assignFuelValue(float f){
        if(f < MAXFUEL && f > 0)
            fuelUnits= f;
        else if (f >= MAXFUEL)
            fuelUnits= MAXFUEL;
        else 
            fuelUnits= 0;
    }
    
    /**
     * @brief Si el daño pendiente (pendingDamage) no tiene efecto fija la
     * referencia al mismo a null.
     */
    private void cleanPendingDamage(){
        if(pendingDamage.hasNoEffect() && pendingDamage != null)
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
        if(hangar != null && !hangar.getWeapons().isEmpty()){
            Weapon w= hangar.removeWeapon(i);
            if(w != null)
                weapons.add(w);
        }
    }
    
    public void mountShieldBooster(int i){
        if(hangar != null && !hangar.getShieldBoosters().isEmpty()){
            ShieldBooster sb= hangar.removeShieldBooster(i);
            if(sb != null)
                shieldBoosters.add(sb);
        }
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
        assignFuelValue(fuelUnits - fuelUnits*getSpeed());
    }
    
    public boolean validState(){
        return pendingDamage == null || pendingDamage.hasNoEffect();
    }
    
    public void cleanUpMountedItems(){
       weapons.removeIf(w -> w.getUses() == 0);
       shieldBoosters.removeIf(s -> s.getUses() == 0);
    }
    
    /**
     * @brief Realiza un disparo y se devuelve la energía o potencia del mismo. 
     * Para ello se multiplica la potencia de disparo por los factores potenciadores
     * proporcionados por todas las armas.
     */
    @Override
    public float fire(){
        float factor= 1.0f;
        
        for(Weapon w: weapons)
          factor *= w.useIt();  
        
        return ammoPower*factor;
    }
    
    /**
     * @brief Se usa el escudo de protección y se devuelve la energía del mismo. 
     * Para ello se multiplica la potencia del escudo por los factores potenciadores
     * proporcionados por todos los potenciadores de escudos de los que se dispone.
     */
    @Override
    public float protection(){
        float factor= 1.0f;
        
        for(ShieldBooster s: shieldBoosters)
            factor *= s.useIt();
        
        return shieldPower*factor;
    }
    
    /**
     * @brief Realiza las operaciones relacionadas con la recepción del impacto 
     * de un disparo enemigo. Ello implica decrementar la potencia del escudo en 
     * función de la energía del disparo recibido como parámetro y devolver el 
     * resultado de si se ha resistido el disparo o no.
     */
    @Override
    public ShotResult receiveShot(float shot){
        if(protection() >= shot){
            shieldPower -= SHIELDLOSSPERUNITSHOT*shot;
            shieldPower= Math.max(0.0f, shieldPower);
            
            return ShotResult.RESIST;
        }
        else{
            shieldPower= 0.0f;
            return ShotResult.DONOTRESIST;
        }
    }
    
    /**
     * @brief Recepción de un botín. Por cada elemento que indique el botín (pasado
     * como parámetro) se le pide a CardDealer un elemento de ese tipo y se intenta
     * almacenar con el método receive*() correspondiente. Para las medallas, 
     * simplemente se incrementa su número según lo que indique el botín.
     */
    public Transformation setLoot(Loot loot){
        CardDealer dealer= CardDealer.getInstance();
        int i;

        if(loot.getNHangars() > 0)
            receiveHangar(dealer.nextHangar());

        for(i= 0; i< loot.getNSupplies(); i++)
            receiveSupplies(dealer.nextSuppliesPackage());

        for(i= 0; i< loot.getNWeapons(); i++)
            receiveWeapon(dealer.nextWeapon());

        for(i= 0; i< loot.getNShields(); i++)
            receiveShieldBooster(dealer.nextShieldBooster());

        nMedals += loot.getNMedals();
    
        if(loot.spaceCity())
            return Transformation.SPACECITY;
        else if(loot.getEfficient())
            return Transformation.GETEFFICIENT;   
        return Transformation.NOTRANSFORM;
    }
    
    /**
     * @brief Se intenta descartar el arma con índice i de la colección de armas en uso.
     * Además de perder el arma, se debe actualizar el daño pendiente (pendingDamage) 
     * si es que se tiene alguno.
     */
    public void discardWeapon(int i){
        if(i>= 0 && i< weapons.size()){
            Weapon w= weapons.remove(i);
            
            if(pendingDamage != null){
                pendingDamage.discardWeapon(w);
                cleanPendingDamage();
            }
        }
    }
    
    /**
     * @brief Se intenta descartar el potenciador de escudo con índice i de la
     * colección de potenciadores de escudo en uso. Además de perder el potenciador 
     * de escudo, se debe actualizar el daño pendiente (pendingDamage) si es que se tiene alguno.
     */
    public void discardShieldBooster(int i){
        if(i>= 0 && i< shieldBoosters.size()){
            shieldBoosters.remove(i);
            
            if(pendingDamage != null){
                pendingDamage.discardShieldBooster();
                cleanPendingDamage();
            }
        }
    }
    
    public boolean noMoreReanimaciones(){
        return reanimaciones > 3;
    }
    public void reanimar(){
        reanimaciones++;
        if(reanimaciones <= 3){
            weapons.add(new Weapon("w", WeaponType.LASER, 3));
            shieldBoosters.add(new ShieldBooster("n", 23.23f, 3));
        }
    }
    
    
    @Override
    public String toString() {
        return "SpaceStation--" + "ammoPower: " + ammoPower + ", fuelUnits: " + fuelUnits + ", name: " + name + ", nMedals: " + nMedals + ", shieldPower: " + shieldPower + ", weapons: " + weapons + ", shieldBoosters: " + shieldBoosters + ", hangar: " + hangar + ", pendingDamage: " + pendingDamage;
}
}





