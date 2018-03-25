# Author: Elena Merelo
# encoding:utf-8
# No sé por qué al pasar de un método a otro se vacían los vectores.
require 'test/unit'
require_relative '../lib/Hangar'
require_relative '../lib/Weapon'
require_relative '../lib/ShieldBooster'
require_relative '../lib/WeaponType'

module Deepspace
  class TC_Hangar < Test::Unit::TestCase
    def setup
      @h= Hangar.new(4)

      @l= Weapon.new("l", WeaponType::LASER, 3)
      @m= Weapon.new("m", WeaponType::MISSILE, 3)
      @p= Weapon.new("p", WeaponType::PLASMA, 3)

      @sb= ShieldBooster.new("sb", 23.23, 3)
      
    end

    def test_initialitation
      assert_equal 4, @h.maxElements, "Error en maxElements de h"
      assert_empty @h.weapons, "weapons de h es no vacio"
      assert_empty @h.shieldBoosters, "shieldBoosters de h es no vacio"
    end

    def test_copy_initialitation
      h1= Hangar.newCopy(@h)
      assert_not_equal h1, @h, "h == h1"
      assert_not_same h1, @h, "h.equal?(h1) == true"
      
      assert_equal 4, h1.maxElements, "Error en maxElements de h1"
      assert_empty h1.weapons, "weapons de h1 es no vacio"
      assert_empty h1.shieldBoosters, "shieldBoosters de h1 es no vacio"
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

    def test_weapons
      #addWeapon
      assert_equal true, @h.addWeapon(@l), "No queda espacio en el hangar h"
      assert_equal true, @h.addWeapon(@m), "No queda espacio en el hangar h"
      assert_equal true, @h.addWeapon(@p), "No queda espacio en el hangar h"
      
      assert_equal @l , @h.weapons[0]
      assert_equal @m , @h.weapons[1]
      assert_equal @p , @h.weapons[2]
      
      #removeWeapon
      assert_equal @l, @h.removeWeapon(0), "El arma en la posicion 0 no es un laser"
      
      assert_equal @m, @h.removeWeapon(0), "El arma en la posicion 0 no es un misil" 
      
      assert_equal @p, @h.removeWeapon(0), "El arma en la posicion 0 no es un plasma"
      
      assert_nil @h.removeWeapon(0), "El arma en la posicion 0 no es nil"
    end
    
    def test_shield_boosters
      #addShieldBooster
      assert_equal true, @h.addShieldBooster(@sb), "No queda espacio en el hangar"
      
      assert_equal true, @h.addShieldBooster(@sb), "Queda espacio en el hangar h, #{@h.shieldBoosters.join(",")}, #{@h.weapons.join(",")}"
     
      assert_equal [@sb, @sb], @h.shieldBoosters, "[@sb, @sb] != h.shieldBoosters"
      
      #removeShieldBooster
      assert_equal @sb, @h.removeShieldBooster(0), "En la posicion 0 no hay un shieldBooster"
      assert_equal @sb, @h.removeShieldBooster(0), "En la posicion 0 no hay un shieldBooster"
      
      assert_nil @h.removeShieldBooster(0), "Hay mas shieldBoosters"
    end 
  end #class
end #module