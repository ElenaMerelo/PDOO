require_relative 'Damage'
require_relative 'SpecificDamageToUI'

module Deepspace
  class SpecificDamage < Damage
    attr_reader :weapons
    public_class_method :new
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
    
    #Examen P4
    def discardFirstWeapon
      if(@weapons.length > 0)
        @weapons.delete_at(0)
      end
    end

    def hasNoEffect
      @weapons.empty? and super
    end
    
    def to_s
      "weapons: " + @weapons.join(", ") + super
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
        
        SpecificDamage.new(min_freq, adjustShields(s))
    end
    
    private
    def arrayContainsType(w, t)
      index= w.index(t)
      if index == nil
        -1
      else
        index
      end
    end
    
    #public :adjust
    #public_class_method :new
    
  end #class
end #module