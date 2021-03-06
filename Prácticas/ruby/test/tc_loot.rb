# Author: Elena Merelo

require 'test/unit'
require_relative '../lib/Loot'

module Deepspace
  class TC_Loot < Test::Unit::TestCase
    def setup
      @l= Loot.new(1, 2, 3, 4, 5)
      @l1= Loot.new(1, 2, 3, 4, 5)
    end
    
    def test_equals
      assert_equal 1, @l.nSupplies, "Error en nSupplies"
      assert_equal 2, @l.nWeapons, "Error en nWeapons"
      assert_equal 3, @l.nShields, "Error en nShields"
      assert_equal 4, @l.nHangars, "Error en nHangars"
      assert_equal 5, @l.nMedals, "Error en nMedals"
    end
    
    def test_instance_of
      assert_instance_of Loot, @l, "l no es una instancia de Loot"
      assert_instance_of Loot, @l1, "l1 no es una instancia de Loot"
    end
    
    def test_comparison
      assert_not_equal @l, @l1, "l != l1"
      assert_not_same @l, @l1, "l= Loot.new(1, 2, 3, 4, 5) no es el mismo objeto que l1= l"
    end
    
    def test_responses
      assert_respond_to @l, :to_s, "l doesn't respond to to_s"
      assert_respond_to @l1, :to_s, "l1 doesn't respond to to_s"
      
      assert_respond_to @l, :getUIversion, "l doesn't respond to getUIversion"
      assert_respond_to @l1, :getUIversion, "l1 doesn't respond to getUIversion"
    end
  end #class
end #module