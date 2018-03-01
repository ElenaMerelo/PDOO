/**
 * @author elena
 * @brief Representa un paquete de suministros para una estación espacial. Puede contener
 * armamento, combustible y/o energía para los escudos.
*/
class SuppliesPackage{
    private float ammoPower, fuelUnits, shieldPower;

    SuppliesPackage(float ammo, float fuel, float power){
        ammoPower= ammo;
        fuelUnits= fuel;
        shieldPower= power;
    }
    
    SuppliesPackage(SuppliesPackage s){
        this(s.getAmmoPower(), s.getFuelUnits(), s.getShieldPower());
    }
    
    public float getAmmoPower(){
        return ammoPower;
    }
    
    public float getFuelUnits(){
        return fuelUnits;
    }
    
    public float getShieldPower(){
        return shieldPower;
    }
    
}
