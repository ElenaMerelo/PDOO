# Author: Elena Merelo

require 'test/unit'
require_relative 'tc_weapon_type'
require_relative 'tc_loot'
require_relative 'tc_supplies_package'
require_relative 'tc_shield_booster'
require_relative 'tc_weapon'
require_relative 'tc_dice'

module Deepspace
  class TS_p1
    def self.suite
      suite= Test::Unit::TestSuite.new
      suite << TC_WeaponType.suite
      suite << TC_Loot.suite
      suite << TC_SuppliesPackage.suite 
      suite << TC_ShieldBooster.suite
      suite << TC_Weapon.suite
      suite << TC_Dice.suite
      
      return suite
    end
  end

end