# Author: Elena Merelo
# Para mejor funcionamiento comentar línea 27 de CardDeck.rb

require_relative "Dice"
require_relative "SpecificDamage"
require_relative "CardDealer"


module Test_P4
  class Test_p4
    def self.main
      dice=Deepspace::Dice.new
      puts dice.extraEfficiency
      
      #------------------------------SpecificDamage------------------------------
      weapon_types= [Deepspace::WeaponType::PLASMA, Deepspace::WeaponType::LASER, Deepspace::WeaponType::MISSILE]
      d1= Deepspace::SpecificDamage.new(weapon_types, 5)
      
      #newCopy
      d2= Deepspace::SpecificDamage.newCopy(d1)
      
      puts d1
      puts d2
      
      dealer= Deepspace::CardDealer.instance
      w= dealer.nextWeapon
      d2.discardWeapon(w)
      
      #Comprobamos así que los cambios realizados a d2 no afectan a d1
      puts d1 
      puts d2
      
      puts d1.getUIversion
      
    end
  end
  Test_p4.main
end
