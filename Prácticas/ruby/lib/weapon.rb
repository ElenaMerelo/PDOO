=begin
Representa a las armas de las que puede disponer una estación espacial para potenciar su
energía al disparar
=end

require_relative 'WeaponToUI'

module Deepspace
  class Weapon
    def initialize(name, type, uses)
      @name= name
      @type= type
      @uses= uses
    end

    def newCopy(w) #Aqui deberias subir self
      Weapon.new(w.name, w.type, w.uses)
    end

    attr_reader :name, :type, :uses

    def power
      @type.power
    end

    def useIt
      if @uses > 0
        @uses -= 1
        power
      else
        1.0
      end
    end
    
    def getUIversion
      WeaponToUI.new(self)
    end
  end
end
