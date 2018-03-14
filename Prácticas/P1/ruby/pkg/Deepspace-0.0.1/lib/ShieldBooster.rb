# Representa a los potenciadores de escudo que pueden tener las estaciones espaciales

module Deepspace
  class ShieldBooster
    attr_reader :name, :boost, :uses
    
    def initialize(name, boost, uses)
      @name= name
      @boost= boost
      @uses= uses
    end
    
    def newCopy
      ShieldBooster.new(@name, @boost, @uses)
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
  end
end
