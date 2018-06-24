require_relative 'Damage'
require_relative 'NumericDamageToUI'

module Deepspace
  class NumericDamage < Damage
    public_class_method :new
    attr_reader :nWeapons
    def initialize(nw, ns)
      super(ns)
      @nWeapons= nw
    end
    
    def self.newCopy(d)
      NumericDamage.new(d.nWeapons, d.nShields)
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
    
    def to_s
      "nWeapons: " + @nWeapons + super
    end
    
    def adjust(w, s)
      n_weapons= [w.length, @nWeapons].min  #nos quedamos con quien tenga menos armas
        
      NumericDamage.new(n_weapons, adjustShields(s))
    end
    
    #public :adjust
    #public_class_method :new
  end
end