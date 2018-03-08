=begin
Representa a un paquete de suministros para una estación espacial. Puede contener
armamento, combustible y/o energía para los escudos
=end

module Deepspace
  class SuppliesPackage
    @ammoPower
    @fuelUnits
    @shieldPower
    
    def initialize(ammo, fuel, power)
      @ammoPower= ammo
      @fuelUnits= fuel
      @shieldPower= power
    end
    
    def newCopy(s)
      SuppliesPackage.new(s.ammoPower, s.fuelUnits, s.shieldPower)
    end
    
    attr_reader :ammoPower, :fuelUnits, :shieldPower
  end
end