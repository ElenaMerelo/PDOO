require relative "HangarToUI"

module Deepspace
  class Hangar
    attr_reader :maxElements, :weapons, :shieldBoosters
    def initialize(capacity)
      @maxElements= capacity
      @weapons= Array.new
      @shieldBoosters= Array.new
    end
    
    def self.newCopy(h)
      Hangar.new(h.maxElements)
      @weapons= h.weapons
      @shieldBoosters= h.shieldBoosters
    end
    
    def getUIversion
      HangarToUI.new(self)
    end
    
    def addWeapon(w)
      if spaceAvailable
        @weapons.push(w)
        true
      else
        false
      end
    end
    
    def removeWeapon(w)
      #Guardamos la weapon en la posición w en una variable, devolvemos null si está fuera de rango
      removed= Weapon.new(@weapons.fetch(w, null)) 
      @weapons.delete_at(w)
      removed
    end
    
    def addShieldBooster(s)
      if spaceAvailable
        @shieldBoosters << s
        true
      else
        false
      end
    end
    
    def removeShieldBooster(s)
      removed= ShieldBooster.new(@shieldBoosters.fetch(s, null))
      @shieldBoosters.delete_at(s)
      removed
    end
    
    private
    def spaceAvailable
      @weapons.length + @shieldBoosters.length < @maxElements
    end
  end
end
