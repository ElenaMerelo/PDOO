# Author: Elena Merelo

require relative "SpaceStationToUI"

class SpaceStation
  attr_reader :ammoPower, :fuelUnits, :hangar, :name, :nMedals, :pendingDamage
  attr_reader :shieldBoosters, :shieldPower, :weapons
  
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
  
  def discardHangar
    @hangar= null
  end
  
  def discardShieldBooster(i)
    #Próxima práctica
  end
  
  def discardShieldBoosterInHangar(i)
    if @hangar != null 
      @hangar.removeShieldBooster(i)
    end
  end
  
  def discardWeapon(i)
    #próxima práctica
  end
  
  def discardWeaponInHangar(i)
    if @hangar != null
      @hangar.removeWeapon(i)
    end
  end
  
  def fire
    #próxima práctica
  end
  
=begin 
Devuelve la velocidad de la estación espacial. Esta se calcula como la fracción
entre las unidades de combustible de las que dispone en la actualidad la estación espacial respecto al
máximo unidades de combustible que es posible almacenar. La velocidad se representa por tanto
como un número del intervalo [0,1].
=end
  def speed
    @fuelUnits/MAXFUEL
  end
  
  def getUIversion
    SpaceStationToUI.new(self)
  end
  
  def mountShieldBooster(i)
    if @hangar != null
      success= @hangar.removeShieldBooster(i)
      if success != null
        @shieldBoosters.push(success)
      end
    end
  end
  
  def mountWeapon(i)
    if @hangar != null
      success= @hangar.removeWeapon(i)
      if success != null
        @weapons.push(success)
      end
    end
  end
  
  def move
    if @fuelUnits - self.speed > 0
      @fuelUnits= @fuelUnits - self.speed 
    end
  end
  
  def protection
    #próxima práctica
  end
  
  def receiveHangar(h)
    if @hangar == null
      @hangar= h
    end
  end
  
  def receiveShieldBooster(s)
    if @hangar == null
      false
    else
      @hangar.addShieldBooster(s)
    end
  end
  
  def receiveShot(shot)
    #próxima práctica
  end
  
  def receiveSupplies(s)
    @ammoPower= @ammoPower + s.ammoPower
    @fuelUnits= @fueltUnits + s.fuelUnits
    @shieldPower= @shieldPower + s.shieldPower
  end
  
  def receiveWeapon(w)
    if hangar == null 
      false
    else
      @hangar.addWeapon(w)
    end
  end
  
  def setLoot(l)
    #próxima práctica
  end
  
  def setPendingDamage(d)
    @pendingDamage= d.adjust(@weapons, @shieldBoosters)
  end
  
  def validState
    @pendingDamage == null || @pendingDamage.hasNoEffect ? true : false
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
