# Author: Elena Merelo

require_relative "GameUniverseToUI"

module Deepspace
  class GameUniverse
    @@WIN= 10.freeze
    
    def initialize
      @currentStationIndex= 0
      @turns= 0
      @dice= Dice.new
      @currentStation= SpaceStation.new 
      @spaceStations= Array.new(1)
      @currentEnemy= EnemyStarShip.new
      @gameState= GameStateController.new
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
    
    attr_reader :gameState
    
    def getUIversion
      GameUniverseToUI.new(self)
    end
    
    def haveAWinner
      @currentStation.nMedals == @@WIN
    end
    
    def init(names)
      #próxima práctica
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
      #próxima práctica
    end
    
    private
    def correct_game_state
      @gameState.state == GameState::INIT or @gameState.state == GameState::AFTERCOMBAT
    end
    
  end #class
end #module
