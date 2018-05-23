require_relative 'SpaceStation'
require_relative 'PowerEfficientSpaceStationToUI'

module Deepspace
  class PowerEfficientSpaceStation < SpaceStation
    @@EFFICIENCYFACTOR= 1.1.freeze
    
    def initialize(station)
      newCopy(station)
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
