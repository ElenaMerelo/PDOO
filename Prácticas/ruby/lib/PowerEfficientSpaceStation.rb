require_relative 'SpaceStation'
require_relative 'Transformation'
require_relative 'PowerEfficientSpaceStationToUI'

module Deepspace
  class PowerEfficientSpaceStation < SpaceStation
    @@EFFICIENCYFACTOR= 1.1.freeze
    
    def initialize(station)
      # super.newCopy(st)  o bien:  super(st.name,st.getSupplies, st.nMedals, st.weapons,st.shieldBoosters,st.hangar,st.pendingDamage)
      s = SuppliesPackage.new(station.ammoPower, station.fuelUnits, station.shieldPower)
     super(station.name, s, station.weapons, station.shieldBoosters, station.nMedals)
    end
    
    def fire
      super * @@EFFICIENCYFACTOR
    end
    
    def protection
      super * @@EFFICIENCYFACTOR
    end
    
    def setLoot(l)
      if super==Transformation::GETEFFICIENT
        return Transformation::GETEFFICIENT
      else
        return Transformation::NOTRANSFORM
      end
    end
    
    def getUIversion
      PowerEfficientSpaceStationToUI.new(self)
    end
  end
end
