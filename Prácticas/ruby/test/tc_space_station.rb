# Author: Elena Merelo

require 'test/unit'
require_relative '../lib/SpaceStation'
require_relative '../lib/SuppliesPackage'
require_relative '../lib/Weapon'
require_relative '../lib/Hangar'
require_relative '../lib/WeaponType'
require_relative '../lib/ShieldBooster'
require_relative '../lib/Damage'

module Deepspace
  class TC_SpaceStation < Test::Unit::TestCase
    def setup
      #SuppliesPackage
      @s= SuppliesPackage.new(1.1, 2.2, 3.3)
      
      #SpaceStation
      @ss1= SpaceStation.new("ss1", @s)
      @ss2= SpaceStation.new("ss2", @s)
      @ss3= SpaceStation.new("ss3", @s)
      
      #Weapons
      @l1= Weapon.new("l1", WeaponType::LASER, 3)
      @l2= Weapon.new("l2", WeaponType::LASER, 0)
      @m1= Weapon.new("m1", WeaponType::MISSILE, 2)
      @m2= Weapon.new("m2", WeaponType::MISSILE, 0)
      @p1= Weapon.new("p1", WeaponType::PLASMA, 1)
      @p2= Weapon.new("p2", WeaponType::PLASMA, 0)
      
      #ShieldBooster
      @sb1= ShieldBooster.new("sb1", 5.6, 3)
      @sb2= ShieldBooster.new("sb2", 5.6, 0)
      
      #Hangars
      @h= Hangar.new(9)
      
      @v1= [@l1, @l2, @m1, @m2, @p1, @p2]
      @v2= [@sb1, @sb2]
      
      for i in @v1
        @h.addWeapon(i)
      end
      
      for i in @v2
        @h.addShieldBooster(i)
      end
      
      @h1= Hangar.new(4)
      @v3= [@l1, @m2, @p2]
      @v4= [@sb1]
      
      for i in @v3
        @h1.addWeapon(i)
      end
      
      @h1.addShieldBooster(@sb1)
    end

    def test_initialize 
      assert_equal "ss1", @ss1.name, " ss1 != ss1.name"
      assert_equal 1.1, @ss1.ammoPower, "1.1 != ss1.ammoPower"
      assert_equal 2.2, @ss1.fuelUnits, "2.2 != ss1.fuelUnits"
      assert_equal 3.3, @ss1.shieldPower, "1.1 != ss1.shieldPower" 
      assert_equal 0, @ss1.nMedals, " 0 != ss1.nMedals"
      assert_empty @ss1.weapons, " empty != ss1.weapons"
      assert_empty @ss1.shieldBoosters, "empty != ss1.shieldBoostes"
      assert_nil @ss1.hangar, " nil != ss1.hangar"
      assert_nil @ss1.pendingDamage, " nil != ss1.pendingDamage"
    end
    
    def test_receive_weapon
      assert_equal false, @ss1.receiveWeapon(@l), "Se dispone de hangar"
      assert_equal false, @ss1.receiveWeapon(@m), "Se dispone de hangar"
      assert_equal false, @ss1.receiveWeapon(@p), "Se dispone de hangar"
      
      @ss1.receiveHangar(@h)
      assert @ss1.receiveWeapon(@l), "No hay espacio en el hangar para l"
      assert_equal false, @ss1.receiveWeapon(@l), "Hay espacio en el hangar para l"
      assert_equal false, @ss1.receiveWeapon(@m), "Hay espacio en el hangar para m"
      assert_equal false, @ss1.receiveWeapon(@p), "Hay espacio en el hangar para p"
    end
    
    def test_receive_shield_booster
      assert_equal false, @ss2.receiveShieldBooster(@sb1), "Se dispone de hangar"
      assert_equal false, @ss2.receiveShieldBooster(@sb2), "Se dispone de hangar"
      
      @ss2.receiveHangar(@h)
      assert @ss2.receiveShieldBooster(@sb1), "No hay espacio en el hangar para sb1"
      assert_equal false, @ss2.receiveShieldBooster(@sb1), "Hay espacio en el hangar para sb1"
      assert_equal false, @ss2.receiveShieldBooster(@sb2), "Hay espacio en el hangar para sb2"
    end
    
    def test_receive_hangar
      assert_equal @h1, @ss3.receiveHangar(@h1), "ss3 ya tiene hangar"
      
      @ss1.receiveHangar(@h)
      assert_nil @ss1.receiveHangar(@h1), "ss1 no tenia hangar"
      
      @ss2.receiveHangar(@h)
      assert_nil @ss2.receiveHangar(@h1), "ss2 no tenia hangar"
    end
    
    def test_discard_hangar
      @ss1.receiveHangar(@h) 
      assert_equal @h, @ss1.hangar, "h != ss1.hangar"
      @ss1.discardHangar
      assert_nil @ss1.hangar, "ss1.hangar != nil"
    end
    
    def test_receive_supplies
      @ss1.receiveSupplies(@s) 
      assert_equal 2.2, @ss1.ammoPower, " 2.2 != ss1.ammoPower"
      assert_equal 4.4, @ss1.fuelUnits, " 4.4 != ss1.fuelUnits"
      assert_equal 6.6, @ss1.shieldPower, " 6.6 != ss1.shieldPower"
    end
    
    def test_set_pending_damage
      @ss1.receiveHangar(Hangar.new(10))
      
      for i in @v1
        @ss1.receiveWeapon(i)
      end
   
      @ss1.receiveShieldBooster(@sb1)
      
      for i in 0..@v1.length-1
        @ss1.mountWeapon(0)
      end
      
      @ss1.mountShieldBooster(0)
      
      weapon_types= [WeaponType::LASER, WeaponType::MISSILE, WeaponType::PLASMA]
      
      @ss1.setPendingDamage(Damage.newSpecificWeapons(weapon_types, 2))
      
      assert_equal @ss1.pendingDamage.nShields, 1, "1 != ss1.pendingDamage.nShields "
      assert_equal weapon_types, @ss1.pendingDamage.weapons, "weapon_types != @ss1.pendingDamage.weapons" 
    end
    
    def test_mount_weapon
      assert_nil @ss1.mountWeapon(0), " nil != ss1.mountWeapon(0)"
      
      @ss1.receiveHangar(@h1)
      
      @ss1.mountWeapon(0) 
      assert_equal [@l1], @ss1.weapons, " [@l1] != ss1.weapons"
      
      @ss1.mountWeapon(0)
      assert_equal [@l1, @m2], @ss1.weapons, "[@l1, @m2] != @ss1.weapons "
      
      @ss1.mountWeapon(0)
      assert_equal [@l1, @m2, @p2], @ss1.weapons, "[@l1, @m2, @p2] != @ss1.weapons "
    end
    
    def test_mount_shield_booster
      assert_nil @ss1.mountShieldBooster(0), "nil != ss1.mountShieldBooster(0)"
      
      @ss1.receiveHangar(@h1)
      
      @ss1.mountShieldBooster(0) 
      assert_equal [@sb1], @ss1.shieldBoosters, " [@sb1] != ss1.shieldBoosters"
    end
    
    
    def test_discard_weapon_in_hangar
      assert_nil @ss1.discardWeaponInHangar(0) 
      
      @ss1.receiveHangar(@h1)
      
      @ss1.discardWeaponInHangar(2)
      assert_equal [@l1, @m2], @ss1.hangar.weapons, "[@l1, @m2] != @ss1.hangar.weapons"
      
      @ss1.discardWeaponInHangar(0)
      assert_equal [@m2], @ss1.hangar.weapons, "[@m2] != @ss1.hangar.weapons"
      
      @ss1.discardWeaponInHangar(0)
      assert_empty @ss1.hangar.weapons, "empty != @ss1.hangar.weapons"
    end
    
    def test_discard_shield_booster_in_hangar
      assert_nil @ss1.discardWeaponInHangar(0) 
      
      @ss1.receiveHangar(@h1)
      
      @ss1.discardShieldBoosterInHangar(0)
      assert_empty @ss1.hangar.shieldBoosters, "empty != @ss1.hangar.shieldBoosters"
    end
    
    def test_getSpeed
      assert_equal @ss1.fuelUnits/100, @ss1.getSpeed, "0.022 != @ss1.speed"
    end
    
    def test_move
      assert_equal @ss1.fuelUnits - @ss1.getSpeed*@ss1.fuelUnits, @ss1.move, "@ss1.fuelUnits - @ss1.speed != @ss1.move"
    end
    
    def test_valid_state
      assert @ss1.validState, "ss1 no esta en un estado valido"
      
      @ss1.receiveHangar(Hangar.new(10))
      
      for i in @v1
        @ss1.receiveWeapon(i)
      end
   
      @ss1.receiveShieldBooster(@sb1)
      
      for i in 0..@v1.length-1
        @ss1.mountWeapon(0)
      end
      
      @ss1.mountShieldBooster(0)
      weapon_types= [WeaponType::LASER, WeaponType::MISSILE, WeaponType::PLASMA]
      @ss1.setPendingDamage(Damage.newSpecificWeapons(weapon_types, 2))
      
      assert_equal false, @ss1.validState, "ss1 esta en un estado valido"
      
      @ss1.setPendingDamage(Damage.newSpecificWeapons([], 0))
      assert @ss1.validState, "ss1 no esta en un estado valido"
      
      @ss1.setPendingDamage(Damage.newSpecificWeapons([], 1))
      assert_equal false, @ss1.validState, "ss1 esta en un estado valido"
      
      @ss1.setPendingDamage(Damage.newNumericWeapons(3, 2))
      assert_equal false, @ss1.validState, "ss1 esta en un estado valido"
      
      @ss1.setPendingDamage(Damage.newNumericWeapons(0, 0))
      assert @ss1.validState, "ss1 no esta en un estado valido"
  
    end
    
    def test_clean_up_mounted_items
      @ss1.receiveHangar(@h)
      
      for i in 0..@ss1.hangar.weapons.length-1
        @ss1.mountWeapon(i)
      end
      
      for i in 0..@ss1.hangar.shieldBoosters.length-1
        @ss1.mountShieldBooster(i)
      end
      
      @ss1.cleanUpMountedItems 
      assert_equal [@l1, @m1, @p1], @ss1.weapons, "[@l1, @m1, @p1] != @ss1.weapons"
      assert_equal [@sb1], @ss1.shieldBoosters, "[@sb1] != @ss1.shieldBoosters"
    end
    
    def test_getUIversion
      assert_respond_to @ss1, :getUIversion, "ss1 doesn't respond to getUIversion"
    end
  end
end