require_relative 'SpaceStation'
require_relative 'Transformation'
require_relative 'SpaceCityToUI'

module Deepspace
  class SpaceCity < SpaceStation
    attr_reader :collaborators
    
    def initialize(base, rest)
      super(base)
      @base= base 
      @collaborators= rest
    end
    
    def fire
      f= @base.fire 
      
      for s in @collaborators
        f += s.fire
      end
      
      f
    end
    
    def protection
      p= @base.protection 
      
      for s in @collaborators
        p += s.protection 
      end
      
      p
    end
    
    def setLoot(l)
      super
      Transformation::NOTRANSFORM
    end
    
    def getUIversion
      SpaceCityToUI.new(self)
    end
  end
end
