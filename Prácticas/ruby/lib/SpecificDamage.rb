
module Deepspace
  class SpecificDamage <Damage
    def initialize(w, ns)
      super(ns)
      @weapons= Array.new(w)
    end
    
    def copy(d)
      super(d.nShields)
      @weapons= d.weapons
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
      
    
  end #class
end #module