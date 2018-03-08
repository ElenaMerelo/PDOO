# Representa a los potenciadores de escudo que pueden tener las estaciones espaciales

module Deepspace
  class ShieldBooster
    def initialize(name, boost, uses)
      @name= name
      @boost= boost
      @uses= uses
    end
    
    def newCopy(sb)
      ShieldBooster.new(sb.name, sb.boost, sb.uses)
    end
    
    attr_reader :name, :boost, :uses
    
    def useIt
      if @uses > 0 
        @uses -= 1
        @boost
      else
        1.0
      end
    end
  end
end
