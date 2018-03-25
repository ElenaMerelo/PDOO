# Author: Elena Merelo


require 'test/unit'
require_relative '../lib/WeaponType'


module Deepspace
  class TC_WeaponType < Test::Unit::TestCase
    def test_definition
      assert !WeaponType::LASER.nil?, "LASER no definido"
      assert !WeaponType::MISSILE.nil?, "MISSILE no definido"
      assert !WeaponType::PLASMA.nil?, "PLASMA no definido"
    end
    
    def test_weapon_type
      assert_equal(2.0, WeaponType::LASER.power, "LASER.power doesn't work")
      assert_equal(3.0, WeaponType::MISSILE.power, "MISSILE.power doesn't work")
      assert_equal(4.0, WeaponType::PLASMA.power, "PLASMA.power doesn't work")
    end 
    
    def test_responses
      assert_respond_to WeaponType::LASER, :power, "LASER doesn't respond to power"
      assert_respond_to WeaponType::MISSILE, :power, "MISSILE doesn't respond to power"
      assert_respond_to WeaponType::PLASMA, :power, "PLASMA doesn't respond to power"
    end
  end
end