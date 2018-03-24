# Author: Elena Merelo

require 'test/unit'
require_relative '../lib/Loot'

module Deepspace
  class TC_Loot < Test::Unit::TestCase
    def setup
      @l= Loot.new(1, 2, 3, 4, 5)
    end
    
    def test_equals
      assert_equal 1, @l.nSupplies, "Error en nSupplies"
      assert_equal 2, @l.nWeapons, "Error en nWeapons"
      assert_equal 3, @l.nShields, "Error en nShields"
      assert_equal 4, @l.nHangars, "Error en nHangars"
      assert_equal 5, @l.nMedals, "Error en nMedals"
    end
    
    def test_instance_of
      l1= @l 
      l2= Loot.new(1, 2, 3, 4, 5)
      assert_instance_of Loot, @l, "l no es una instancia de Loot"
      assert_instance_of Loot, l1, "l1 no es una instancia de Loot"
      assert_instance_of Loot, l2, "l2 no es una instancia de Loot"
    end
    
    def test_comparison
      l1= @l 
      l2= Loot.new(1, 2, 3, 4, 5)
      assert_equal @l, l1, "l != l1"
      assert_equal @l, l2, "l != l2"
      assert_same @l, l1, "l= Loot.new(1, 2, 3, 4, 5) no es el mismo objeto que l1= l"
      assert_same @l, l2, "l= Loot.new(1, 2, 3, 4, 5) no es el mismo objeto que l2= Loot.new(1, 2, 3, 4, 5)"
    end
  end #class
end #module