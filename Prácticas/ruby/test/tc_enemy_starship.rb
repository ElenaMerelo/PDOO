# Author: Elena Merelo

require 'test/unit'
require_relative '../lib/EnemyStarShip'
require_relative '../lib/Loot'
require_relative '../lib/ShotResult'
require_relative '../lib/Damage'
require_relative '../lib/EnemyToUI'

module Deepspace
  class TC_EnemyStarShip < Test::Unit::TestCase
    def setup
      @l= Loot.new(1, 2, 3, 4, 5)

      @laser= Weapon.new("laser", WeaponType::LASER, 3)
      @m= Weapon.new("m", WeaponType::MISSILE, 2)
      @p= Weapon.new("p", WeaponType::PLASMA, 1)

      @w= [@laser, @m , @p]

      @d1= Damage.newNumericWeapons(3, 2)
      @d2= Damage.newSpecificWeapons(@w, 2)

      @es1= EnemyStarShip.new("es1", 2.3, 3.4, @l, @d1)
      @es2= EnemyStarShip.new("es2", 2.3, 3.4, @l, @d2)
      @es3= EnemyStarShip.newCopy(@es1)
      @es4= EnemyStarShip.newCopy(@es2)
    end

    def test_inititialize_es1
      assert_equal "es1", @es1.name, "es1 != es1.name"
      assert_equal 2.3, @es1.ammoPower, "2.3 != es1.ammoPower"
      assert_equal 3.4, @es1.shieldPower, "3.4 != es1.shieldPower"
      assert_equal @l, @es1.loot, "@l != es1.loot"
      assert_equal @d1, @es1.damage, "@d != es1.damage"
    end

    def test_inititialize_es2
      assert_equal "es2", @es2.name, "es2 != es2.name"
      assert_equal 2.3, @es2.ammoPower, "2.3 != es2.ammoPower"
      assert_equal 3.4, @es2.shieldPower, "3.4 != es2.shieldPower"
      assert_equal @l, @es2.loot, "@l != es2.loot"
      assert_equal @d2, @es2.damage, "@d != es2.damage"
    end

    def test_inititialize_es3
      assert_equal @es1.name, @es3.name, "es1.name != es3.name"
      assert_equal @es1.ammoPower, @es3.ammoPower, "es1.ammoPower != es3.ammoPower"
      assert_equal @es1.shieldPower, @es3.shieldPower, "es1.shieldPower != es3.shieldPower"
      assert_equal @es1.loot, @es3.loot, "@es1.loot != es3.loot"
      assert_equal @es1.damage, @es3.damage, "@es1.damage != es3.damage"
    end

    def test_inititialize_es4
      assert_equal @es2.name, @es4.name, "es2.name != es4.name"
      assert_equal @es2.ammoPower, @es4.ammoPower, "es2.ammoPower != es4.ammoPower"
      assert_equal @es2.shieldPower, @es4.shieldPower, "es2.shieldPower != es4.shieldPower"
      assert_equal @es2.loot, @es4.loot, "@es2.loot != es4.loot"
      assert_equal @es2.damage, @es4.damage, "@es2.damage != es4.damage"
    end

    def test_responses
      assert_respond_to @es1, :getUIversion, "es1 doesn't respond to getUIversion"
      assert_respond_to @es2, :getUIversion, "es2 doesn't respond to getUIversion"
      assert_respond_to @es3, :getUIversion, "es3 doesn't respond to getUIversion"
      assert_respond_to @es4, :getUIversion, "es4 doesn't respond to getUIversion"
    end

    def test_fire
      assert_equal 2.3, @es1.fire, "2.3 != es1.fire"
      assert_equal 2.3, @es2.fire, "2.3 != es2.fire"
      assert_equal 2.3, @es3.fire, "2.3 != es3.fire"
      assert_equal 2.3, @es4.fire, "2.3 != es4.fire"
    end

    def test_protection
      assert_equal 3.4, @es1.protection, "3.4 != es1.protection"
      assert_equal 3.4, @es2.protection, "3.4 != es2.protection"
      assert_equal 3.4, @es3.protection, "3.4 != es3.protection"
      assert_equal 3.4, @es4.protection, "3.4 != es4.protection"
    end

    def test_shot
      assert_equal ShotResult::DONOTRESIST, @es1.receiveShot(4), "ShotResult::DONOTRESIST != @es2.receiveShot(3)"
      assert_equal ShotResult::RESIST, @es1.receiveShot(3.3), "ShotResult::RESIST != @es2.receiveShot(3.5)"

      assert_equal ShotResult::DONOTRESIST, @es2.receiveShot(4), "ShotResult::DONOTRESIST != @es2.receiveShot(3)"
      assert_equal ShotResult::RESIST, @es2.receiveShot(3.3), "ShotResult::RESIST != @es2.receiveShot(3.5)"
    end
  end
end