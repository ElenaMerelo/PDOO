# Author: Elena Merelo Molina

require_relative "CombatResult"
require_relative "GameCharacter"
require_relative "Loot"
require_relative "ShieldBooster"
require_relative "ShotResult"
require_relative "SuppliesPackage"
require_relative "Weapon"
require_relative "WeaponType"
require_relative 'Dice'
require_relative 'Damage'
require_relative 'EnemyStarShip'
require_relative 'SpaceStation'
require_relative 'Hangar'

module Deepspace
  class TestP2
    def main
      #Hangar
      h1= Hangar.new(10)
      h2= Hangar.newCopy(h1)
      
      l1= Weapon.new("l1", WeaponType::LASER, 3)
      m1= Weapon.new("m1", WeaponType::MISSILE, 4)
      p1= Weapon.new("p1", WeaponType::PLASMA, 2)
      
      
      puts "h1: #{h1}"
      puts "h2: maxElements #{h2.maxElements}, weapons #{h2.weapons.join(", ")}, shieldBoosters #{h2.shieldBoosters.join(", ")}"
      
      for i in 0..2
        h1.addWeapon(l1)
      end
      
      for i in 0..1
        h1.addWeapon(m1)
      end
      
      h1.addWeapon(p1)
      
      puts "Tras aniadir armas h1: #{h1}"
      
      sh1= ShieldBooster.new("sh1", 654.35, 3)
      h1.addShieldBooster(sh1)
      
      puts "Tras aniadir shieldBooster h1: #{h1}"
      
      h1.removeShieldBooster(0)
      h1.removeWeapon(2)
      
      puts "Tras quitar w(3) y sh(0) h1: #{h1}"
      
      h1.removeWeapon(1)
      puts "Tras quitar w2 h1: #{h1}"
      h1.removeWeapon(0)
      puts "Tras quitar w1: #{h1}"
      
      h1.getUIversion
      
      #Damage
      d1= Damage.newNumericWeapons(3,3)
      d2= Damage.newCopy(d1)
      v1= [l1, m1]
      v2= [sh1, sh1, sh1]
      v3= [l1, l1, l1, m1, m1, p1]
      
      puts "d1: #{d1}"
      puts "d2: nWeapons #{d2.nWeapons}, nShields #{d2.nShields}"
      
      d3=Damage.newSpecificWeapons(v3, 2)
      d4= Damage.newCopy(d3)
      
      puts "d3: #{d3}"
      puts "d4: nShields #{d4.nShields}, weapons #{d4.weapons.join(",")}"
      adjusted= d3.adjust(v1,v2)
      
      print "\n\nAdjusted nShields #{adjusted.nShields}, weapons #{adjusted.weapons.join(",")} \n"
      d1.discardWeapon(l1)
      puts "Discarding l1 in d1: #{d1.nWeapons}"
      d3.discardWeapon(l1)
      d3.discardWeapon(l1)
      d3.discardWeapon(m1)
      d3.discardWeapon(p1)
      puts "Discarding l1 in d3: #{d3.weapons.join(",")}"
      
      d5= Damage.new(0, 0, v1)
      
      if d3.hasNoEffect
        puts "d3 has no effect"
      else
        puts "d3 has effect"
      end
      
      if d5.hasNoEffect
        puts "d5 has no effect"
      else
        puts "d5 has effect"
      end
    end
  end #class
  test= TestP2.new
  test.main
end #module



















