require_relative 'PowerEfficientSpaceStation'
require_relative 'Dice'
require_relative 'BetaPowerEfficientSpaceStationToUI'

module Deepspace
  class BetaPowerEfficientSpaceStation < PowerEfficientSpaceStation
    @@EXTRAEFFIENCY= 1.2.freeze

    def initialize(station)
      super
      @dice= Dice.new
    end
    
    def fire
      f= super
      if @dice.extraEfficiency
        f *= @@EXTRAEFFICIENCY  
      end
      
      f
    end
    
    def getUIversion
      BetaPowerEfficientSpaceStationToUI.new(self)
    end
  end
end
