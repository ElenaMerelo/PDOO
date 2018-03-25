# Author: Elena Merelo

require 'test/unit'
require_relative '../lib/Hangar'
require_relative '../lib/Weapon'
require_relative '../lib/ShieldBooster'
require_relative '../lib/WeaponType'

module Deepspace
  class TC_Hangar < Test::Unit::TestCase
    def setup
      @h= Hangar.new(9)
      @h1= Hangar.newCopy(@h)

      @l= Weapon.new("l", WeaponType::LASER, 3)
      @m= Weapon.new("m", WeaponType::MISSILE, 3)
      @p= Weapon.new("p", WeaponType::PLASMA, 3)

      @sb= ShieldBooster.new("sb", 23.23, 3) 
    end

    def test_initialitation
      assert_equal 9, @h.maxElements, "Error en maxElements de h"
      assert_empty @h.weapons, "weapons de h es no vacio"
      assert_empty @h.shieldBoosters, "shieldBoosters de h es no vacio"
    end

    def test_copy_initialitation
      assert_not_equal @h1, @h, "h == h1"
      assert_not_same @h1, @h, "h.equal?(h1) == true"
      
      assert_equal 9, @h1.maxElements, "Error en maxElements de h1"
      assert_empty @h1.weapons, "weapons de h1 es no vacio"
      assert_empty @h1.shieldBoosters, "shieldBoosters de h1 es no vacio"
    end

    def test_responses 
      assert_respond_to @h, :maxElements, "@h no responde a maxElements"
      assert_respond_to @h, :weapons, "@h no responde a weapons"
      assert_respond_to @h, :shieldBoosters, "@h no responde a shieldBoosters"
      assert_respond_to @h, :getUIversion, "@h no responde a getUIversion"
      assert_respond_to @h, :addWeapon, "@h no responde a addWeapon"
      assert_respond_to @h, :removeWeapon, "@h no responde a removeWeapon"
      assert_respond_to @h, :addShieldBooster, "@h no responde a addShieldBooster"
      assert_respond_to @h, :removeShieldBooster, "@h no responde a removeShieldBooster"
      assert_respond_to @h, :to_s, "@h no responde a to_s"
    end
    
    def test_copy_responses 
      assert_respond_to @h1, :maxElements, "@h1 no responde a maxElements"
      assert_respond_to @h1, :weapons, "@h1 no responde a weapons"
      assert_respond_to @h1, :shieldBoosters, "@h1 no responde a shieldBoosters"
      assert_respond_to @h1, :getUIversion, "@h1 no responde a getUIversion"
      assert_respond_to @h1, :addWeapon, "@h1 no responde a addWeapon"
      assert_respond_to @h1, :removeWeapon, "@h1 no responde a removeWeapon"
      assert_respond_to @h1, :addShieldBooster, "@h1 no responde a addShieldBooster"
      assert_respond_to @h1, :removeShieldBooster, "@h1 no responde a removeShieldBooster"
      assert_respond_to @h1, :to_s, "@h1 no responde a to_s"
    end
    

    def test_add_weapon
      v= [@l, @l, @l, @m, @m, @p]
      
      for i in 0..(v.length-1)
        assert_equal true, @h.addWeapon(v[i]), "No queda espacio en el hangar h"
      end
      
      index= 0
      assert_block do
        @h.weapons.each do |i|
          assert_equal v[index], i, "#{v[index]} != #{i}"
          index += 1
        end
      end
    end
    
    def test_copy_add_weapon
      v= [@l, @l, @l, @m, @m, @p]
      
      for i in 0..(v.length-1)
        assert_equal true, @h1.addWeapon(v[i]), "No queda espacio en el hangar h1"
      end
      
      index= 0
      assert_block do
        @h1.weapons.each do |i|
          assert_equal v[index], i, "#{v[index]} != #{i}"
          index += 1
        end
      end
    end
    
    def test_add_shield_boosters
      v= [@s, @s]
      
      for i in 0..(v.length-1)
        assert_equal true, @h.addShieldBooster(v[i]), "No queda espacio en el hangar"
      end
      
      assert_equal false, @h.addShieldBooster(@s), "Queda espacio en el hangar"
      v.push(@s)
      
      index= 0
      assert_block do
        @h.shieldBoosters.each do |i|
          assert_equal v[index], i, "#{v[index]} != #{i}"
          index += 1
        end
      end
    end
    
    def test_copy_add_shield_boosters
      v= [@s, @s]
      
      for i in 0..(v.length-1)
        assert_equal true, @h1.addShieldBooster(i), "No queda espacio en el hangar h1"
      end
      
      assert_equal false, @h1.addShieldBooster(@s), "Queda espacio en el hangar h1"
      v.push(@s)
      
      index= 0
      assert_block do
        @h1.shieldBoosters.each do |i|
          assert_equal v[index], i, "#{v[index]} != #{i}"
          index += 1
        end
      end
    end
    
    def test_remove_weapons
      for i in 0..2
        assert_equal @l, @h.removeWeapon(i), "El arma en la posicion #{i} no es un laser"
      end
      
      for i in 0..1
        assert_equal @m, @h.removeWeapon(i), "El arma en la posicion #{i} no es un misil" 
      end
      
      assert_equal @p, @h.removeWeapon(6), "El arma en la posicion #{i} no es un plasma"
      assert_nil @h.removeWeapon(7), "El arma en la posicion #{7} no es nil"
    end
    
    def test_copy_remove_weapons
      for i in 0..2
        assert_equal @l, @h1.removeWeapon(i), "El arma en la posicion #{i} no es un laser"
      end
      
      for i in 0..1
        assert_equal @m, @h1.removeWeapon(i), "El arma en la posicion #{i} no es un misil" 
      end
      
      assert_equal @p, @h1.removeWeapon(6), "El arma en la posicion #{i} no es un plasma"
      assert_nil @h1.removeWeapon(7), "El arma en la posicion #{7} no es nil"
      assert_nil @h1.removeWeapon(432), "El arma en la posicion #{432} no es nil"
    end
    
    def test_remove_shield_boosters
      for i in 0..2
        assert_equal @sb, @h.removeShieldBooster(i), "En la posicion #{i} no hay un shieldBooster"
      end
      
      assert_nil @h.removeShieldBooster(3), "La posicion 3 es distinta de nil"
      assert_nil @h.removeShieldBooster(432), "La posicion 432 es distinta de nil"
    end
  end #class
end #module