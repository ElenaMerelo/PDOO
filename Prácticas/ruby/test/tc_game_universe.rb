# Author: Elena Merelo

require 'test/unit'
require_relative '../lib/GameUniverse'
require_relative '../lib/Dice'
require_relative '../lib/GameStateController'

module Deepspace
  class TC_GameUniverse < Test::Unit::TestCase
    def setup
      @g= GameUniverse.new
      
    end

    def test_initialize
      assert_equal @g.state, GameState::CANNOTPLAY
    end
    
    def test_have_a_winner
      assert_respond_to @g, :haveAWinner, "g doesn't respond to haveAWinner"
    end
    
    def test_discards
      assert_respond_to @g, :discardHangar, "g doesn't respond to discardHangar"
      assert_respond_to @g, :discardShieldBooster, "g doesn't respond to discardshieldBooster"
      assert_respond_to @g, :discardShieldBoosterInHangar, "g doesn't respond to discardShieldBoosterInHangar"
      assert_respond_to @g, :discardWeapon, "g doesn't respond to discardWeapon"
      assert_respond_to @g, :discardWeaponInHangar, "g doesn't respond to discardWeaponInHangar"
    end
    
    def test_mounts
      assert_nil @g.mountWeapon(0), "nil != @g.mountWeapon(0)"
      assert_nil @g.mountShieldBooster(0), "nil != @g.mountShieldBooster(0)"
      
      assert_respond_to @g, :mountShieldBooster, "g doesn't respond to mountShieldBooster"
      assert_respond_to @g, :mountWeapon, "g doesn't respond to mountWeapon"
    end
    
    def test_get_ui_version
      assert_respond_to @g, :getUIversion, "g doesn't respond to getUIversion"
    end
    
    def test_state
      assert_respond_to @g, :state, "g doesn't respond to state"
      assert_equal GameState::CANNOTPLAY, @g.state, "@g.state != GameState::CANNOTPLAY"
    end
    
  end
end