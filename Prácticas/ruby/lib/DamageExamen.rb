require_relative 'SpecificDamage'
require_relative 'Dice'

module Deepspace
  class DamageExamen < SpecificDamage
    def initialize(w, ns)
      super(w, ns)
      @weapons= Array.new(w)
    end
    
    def adjust(w, s)
      adjusted= super.adjust(w, s)
      dice= Dice.new
      if(dice.forget)
        adjusted.discardFirstWeapon
      end
      
      adjusted
    end
  end
end