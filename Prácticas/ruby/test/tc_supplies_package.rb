# Author: Elena Merelo

require 'test/unit'
require_relative '../lib/SuppliesPackage'

module Deepspace
  class TC_SuppliesPackage < Test::Unit::TestCase
    def setup
      @sp= SuppliesPackage.new(2.3, 3.4, 4.5)
      @sp1= SuppliesPackage.newCopy(@sp)
      @sp2= SuppliesPackage.new(2.3, 3.4, 4.5)
      @sp3= @sp
    end
    
    def test_equals
      assert_equal 2.3, @sp.ammoPower, "Error en ammoPower de @sp"
      assert_equal 3.4, @sp.fuelUnits, "Error en fuelUnits de @sp"
      assert_equal 4.5, @sp.shieldPower, "Error en shieldPower de @sp"
      
      assert_equal 2.3, @sp1.ammoPower, "Error en ammoPower de @sp1"
      assert_equal 3.4, @sp1.fuelUnits, "Error en fuelUnits de @sp1"
      assert_equal 4.5, @sp1.shieldPower, "Error en shieldPower de @sp1"
      
      assert_equal 2.3, @sp2.ammoPower, "Error en ammoPower de @sp2"
      assert_equal 3.4, @sp2.fuelUnits, "Error en fuelUnits de @sp2"
      assert_equal 4.5, @sp2.shieldPower, "Error en shieldPower de @sp2"
      
      assert_equal 2.3, @sp3.ammoPower, "Error en ammoPower de @sp3"
      assert_equal 3.4, @sp3.fuelUnits, "Error en fuelUnits de @sp3"
      assert_equal 4.5, @sp3.shieldPower, "Error en shieldPower de @sp3"
      
    end
    
    def test_instance_of
      assert_instance_of SuppliesPackage, @sp, "sp no es una instancia de SuppliesPackage"
      assert_instance_of SuppliesPackage, @sp1, "sp1 no es una instancia de SuppliesPackage"
      assert_instance_of SuppliesPackage, @sp2, "sp2 no es una instancia de SuppliesPackage"
      assert_instance_of SuppliesPackage, @sp3, "sp3 no es una instancia de SuppliesPackage"

    end
    
    def test_comparison
      assert_not_equal @sp, @sp1, "sp == sp1"
      assert_not_equal @sp, @sp2, "sp == sp2"
      assert_not_equal @sp1, @sp2, "sp1 == sp2"
      assert_equal @sp3, @sp, "sp != sp3"

      assert_not_same @sp, @sp1, "@sp= SuppliesPackage.new(2.3, 3.4, 4.5) es el mismo objeto que @sp1= SuppliesPackage.new(@sp)"
      assert_not_same @sp, @sp2, "@sp= SuppliesPackage.new(2.3, 3.4, 4.5) es el mismo objeto que sp2= @sp"
      assert_not_same @sp1, @sp2, "@sp1= SuppliesPackage.new(@sp) es el mismo objeto que sp2= @sp"
      assert_same @sp3, @sp, "sp3 y sp tienen el mismo object id"
    end
  end #class
end #module