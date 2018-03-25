# Author: Elena Merelo

require 'test/unit'
require_relative '../lib/CombatResult'

module Deepspace
  class TC_CombatResult < Test::Unit::TestCase
    def test_definition
      assert !CombatResult::ENEMYWINS.nil?, "ENEMYWINS no definido"
      assert !CombatResult::NOCOMBAT.nil?, "NOCOMBAT no definido"
      assert !CombatResult::STATIONESCAPES.nil?, "STATIONESCAPES no definido"
      assert !CombatResult::STATIONWINS.nil?, "STATIONWINS no definido"
    end
  end
end