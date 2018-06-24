=begin
Los objetos de esta clase representan el daño producido a una estación espacial por una nave
enemiga cuando se pierde un combate. Cada instancia indicará la perdida de una cantidad de
potenciadores de escudo y por otro lado, o bien una cantidad de tipos indeterminados de armas o un
conjunto de tipos de armas concretas que se deben eliminar.
Todas las instancias deben ser unas independientes de otras y por lo tanto no deben compartir
instancias de objetos mutables (modificables)
By: Elena Merelo
=end

require_relative 'DamageToUI'

module Deepspace
  class Damage
    attr_reader :nShields
    
    def initialize(ns)
      @nShields= ns
    end
  
    
    def self.newCopy(d)
      Damage.new(d.nShields)
    end
    
    def getUIversion
      DamageToUI.new(self)
    end
    
    def discardShieldBooster
      if @nShields > 0
        @nShields -= 1
      end
    end
    
    def hasNoEffect
      @nShields == 0
    end
    
    def to_s
     " nShields #{@nShields}"
    end
    
    def adjustShields(s)
      [s.length, @nShields].min
    end
    
    def adjust(w,s)
    end
    
    def copy
    end
    
    def discardWeapon(w)
    end
    
    private_class_method :new
  end #class
end #module


