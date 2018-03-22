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
      
      w1= Weapon.new("top laser", WeaponType::LASER, 3)
      w2= Weapon.new("mega misil", WeaponType::MISSILE, 4)
      w3= Weapon.new("plasmatron 3000", WeaponType::PLASMA, 2)
      
      puts "h1: #{h1}"
      #puts "h2: maxElements #{h2.maxElements}, weapons #{h2.weapons.join(", ")}, shieldBoosters #{h2.shieldBoosters.join(", ")}"
      
      h1.addWeapon(w1)
      h1.addWeapon(w2)
      h1.addWeapon(w3)
      
      puts "Tras aniadir armas h1: #{h1}"
      
      sh1= ShieldBooster.new("ghostbooster", 654.35, 3)
      h1.addShieldBooster(sh1)
      
      puts "Tras aniadir shieldBooster h1: #{h1}"
      
      h1.removeShieldBooster(0)
      h1.removeWeapon(2)
      
      puts "Tras quitar w3 y sh1 h1: #{h1}"
      
      h1.removeWeapon(0)
      puts "Tras quitar w1 h1: #{h1}"
      h1.removeWeapon(1)
      puts "Tras quitar w2: #{h1}"

    end
  end #class
  test= TestP2.new
  test.main
end #module