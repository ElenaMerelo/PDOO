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
      s2= s1.newCopy
      
      puts "s1: ammoPower #{s1.ammoPower}, fuelUnits #{s1.fuelUnits}, shieldPower #{s1.shieldPower}"
      puts "s2: ammoPower #{s2.ammoPower}, fuelUnits #{s2.fuelUnits}, shieldPower #{s2.shieldPower}"
      
      #ShieldBooster 
      sh1= ShieldBooster.new("ghostbooster", 654.35, 3)
      sh2= sh1.newCopy
      
      puts "sh1: name #{sh1.name}, boost #{sh1.boost}, uses #{sh1.uses}"
      puts "sh2: name #{sh2.name}, boost #{sh2.boost}, uses #{sh2.uses}"
      
      puts "useIt: "
      for i in 0..5 do
        puts sh1
        puts "#{sh1.useIt}"
      end
      
      #Weapon 
      w1= Weapon.new("laser de la vida", WeaponType::LASER, 3) 
      w2= w1.newCopy(w1)
      puts "Name #{w1.name}, type #{w1.type.power}, uses #{w1.uses}"
      puts "Name #{w2.name}, type #{w2.type.power}, uses #{w2.uses}"
      
      w3= Weapon.new("mega misil", WeaponType::MISSILE, 4) 
      w4= w3.newCopy(w3)
      puts w3
      puts w4
      
      w5= Weapon.new("plasmatron 3000", WeaponType::PLASMA, 2) 
      w6= w5.newCopy(w5)
      puts w5
      puts w6
      
      for i in 0..5
        puts "useIt iteración #{i}"
        puts w1
        puts "#{w1.useIt}"
        
        puts w3
        puts "#{w3.useIt}"
        
        puts w5
        puts "#{w5.useIt}"
      end
    end
  end
  test= TestP1.new 
  test.main
end
