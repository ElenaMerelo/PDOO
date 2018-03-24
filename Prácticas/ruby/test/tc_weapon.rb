# Author: Elena Merelo

require 'test/unit'
require_relative '../lib/Weapon'

module Deepspace
  class TC_Weapon < Test::Unit::TestCase
    def setup
      @l= Weapon.new("l", WeaponType::LASER, 3)
      @m= Weapon.new("m", WeaponType::MISSILE, 3)
      @p= Weapon.new("p", WeaponType::PLASMA, 3)

      @l1= Weapon.newCopy(@l)
      @m1= Weapon.newCopy(@m)
      @p1= Weapon.newCopy(@p)
    end

    def test_name
      assert_equal "l", @l.name, "Error en name de l"
      assert_equal "m", @m.name, "Error en name de m"
      assert_equal "p", @p.name, "Error en name de p"

      assert_equal "l", @l1.name, "Error en name de l1"
      assert_equal "m", @m1.name, "Error en name de m1"
      assert_equal "p", @p1.name, "Error en name de p1"
    end

    def test_type
      assert_equal WeaponType::LASER, @l.type, "Error en type de l"
      assert_equal WeaponType::MISSILE, @m.type, "Error en type de m"
      assert_equal WeaponType::PLASMA, @p.type, "Error en type de p"

      assert_equal WeaponType::LASER, @l1.type, "Error en type de l1"
      assert_equal WeaponType::MISSILE, @m1.type, "Error en type de m1"
      assert_equal WeaponType::PLASMA, @p1.type, "Error en type de p1"
    end

    def test_power
      assert_equal 2.0, @l.power, "Error en power de l"
      assert_equal 3.0, @m.power, "Error en power de m"
      assert_equal 4.0, @p.power, "Error en power de p"

      assert_equal 2.0, @l1.power, "Error en power de l1"
      assert_equal 3.0, @m1.power, "Error en power de m1"
      assert_equal 4.0, @p1.power, "Error en power de p1"
    end

    def test_uses
      assert_equal 3, @l.uses, "Error en uses de l"
      assert_equal 3, @m.uses, "Error en uses de m"
      assert_equal 3, @p.uses, "Error en uses de p"

      assert_equal 3, @l1.uses, "Error en uses de l1"
      assert_equal 3, @m1.uses, "Error en uses de m1"
      assert_equal 3, @p1.uses, "Error en uses de p1"
    end

    def test_useIt
      for i in 0..2
        assert_equal 2.0, @l.useIt, "Error en useIt de l iteracion #{i}"
        assert_equal 3.0, @m.useIt, "Error en useIt de m iteracion #{i}"
        assert_equal 4.0, @p.useIt, "Error en useIt de p iteracion #{i}"

        assert_equal 2.0, @l1.useIt, "Error en useIt de l1 iteracion #{i}"
        assert_equal 3.0, @m1.useIt, "Error en useIt de m1 iteracion #{i}"
        assert_equal 4.0, @p1.useIt, "Error en useIt de p1 iteracion #{i}"
      end

      assert_equal 1.0, @l.useIt, "Error en useIt de l"
      assert_equal 1.0, @m.useIt, "Error en useIt de m"
      assert_equal 1.0, @p.useIt, "Error en useIt de p"

      assert_equal 1.0, @l1.useIt, "Error en useIt de l1"
      assert_equal 1.0, @m1.useIt, "Error en useIt de m1"
      assert_equal 1.0, @p1.useIt, "Error en useIt de p1"
    end
  end #class
end #module