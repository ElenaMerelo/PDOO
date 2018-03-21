# Author: Elena Merelo

require relative "SpaceStationToUI"

class SpaceStation
  MAXFUEL= 100.freeze
  SHIELDLOSSPERUNITSHOT= 0.1.freeze
  
  def initialize(n, supplies)
    @name= n
    @ammoPower= supplies.ammoPower
    @fuelUnits= supplies.fuelUnits 
    @shieldPower= supplies.shieldPower
    @nMedals= 0
    @pendingDamage= Damage.new
    @weapons= Array.new 
    @shieldBoosters= Array.new
    @hangar= Hangar.new
  end
  
  def cleanUpMountedItems
    @weapons.delete_if { |element| element.useIt == 0} 
    @shieldBoosters.delete_if { |element| element.useIt == 0} 
  end
  
  private
  def assignFuelValue(f)
    if f < MAXFUEL
      @fuelUnits= f
    end
  end
  
  def cleanPendingDamage
    if pendingDamage.hasNoEffect
      pendingDamage= null
    end
  end
end
