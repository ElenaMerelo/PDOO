require_relative 'SpaceStation'
require_relative 'PowerEfficientSpaceStationToUI'


module Deepspace
  class PowerEfficientSpaceStation < SpaceStation
    @@EFFICIENCYFACTOR= 1.1.freeze
    
    def initialize(s)
       super(s.name, s.ammoPower, s.fuelUnits, s.shieldPower, s.hangar, s.weapons,s.shieldBoosters, s.pendingDamage,s.nMedals) 
    end
    
    def fire
      super.fire * @@EFFICIENCYFACTOR
    end
    
    def protection
      super.protection *@@EFFICIENCYFACTOR
    end
    
    def setLoot(l)
      super
      Transformation::NOTRANSFORM
    end
    
    def getUIversion
      PowerEfficientSpaceStationToUI.new(self)
    end
  end
end
