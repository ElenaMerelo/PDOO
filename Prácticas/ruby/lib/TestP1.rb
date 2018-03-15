# Programa de prueba de la práctica 1
# Author: Elena Merelo Molina

#encoding: utf-8

require_relative "CombatResult"
require_relative "Dice"
require_relative "Weapon"
require_relative "ShieldBooster"
require_relative "SuppliesPackage"
require_relative "Loot"
require_relative "WeaponType"
require_relative "ShotResult"
require_relative "GameCharacter"

module Deepspace
  class TestP1
    def main
      #Loot
      l= Loot.new(1, 2, 3, 4, 5)
      
      puts "nSupplies #{l.nSupplies}, nWeapons: #{l.nWeapons}, nShields 
      #{l.nShields}, nHangars #{l.nHangars}, nMedals #{l.nMedals}"
      
      #SuppliesPackage
      s1= SuppliesPackage.new(3.33, 65.5, 8.12)
      s2= SuppliesPackage.newCopy(s1)
      
      puts "s1: ammoPower #{s1.ammoPower}, fuelUnits #{s1.fuelUnits}, shieldPower #{s1.shieldPower}"
      puts "s2: ammoPower #{s2.ammoPower}, fuelUnits #{s2.fuelUnits}, shieldPower #{s2.shieldPower}"
      
      #ShieldBooster 
      sh1= ShieldBooster.new("ghostbooster", 654.35, 3)
      sh2= ShieldBooster.newCopy(sh1)
      
      puts "sh1: name #{sh1.name}, boost #{sh1.boost}, uses #{sh1.uses}"
      puts "sh2: name #{sh2.name}, boost #{sh2.boost}, uses #{sh2.uses}"
      
      puts "useIt: "
      for i in 0..5 do
        puts sh1
        puts "#{sh1.useIt}"
      end
      
      #Weapon 
      w1= Weapon.new("laser de la vida", WeaponType::LASER, 3) 
      w2= Weapon.newCopy(w1)
      puts "Name #{w1.name}, type #{w1.type.power}, uses #{w1.uses}"
      puts "Name #{w2.name}, type #{w2.type.power}, uses #{w2.uses}"
      
      w3= Weapon.new("mega misil", WeaponType::MISSILE, 4) 
      w4= Weapon.newCopy(w3)
      puts w3
      puts w4
      
      w5= Weapon.new("plasmatron 3000", WeaponType::PLASMA, 2) 
      w6= Weapon.newCopy(w5)
      puts w5
      puts w6
      
      for j in 0..5 do
        puts "useIt iteracion #{j}"
        puts w1
        puts "#{w1.useIt}"
        
        puts w3
        puts "#{w3.useIt}"
        
        puts w5
        puts "#{w5.useIt}"
      end
      
      #Dice
      d= Dice.new
      prob_hangar_0 = prob_hangar_1 = prob_shield_0 = prob_shield_1 = 
        prob_weapon_1 = prob_weapon_2 = prob_weapon_3 = prob_true = prob_false=
        prob_space_station = prob_enemy = 0
      
      for k in 0..99 do
        if d.initWithNHangars == 0
          prob_hangar_0 += 1
        else
          prob_hangar_1 += 1
        end
        
        if d.initWithNWeapons == 1
          prob_weapon_1 += 1
        elsif d.initWithNWeapons == 2
            prob_weapon_2 += 1
        else 
          prob_weapon_3 += 1
        end
        
        if d.initWithNShields == 0
          prob_shield_0 += 1
        else 
          prob_shield_1 += 1
        end
        
        if d.firstShot() == GameCharacter::SPACESTATION
            prob_space_station += 1
        else
            prob_enemy += 1
        end

        if d.spaceStationMoves(0.34) == true 
            prob_true += 1
        else
          prob_false += 1
        end
      puts "Empieza el jugador #{d.whoStarts(23)}"
      end
      
      puts "Hay un #{prob_hangar_0}% de que salga el hangar 0, y un #{prob_hangar_1}% de que salga el 1"
      puts "Hay un #{prob_weapon_1}% de que salga la weapon 1, un #{prob_weapon_2}% de que salga 2 y un #{prob_weapon_3}% de que salga 3"
      puts "Hay un #{prob_shield_0}% de que salga el shield 0, y un #{prob_shield_1}% de que salga 1"
      puts "Hay un #{prob_true}% de que se mueve la spaceStation, y un #{prob_false}% de que no lo haga"
      puts "Hay un #{prob_space_station}% de que dispare primero spaceStation, y un #{prob_enemy}% de que lo haga enemyStarship"

    end
  end
  test= TestP1.new 
  test.main
end
