# Author: Elena Merelo

require_relative "SpaceStationToUI"
require_relative 'Damage'

module Deepspace
  class SpaceStation
    attr_reader :ammoPower, :fuelUnits, :hangar, :name, :nMedals, :pendingDamage
    attr_reader :shieldBoosters, :shieldPower, :weapons

    @@MAXFUEL= 100.freeze
    @@SHIELDLOSSPERUNITSHOT= 0.1.freeze

    def initialize(n, supplies)
      @name= n
      @ammoPower= supplies.ammoPower
      @fuelUnits= supplies.fuelUnits 
      @shieldPower= supplies.shieldPower
      @nMedals= 0
      @pendingDamage= nil
      @weapons= Array.new 
      @shieldBoosters= Array.new
      @hangar= nil
    end

    def cleanUpMountedItems
      @weapons.delete_if { |element| element.uses == 0} 
      @shieldBoosters.delete_if { |element| element.uses == 0} 
    end

    def discardHangar
      @hangar= nil
    end

    def discardShieldBooster(i)
      if i>= 0 && i< @shieldBoosters.length
        s= @shieldBoosters.remove(i)
        
        if @pendingDamage != nil
          @pendingDamage.discardShieldBooster s
          cleanPendingDamage
        end
      end
    end

    def discardShieldBoosterInHangar(i)
      if @hangar != nil
        @hangar.removeShieldBooster(i)
      end
    end

    def discardWeapon(i)
      if i>= 0 && i< @weapons.length
        w= @weapons.remove(i)
        
        if @pendingDamage != nil
          @pendingDamage.discardWeapon w
          cleanPendingDamage
        end
      end
    end

    def discardWeaponInHangar(i)
      if @hangar != nil
        @hangar.removeWeapon(i)
      end
    end

    def fire
      factor= 1.0
      
      for i in @weapons
        factor *= i.useIt
      end
      
      @ammoPower*factor
    end

    def speed
      @fuelUnits.to_f/@@MAXFUEL
    end

    def getUIversion
      SpaceStationToUI.new(self)
    end

    def mountShieldBooster(i)
      if @hangar != nil
        success= @hangar.removeShieldBooster(i)
        if success != nil
          @shieldBoosters.push(success)
        end
      end
    end

    def mountWeapon(i)
      if @hangar != nil
        success= @hangar.removeWeapon(i)
        if success != nil
          @weapons << success
        end
      end
    end

    def move
        @fuelUnits -= @fuelUnits*self.speed
    end

    def protection
      factor= 1.0 
      
      for s in @shieldBoosters 
        factor *= s.useIt 
      end
      
      @shieldPower*factor
    end

    def receiveHangar(h)
      if @hangar == nil
        @hangar= h
      end
    end

    def receiveShieldBooster(s)
      if @hangar == nil
        false
      else
        @hangar.addShieldBooster(s)
      end
    end

    def receiveShot(shot)
      if(protection >= shot)
        @shieldPower -= @@SHIELDLOSSPERUNITSHOT*shot
        @shieldPower= [0.0, @shieldPower].max
        
        return ShotResult::RESIST
        
      else 
        @shieldPower= 0.0
        return ShotResult::DONOTRESIST
      end
    end

    def receiveSupplies(s)
      @ammoPower += s.ammoPower
      assignFuelValue(@fuelUnits + s.fuelUnits)
      @shieldPower += s.shieldPower
    end

    def receiveWeapon(w)
      if @hangar == nil 
        false
      else
        @hangar.addWeapon(w)
      end
    end

    def setLoot(loot)
      dealer= CardDealer.instance
      
      if loot.nHangars > 0 
        receiveHangar(dealer.nextHangar)
      end
      
      for i in 0..loot.nSupplies
        receiveSupplies(dealer.nextSuppliesPackage)
      end
      
      for i in 0..loot.nWeapons
        receiveWeapon(dealer.nextWeapon)
      end
      
      for i in 0..loot.nShields
        receiveShieldBooster(dealer.nextShieldBooster)
      end
      
      @nMedals += loot.nMedals
    end

    def setPendingDamage(d)
      @pendingDamage= d.adjust(@weapons, @shieldBoosters)
    end

    def validState
      @pendingDamage == nil || @pendingDamage.hasNoEffect
    end

    private
    def assignFuelValue(f)
      if f < @@MAXFUEL
        @fuelUnits= f
      else
        @fuelUnits= @@MAXFUEL
      end
    end

    def cleanPendingDamage
      if pendingDamage.hasNoEffect
        @pendingDamage= nil
      end
    end
  end #class
end #module