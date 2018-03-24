# Author: Elena Merelo


require 'test/unit'
require_relative '../lib/WeaponType'


module Deepspace
  class TC_WeaponType < Test::Unit::TestCase
    def test_weapon_type
      assert_equal(2.0, WeaponType::LASER.power, "LASER.power doesn't work")
      assert_equal(3.0, WeaponType::MISSILE.power, "MISSILE.power doesn't work")
      assert_equal(4.0, WeaponType::PLASMA.power, "PLASMA.power doesn't work")
    end 
  end
end