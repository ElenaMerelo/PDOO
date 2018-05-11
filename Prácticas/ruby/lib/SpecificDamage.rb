require_relative "Damage"
require_relative "SpecificDamageToUI"

module Deepspace
  class SpecificDamage < Damage
    def initialize(w, ns)
      super(ns)
      @weapons= Array.new(w)
    end
    
    def self.newCopy(d)
      SpecificDamage.new(d.weapons, d.nShields)
    end
    
    def getUIversion
      SpecificDamageToUI.new(self)
    end
    
    def discardWeapon(w)
      @weapons.delete_at(@weapons.index(w.type))
    end

    def hasNoEffect
      @weapons.empty? and super
    end
    
    def to_s
      "weapons: " + @weapons + super
    end
    
    def adjust(w, s)
      freq_1 = Hash.new(0)
        @weapons.each { |weapon_type| freq_1[weapon_type] += 1 }
        
        freq_2 = Hash.new(0)
        w.each { |weapon| freq_2[weapon.type] += 1 }
        
        min_freq= []
        l= WeaponType::LASER
        m= WeaponType::MISSILE
        p= WeaponType::PLASMA
        
        [freq_1[l], freq_2[l]].min.times { min_freq << l }
        [freq_1[m], freq_2[m]].min.times { min_freq << m }
        [freq_1[p], freq_2[p]].min.times { min_freq << p }
        
        Damage.newSpecificWeapons(min_freq, super)
    end
    
    #public :adjust
    #public_class_method :new
    
  end #class
end #module