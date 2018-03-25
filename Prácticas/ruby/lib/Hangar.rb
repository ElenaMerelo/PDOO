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
      new(h.maxElements)
    end
    
    def getUIversion
      HangarToUI.new(self)
    end
    
    def addWeapon(w)
      if spaceAvailable == true
        @weapons.push(w)
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
        @shieldBoosters.push(s)
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
      (@weapons.length + @shieldBoosters.length) < @maxElements ? true : false
    end
  end
end
