# Author: Elena Merelo

require_relative "GameUniverseToUI"

module Deepspace
  class GameUniverse
    @@WIN= 10.freeze
    
    def initialize
      @currentStationIndex= 0
      @turns= 0
      @dice= Dice.new
      @gameState= GameStateController.new
      @currentStation= nil
      @spaceStations= Array.new
      @currentEnemy= nil
    end
    
    def combat(station, enemy)
      #próxima práctica
    end
    
    def combat
      #próxima práctica
    end
    
    def discardHangar
      if correct_game_state
        @currentStation.discardHangar
      end
    end
    
    def discardShieldBooster(i)
      if correct_game_state
        @currentStation.discardShieldBooster(i)
      end
    end
    
    def discardShieldBoosterInHangar(i)
      if correct_game_state
        @currentStation.discardShieldBoosterInHangar(i)
      end
    end
    
    def discardWeapon(i)
      if correct_game_state
        @currentStation.discardWeapon(i)
      end
    end
    
    def discardWeaponInHangar(i)
      if correct_game_state
        @currentStation.discardWeaponInHangar(i)
      end
    end
    
    def state 
      @gameState.state
    end
    
    def getUIversion
      GameUniverseToUI.new(self)
    end
    
    def haveAWinner
      @currentStation.nMedals == @@WIN
    end
    
    def init(names)
      if @gameState.state == GameState::CANNOTPLAY
        spaceStations= []
        dealer= CardDealer.instance 
        
        for i in names
          supplies= dealer.nextSuppliesPackage
          station= SpaceStation.new(i, supplies)
          l= Loot.new(0, @dice.initWithNHangars, @dice.initWithNWeapons, @dice.initWithNShields, 0)
          station.setLoot(l)
          
          spaceStations.add(station)
        end
        
        @currentStationIndex= @dice.whoStarts(names.length) 
        @currentStation= spaceStations.get(@currentStationIndex) 
        @currentEnemy= dealer.nextEnemy 
        
        @gameState.next(@turns, spaceStations.length)
      end
    end
    
    def mountShieldBooster(i)
      if correct_game_state
        @currentStation.mountShieldBooster(i)
      end
    end
    
    def mountWeapon(i)
      if correct_game_state
        @currentStation.mountWeapon(i)
      end
    end
    
    def nextTurn
      if @ga
    end
    
    private
    def correct_game_state
      @gameState.state == GameState::INIT or @gameState.state == GameState::AFTERCOMBAT
    end
    
  end #class
end #module