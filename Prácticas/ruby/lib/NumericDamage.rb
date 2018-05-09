module Deepspace
  class NumericDamage < Damage
    def initialize(nw, ns)
      @nWeapons= nw
      super(ns)
    end
    
    def copy(d)
      super(d.nShields)
      @nWeapons= d.nWeapons
    end
    
    def getUIversion
      NumericDamageToUI.new(self)
    end
    
    def discardWeapon(w)
      if @nWeapons > 0
        @nWeapons -= 1
      end
    end
    
    def hasNoEffect
      @nWeapons == 0 and super
    end  
  end
end