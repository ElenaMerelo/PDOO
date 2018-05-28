require_relative 'SpaceCity'

module Deepspace
  class SpaceCityExamen < SpaceCity
    def initialize(base, rest)
      super(base, rest)
    end
    
    def fire
      @collaborators.delete_at(0)
      super
    end
    
  end
end