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
      if w >= 0 && w < @weapons.length
        return @weapons.delete_at(w)
      else
        return nil
      end
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
      if s >= 0 && s < @shieldBoosters.length
        return @shieldBoosters.delete_at(s)
      else
        return nil
      end
    end
    
    def to_s
      "Hangar: maxElements #{@maxElements}, weapons #{@weapons.join(", ")}, shieldBoosters #{@shieldBoosters.join(", ")}"
    end
    
    private
    def spaceAvailable
      (@weapons.length + @shieldBoosters.length) < @maxElements
    end
  end
end
