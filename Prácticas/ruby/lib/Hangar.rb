require_relative "HangarToUI"


module Deepspace
  class Hangar
    attr_reader :maxElements, :weapons, :shieldBoosters
    def initialize(capacity)
      @maxElements= capacity
      @weapons= Array.new
      @shieldBoosters= Array.new
    end
    
    def self.newCopy(h)
      copy= Hangar.new(h.maxElements)
      
      for w in h.weapons
        copy.addWeapon(w)
      end
      
      for s in h.shieldBoosters
        copy.addShieldBooster(s)
      end
      
      copy
    end
    
    def getUIversion
      HangarToUI.new(self)
    end
    
    def addWeapon(w)
      if spaceAvailable == true
        @weapons << w
        true
      else
        false
      end
    end
    
    def removeWeapon(w)
      @weapons.delete_at(w)
    end
    
    def addShieldBooster(s)
      if spaceAvailable == true
        @shieldBoosters << s
        true
      else
        false
      end
    end
    
    def removeShieldBooster(s)
      @shieldBoosters.delete_at(s)
    end
    
    def to_s
      "maxElements #{@maxElements}, weapons #{@weapons.join(", ")}, shieldBoosters #{@shieldBoosters.join(", ")}"
    end
    
    private
    def spaceAvailable
      (@weapons.length + @shieldBoosters.length) < @maxElements
    end
  end
end
