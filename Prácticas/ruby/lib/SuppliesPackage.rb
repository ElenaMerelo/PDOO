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
    
    def self.newCopy(s)
      SuppliesPackage.new(s.ammoPower, s.fuelUnits, s.shieldPower)
    end
    
    def to_s
      "ammoPower #{@ammoPower}, fuelUnits #{@fuelUnits}, shieldPower #{@shieldPower}"
    end
    
  end
end