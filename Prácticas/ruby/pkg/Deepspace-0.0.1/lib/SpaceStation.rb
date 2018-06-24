# Author: Elena Merelo

require_relative 'SpaceStationToUI'
require_relative 'Damage'
require_relative 'Transformation'
require_relative 'ShotResult'
require_relative 'CardDealer'

module Deepspace
  class SpaceStation
    attr_reader :ammoPower, :fuelUnits, :hangar, :name, :nMedals, :pendingDamage
    attr_reader :shieldBoosters, :shieldPower, :weapons

    @@MAXFUEL= 100.freeze
    @@SHIELDLOSSPERUNITSHOT= 0.1.freeze

    def initialize(n, supplies, medals= 0, pending= nil, w=Array.new, sb= Array.new, h= nil)
      @name= n
      @ammoPower= supplies.ammoPower
      assignFuelValue(supplies.fuelUnits) 
      @shieldPower= supplies.shieldPower
      @nMedals= medals
      
      if pending != nil
        @pendingDamage= pending.copy
      else
        @pendingDamage= nil
      end 
      
      @weapons= Array.new(w)
      @shieldBoosters= Array.new(sb)
      
      if h != nil
        @hangar= Hangar.newCopy(h)
      else
        @hangar= nil
      end
    end
    
    def self.newCopy(station)
      supplies= SuppliesPackage.new(station.ammoPower, station.fuelUnits, station.ammoPower)
      s= SpaceStation.new(station.name, supplies)
      s.nMedals= station.nMedals 
      s.setPendingDamage(station.pendingDamage)
      for w in station.weapons 
        s.weapons.push(w)
      end
      
      for sb in station.shieldBoosters
        s.shieldBoosters.push(sb)
      end
 
      s.receiveHangar(station.hangar)
      s
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
        @shieldBoosters.delete_at(i)
        
        if @pendingDamage != nil
          @pendingDamage.discardShieldBooster
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
        w= @weapons.delete_at(i)
        
        if @pendingDamage != nil
          @pendingDamage.discardWeapon(w)
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

    def getSpeed
      @fuelUnits.to_f/@@MAXFUEL
    end

    def getUIversion
      SpaceStationToUI.new(self)
    end

    def mountShieldBooster(i)
      if @hangar != nil
        success= @hangar.removeShieldBooster(i)
        if success != nil
          @shieldBoosters << success
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
      assignFuelValue(@fuelUnits - @fuelUnits.to_f*getSpeed)
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
        
        ShotResult::RESIST
        
      else 
        @shieldPower= 0.0
        ShotResult::DONOTRESIST
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
      
      for i in 0...loot.nSupplies # con ... va hasta loot.nSupplies-1, con .. lo incluye
        receiveSupplies(dealer.nextSuppliesPackage)
      end
      
      for i in 0...loot.nWeapons
        receiveWeapon(dealer.nextWeapon)
      end
      
      for i in 0...loot.nShields
        receiveShieldBooster(dealer.nextShieldBooster)
      end
      
      @nMedals += loot.nMedals
      
      if loot.spaceCity
        return Transformation::SPACECITY
      elsif loot.efficient
        return Transformation::GETEFFICIENT
      else return Transformation::NOTRANSFORM
      end
    end

    def setPendingDamage(d)
      @pendingDamage= d.adjust(@weapons, @shieldBoosters)
    end

    def validState
      @pendingDamage == nil || @pendingDamage.hasNoEffect
    end
    
    def to_s
      "Name: #{@name}, AmmoPower: #{@ammoPower}, FuelUnits: #{@fuelUnits},
     ShieldPower: #{@shieldPower}, Medals: #{@nMedals}, Weapons: #{@weapons.join(", ")},
     ShieldBoosters: #{@shieldBoosters.join(", ")}, Hangar: #{@hangar}, PendingDamage: #{@pendingDamage}"
    end

    private
    def assignFuelValue(f)
      if f < @@MAXFUEL and f >= 0
        @fuelUnits= f
      elsif f < 0
        @fuelUnits= 0
      else
        @fuelUnits= @@MAXFUEL
      end
    end

    def cleanPendingDamage
      if @pendingDamage.hasNoEffect && @pendingDamage != nil
        @pendingDamage= nil
      end
    end
  end #class
end #module