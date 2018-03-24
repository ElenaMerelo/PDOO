# Author: Elena Merelo

require 'test/unit'
require_relative '../lib/SuppliesPackage'

module Deepspace
  class TC_SuppliesPackage < Test::Unit::TestCase
    def setup
      @sp= SuppliesPackage.new(2.3, 3.4, 4.5)
      @sp1= SuppliesPackage.newCopy(@sp)
    end
    
    def test_equals
      assert_equal 2.3, @sp.ammoPower, "Error en ammoPower"
      assert_equal 3.4, @sp.fuelUnits, "Error en fuelUnits"
      assert_equal 4.5, @sp.shieldPower, "Error en shieldPower"
    end
    
    def test_instance_of
      sp2= @sp
      sp3= SuppliesPackage.new(2.3, 3.4, 4.5)
      assert_instance_of SuppliesPackage, @sp, "sp no es una instancia de SuppliesPackage"
      assert_instance_of SuppliesPackage, @sp1, "sp1 no es una instancia de SuppliesPackage"
      assert_instance_of SuppliesPackage, sp2, "sp2 no es una instancia de SuppliesPackage"
      assert_instance_of SuppliesPackage, sp3, "sp3 no es una instancia de SuppliesPackage"
    end
    
    def test_comparison
      sp2= @sp
      sp3= SuppliesPackage.new(2.3, 3.4, 4.5)
      assert_equal @sp, @sp1, "sp != sp1"
      assert_equal @sp, sp2, "sp != sp2"
      assert_equal @sp1, sp2, "sp1 != sp2"
      assert_equal @sp, sp3, "sp != sp3"

      assert_same @sp, @sp1, "@sp= SuppliesPackage.new(2.3, 3.4, 4.5) no es el mismo objeto que @sp1= SuppliesPackage.new(@sp)"
      assert_same @sp, sp2, "@sp= SuppliesPackage.new(2.3, 3.4, 4.5) no es el mismo objeto que sp2= @sp"
      assert_same @sp1, sp2, "@sp1= SuppliesPackage.new(@sp) no es el mismo objeto que sp2= @sp"
      assert_same @sp, sp3, "@sp= SuppliesPackage.new(2.3, 3.4, 4.5) no es el mismo objeto que sp3= SuppliesPackage.new(2.3, 3.4, 4.5)"
      
    end
  end #class
end #module