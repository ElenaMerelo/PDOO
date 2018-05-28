
require_relative 'SpecificDamage'
require_relative 'DamageExamen'
require_relative 'SpaceCityExamen'
require_relative 'NumericDamage'
require_relative 'CardDealer'
require_relative 'WeaponType'
require_relative 'Weapon'

module Deepspace
  class Examen
    def self.principal
      #Ejercicio 1
      dealer= CardDealer.instance
      l= Weapon.new("l", WeaponType::LASER, 3)
      m= Weapon.new("m", WeaponType::MISSILE, 2)
      p= Weapon.new("p", WeaponType::PLASMA, 1)
      w = [l, l, l, m, m, p]
      d= SpecificDamage.new([WeaponType::LASER, WeaponType::PLASMA, WeaponType::LASER, WeaponType::MISSILE], 4)
      puts d.to_s
      
      
      adjusted= d.adjust(w, [dealer.nextShieldBooster])
      puts adjusted.to_s
      
      #Ejercicio 2
      td= DamageExamen.new([WeaponType::LASER, WeaponType::PLASMA, WeaponType::LASER, WeaponType::MISSILE], 4)
      puts td.to_s
      adjusted_test= td.adjust(w, [dealer.nextShieldBooster])
      puts adjusted_test.to_s
      
      #Ejercicio 3
      dealer= CardDealer.instance
      d1= NumericDamage.new(2,1)
      s1= SpaceStation.new("s1", 23.23, 2.3, 1.2, 4.5, dealer.nextHangar, dealer.nextWeapon, dealer.nextShieldBooster, d1)
      ts= SpaceCityExamen.new(s1, [s1, s1, s1])
      
      for i in 0..4
        ts.fire
        puts ts.to_s
      end
      
    end
    test= Examen.principal
  end
end