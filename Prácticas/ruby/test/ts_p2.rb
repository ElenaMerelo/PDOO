# Author: Elena Merelo

require 'test/unit'
require_relative 'tc_hangar'
require_relative 'tc_damage'
require_relative 'tc_enemy_starship'
require_relative 'tc_space_station'

module Deepspace
  class TS_p2
    def self.suite
      suite= Test::Unit::TestSuite.new
      
      suite << TC_Hangar.suite
      suite << TC_Damage.suite
      suite << TC_EnemyStarShip.suite
      suite << TC_SpaceStation.suite
      
      return suite
    end
  end #class
end #module


