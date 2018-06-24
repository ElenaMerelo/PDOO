require_relative 'SpaceStation'
require_relative 'Transformation'
require_relative 'SpaceCityToUI'

module Deepspace
  class SpaceCity < SpaceStation
    attr_reader :collaborators
    
    def initialize(bas, rest)
      super(bas.name,bas.getSupplies, bas.nMedals, bas.weapons,bas.shieldBoosters,bas.hangar,bas.pendingDamage)
      @base= base 
      @collaborators= rest
    end
    
    def fire
      f= super
      
      for s in @collaborators
        f += s.fire
      end
      
      f
    end
    
    def protection
      p= super
      
      for s in @collaborators
        p += s.protection 
      end
      
      p
    end
    
    def setLoot(l)
      super
      Transformation::NOTRANSFORM
    end
    
    def getUIversion
      SpaceCityToUI.new(self)
    end
  end
end
