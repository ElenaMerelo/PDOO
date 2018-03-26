# Author: Elena Merelo

require 'test/unit'
require_relative '../lib/Damage'
require_relative '../lib/Weapon'
#require_relative '../lib/ShieldBooster'
#require_relative '../lib/WeaponType'

module Deepspace
  class TC_Damage < Test::Unit::TestCase
    def setup
      @l= Weapon.new("l", WeaponType::LASER, 3)
      @m= Weapon.new("m", WeaponType::MISSILE, 3)
      @p= Weapon.new("p", WeaponType::PLASMA, 3)
      
      @w= [@l, @l, @l, @m, @m, @p]
      
      @d1= Damage.new(3, 2, nil)
      @d2= Damage.new(3,2, @w)
      @d3= Damage.newNumericWeapons(6, 2)
      @d4= Damage.newSpecificWeapons(@w, 2)
      
      @d5= Damage.newCopy(@d1)
      @d6= Damage.newCopy(@d2)
      @d7= Damage.newCopy(@d3)
      @d8= Damage.newCopy(@d4)
    end
    
    def test_initialize_d1
      assert_equal 3, @d1.nWeapons, "3 != d1.nWeapons"
      assert_equal 2, @d1.nShields, "2 != d1.nShields"
      assert_nil @d1.weapons, "nil != d1.weapons"
    end
    
    def test_initialize_d2
      assert_equal 0, @d2.nWeapons, "0 != d2.nWeapons"
      assert_equal 2, @d2.nShields, "2 != d2.nShields"
      
      index= 0
      for i in @d2.weapons
        assert_equal @w[index], i, " #{@w[index]} != #{i}"
        index += 1
      end
    end
    
    def test_initialize_d3
      assert_equal 6, @d3.nWeapons, "6 != d3.nWeapons"
      assert_equal 2, @d3.nShields, "2 != d3.nShields"
      assert_nil @d3.weapons, "nil != d3.weapons"
    end
    
    def test_initialize_d4
      assert_equal 0, @d4.nWeapons, "0 != d4.nWeapons"
      assert_equal 2, @d4.nShields, "2 != d4.nShields"
      
      index= 0
      for i in @d4.weapons
        assert_equal @w[index], i, " #{@w[index]} != #{i}"
        index += 1
      end
    end
    
    def test_initialize_d5
      assert_equal 3, @d5.nWeapons, "3 != d5.nWeapons"
      assert_equal 2, @d5.nShields, "2 != d5.nShields"
      assert_nil @d5.weapons, "nil != d5.weapons"
    end
    
    def test_initialize_d6
      assert_equal 0, @d6.nWeapons, "0 != d6.nWeapons"
      assert_equal 2, @d6.nShields, "2 != d6.nShields"
      
      index= 0
      for i in @d6.weapons
        assert_equal @w[index], i, " #{@w[index]} != #{i}"
        index += 1
      end
    end
    
    def test_initialize_d7
      assert_equal 6, @d7.nWeapons, "6 != d7.nWeapons"
      assert_equal 2, @d7.nShields, "2 != d7.nShields"
      assert_nil @d7.weapons, "nil != d7.weapons"
    end
    
    def test_initialize_d8
      assert_equal 0, @d8.nWeapons, "0 != d8.nWeapons"
      assert_equal 2, @d8.nShields, "2 != d8.nShields"
      
      index= 0
      for i in @d8.weapons
        assert_equal @w[index], i, " #{@w[index]} != #{i}"
        index += 1
      end
    end
    
    def test_responses_getUI
      assert_respond_to @d1, :getUIversion, "d1 doesn't respond to getUIversion"
      assert_respond_to @d2, :getUIversion, "d2 doesn't respond to getUIversion"
      assert_respond_to @d3, :getUIversion, "d3 doesn't respond to getUIversion"
      assert_respond_to @d4, :getUIversion, "d4 doesn't respond to getUIversion"
    end
    
    def test_responses_to_s
      assert_respond_to @d1, :to_s, "d1 doesn't respond to to_s"
      assert_respond_to @d2, :to_s, "d2 doesn't respond to to_s"
      assert_respond_to @d3, :to_s, "d3 doesn't respond to to_s"
      assert_respond_to @d4, :to_s, "d4 doesn't respond to to_s"
    end
    
    def test_discard_weapon_d1
      assert_equal 2, @d1.discardWeapon(@l), "2 != d1.nWeapons"
      assert_equal 1, @d1.discardWeapon(@m), "1 != d1.nWeapons"
      assert_equal 0, @d1.discardWeapon(@p), "0 != d1.nWeapons"
      assert_nil @d1.discardWeapon(@l), "nil != d1.nWeapons"
    end
    
    def test_discard_weapon_d2
      w2= [@l, @l, @m, @m, @p]
      
      @d2.discardWeapon(@l)
      index= 0
      for i in @d2.weapons
        assert_equal w2[index], i, " #{w2[index]} != #{i}"
        index += 1
      end
      
      @d2.discardWeapon(@m)
      index= 0
      w2.delete_at(2)
      for i in @d2.weapons
        assert_equal w2[index], i, " #{w2[index]} != #{i}"
        index += 1
      end
      
      @d2.discardWeapon(@p)
      index= 0
      w2.delete_at(3)
      for i in @d2.weapons
        assert_equal w2[index], i, " #{w2[index]} != #{i}"
        index += 1
      end
      
      @d2.discardWeapon(@p)
      index= 0
      for i in @d2.weapons
        assert_equal w2[index], i, " #{w2[index]} != #{i}"
        index += 1
      end
    end
    
    def test_discard_weapon_d3
      for i in 0..5
      assert_equal 5-i, @d3.discardWeapon(@p), "#{5-i} != d3.discardWeapon(@p)"
    end
      assert_equal 0, @d3.nWeapons, "d3.nWeapons != 0"
    end
    
    def test_discard_weapon_d4
      @d4.discardWeapon(@p)
      @w.pop 
      for i in 0..4
        assert_equal @d4.weapons[i], @w[i], "#{@d4.weapons[i]} != #{@w[i]}"
      end
      
      @d4.discardWeapon(@m)
      @w.delete_at(3)
      for i in 0..4
        assert_equal @d4.weapons[i], @w[i], "#{@d4.weapons[i]} != #{@w[i]}"
      end
      
      @d4.discardWeapon(@m)
      @w.delete(@m)
      for i in 0..4
        assert_equal @d4.weapons[i], @w[i], "#{@d4.weapons[i]} != #{@w[i]}"
      end
      
      for i in 0..2
        @d4.discardWeapon(@l)
      end
      
      assert_empty @d4.weapons, "d4.weapons != empty"
      
    end
    
    def test_discard_shield_booster
      #d1
      assert_equal 1, @d1.discardShieldBooster, "1 != d1.discardShieldBooster"
      assert_equal 0, @d1.discardShieldBooster, "0 != d1.discardShieldBooster"
      assert_nil @d1.discardShieldBooster, "nil != d1.discardShieldBooster"
      
      #d2
      assert_equal 1, @d2.discardShieldBooster, "1 != d2.discardShieldBooster"
      assert_equal 0, @d2.discardShieldBooster, "0 != d2.discardShieldBooster"
      assert_nil @d2.discardShieldBooster, "nil != d2.discardShieldBooster"
      
      #d3
      assert_equal 1, @d3.discardShieldBooster, "1 != d3.discardShieldBooster"
      assert_equal 0, @d3.discardShieldBooster, "0 != d3.discardShieldBooster"
      assert_nil @d3.discardShieldBooster, "nil != d3.discardShieldBooster"
      
      #d4
      assert_equal 1, @d4.discardShieldBooster, "1 != d4.discardShieldBooster"
      assert_equal 0, @d4.discardShieldBooster, "0 != d4.discardShieldBooster"
      assert_nil @d4.discardShieldBooster, "nil != d4.discardShieldBooster"
    end
    
    def test_has_no_effect
      assert_false @d1.hasNoEffect, "d1 has no effect"
      assert_false @d2.hasNoEffect, "d2 has no effect"
      assert_false @d3.hasNoEffect, "d3 has no effect"
      assert_false @d4.hasNoEffect, "d4 has no effect"
      
      d9= Damage.new(0, 0, @w)
      assert_false d9.hasNoEffect, "d9 has effect"
      
      d10= Damage.new(0, 0, nil)
      assert d10.hasNoEffect, "d10 has effect"
    end
    
    def test_adjust
      
    end
    
    @w= [@l, @l, @l, @m, @m, @p]
      
      @d1= Damage.new(3, 2, nil)
      @d2= Damage.new(3,2, @w)
      @d3= Damage.newNumericWeapons(6, 2)
      @d4= Damage.newSpecificWeapons(@w, 2)
      
      @d5= Damage.newCopy(@d1)
      @d6= Damage.newCopy(@d2)
      @d7= Damage.newCopy(@d3)
      @d8= Damage.newCopy(@d4)
  end
end
