require_relative 'PowerEfficientSpaceStation'
require_relative 'Dice'
require_relative 'BetaPowerEfficientSpaceStation'

module Deepspace
  class BetaPowerEfficientSpaceStation < PowerEfficientSpaceStation
    @@EXTRAEFFIENCY= 1.2.freeze

    def initialize(station)
      newCopy(station)
      @dice= Dice.new
    end
    
    def fire
      if @dice.extraEfficiency
        super * @@EXTRAEFFICIENCY  
      end
      
      super
    end
    
    def getUIversion
      return BetaPowerEfficientSpaceStation.new(self)
    end
  end
end
