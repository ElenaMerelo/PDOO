require_relative "GameUniverse"
require_relative "SpaceStation"
require_relative "Loot"
require_relative "SuppliesPackage"
require_relative "Dice"
require_relative "ShieldBooster"
require_relative "CardDealer"

module TestP3
    class Examen
      def principal
        #Ejercicio 2
        d= Deepspace::Dice.new
        prob=  [0, 0, 0]
        for i in 0..1000
          if d.initWithNWeapons == 1
            prob[0] += 1
          elsif d.initWithNWeapons == 2
            prob[1] += 1
          else
            prob[2] += 1
          end
        end
        
        puts "Se ha recibido 1 arma  #{prob[0]} veces, 2 armas #{prob[1]} veces y 3 armas #{prob[2]} veces."
        
        #Ejercicio 3
        #a
        damage= Deepspace::Damage.newSpecificWeapons([Deepspace::WeaponType::PLASMA, Deepspace::WeaponType::MISSILE, Deepspace::WeaponType::LASER, Deepspace::WeaponType::PLASMA], 10)
        l1= Deepspace::Loot.new(1,1,2,1,1)
        e= Deepspace::EnemyStarShip.new("enemy", 500000, 500000, l1, damage)
        
        #b
        dealer= Deepspace::CardDealer.instance
        supplies= dealer.nextSuppliesPackage
        station= Deepspace::SpaceStation.new("station", supplies)
        l2= Deepspace::Loot.new(0, 3, 2, 1, 0)
        station.setLoot(l2)
        
        o_station= Deepspace::SpaceStationToUI.new(station)
        
        puts o_station
        
        for i in 0..l2.nWeapons
          station.mountWeapon(0)
        end
        
        for i in 0..l2.nShields
          station.mountShieldBooster(0) 
        end
        
        o_station= Deepspace::SpaceStationToUI.new(station)
        puts o_station
        
        #c
        uni= Deepspace::GameUniverse.new
        uni.combatGo(station, e)
        
        if(station.validState)
          puts "La estacion esta en un estado valido"
        else
          puts "la estacion no estaen un estado valido"
        end
        
        o_station= Deepspace::SpaceStationToUI.new(station)
        puts o_station
      end
      
      test= Examen.new
      test.principal
    end
end
