# Representa a los potenciadores de escudo que pueden tener las estaciones espaciales

require_relative "ShieldToUI"

module Deepspace
  class ShieldBooster
    attr_reader :name, :boost, :uses
    
    def initialize(name, boost, uses)
      @name= name
      @boost= boost
      @uses= uses
    end
    
    def self.newCopy(s)
      new(s.name, s.boost, s.uses)
    end
    
    def useIt
      if @uses > 0 
        @uses -= 1
        @boost
      else
        1.0
      end
    end
    
    def to_s
      "name #{@name}, boost #{@boost}, uses #{@uses}"
    end
    
    def getUIversion
      ShieldToUI.new(self)
    end
  end
end
