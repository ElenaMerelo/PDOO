=begin
Representa a un paquete de suministros para una estación espacial. Puede contener
armamento, combustible y/o energía para los escudos
=end

module Deepspace
  class SuppliesPackage
    attr_reader :ammoPower, :fuelUnits, :shieldPower
    
    def initialize(ammo, fuel, power)
      @ammoPower= ammo
      @fuelUnits= fuel
      @shieldPower= power
    end
    
    def newCopy
      SuppliesPackage.new(@ammoPower, @fuelUnits, @shieldPower)
    end
    
  end
end