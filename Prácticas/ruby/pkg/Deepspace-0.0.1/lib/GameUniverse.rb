# Author: Elena Merelo

require_relative 'Dice'
require_relative 'GameStateController'
require_relative 'GameUniverseToUI'
require_relative 'CardDealer'
require_relative 'SpaceStation'
require_relative 'CombatResult'
require_relative 'GameCharacter'
require_relative 'BetaPowerEfficientSpaceStation'
require_relative 'PowerEfficientSpaceStation'
require_relative 'SpaceCity'

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
      @haveSpaceCity= false
    end
    
    def combatGo(station, enemy)
      if(@dice.firstShot == GameCharacter::ENEMYSTARSHIP)
        result= station.receiveShot(enemy.fire)
        
        if result == ShotResult::RESIST
          result= enemy.receiveShot(station.fire)
          enemyWins= result == ShotResult::RESIST
        else
          enemyWins= true
        end
      else
        result= enemy.receiveShot(station.fire)
        enemyWins= result == ShotResult::RESIST
      end
      
      if enemyWins
        moves= @dice.spaceStationMoves(station.getSpeed)
        
        if !moves
          station.setPendingDamage(enemy.damage)
          combatResult= CombatResult::ENEMYWINS 
        else
          station.move 
          combatResult= CombatResult::STATIONESCAPES
        end
      else
        t= station.setLoot(enemy.loot)
        combatResult= CombatResult::STATIONWINSANDCONVERTS
        if t == Transformation::GETEFFICIENT
          makeStationEfficient
        elsif t == Transformation::SPACECITY
          createSpaceCity
        else
          combatResult= CombatResult::STATIONWINS
        end
        
      end
      
      @gameState.next(@turns, @spaceStations.length)
      combatResult
    end
    
    def combat
      state= @gameState.state
      if state == GameState::BEFORECOMBAT or state == GameState::INIT
        combatGo(@currentStation, @currentEnemy)
      else 
        CombatResult::NOCOMBAT
      end
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
      GameUniverseToUI.new(@currentStation, @currentEnemy)
    end
    
    def haveAWinner
      @currentStation.nMedals >= @@WIN
    end
    
    def init(names)
      if @gameState.state == GameState::CANNOTPLAY
        dealer= CardDealer.instance 
        
        for i in names
          supplies= dealer.nextSuppliesPackage
          station= SpaceStation.new(i, supplies)
          l= Loot.new(0, @dice.initWithNWeapons, @dice.initWithNShields, @dice.initWithNHangars, 0)
          station.setLoot(l)
          
          @spaceStations << station
        end
        
        @currentStationIndex= @dice.whoStarts(names.length) 
        @currentStation= @spaceStations.at(@currentStationIndex) 
        @currentEnemy= dealer.nextEnemy 
        
        @gameState.next(@turns, @spaceStations.length)
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
      if @gameState.state == GameState::AFTERCOMBAT
        if @currentStation.validState
          @currentStationIndex = (@currentStationIndex + 1)% @spaceStations.length
          @turns += 1
          
          @currentStation= @spaceStations.at(@currentStationIndex)
          @currentStation.cleanUpMountedItems
          
          dealer= CardDealer.instance
          @currentEnemy= dealer.nextEnemy
          
          @gameState.next(@turns, @spaceStations.length)
          
          return true
        end
        return false
      end
      return false
    end
    
    private
    def correct_game_state
      @gameState.state == GameState::INIT or @gameState.state == GameState::AFTERCOMBAT
    end
    
    def makeStationEfficient
      if @dice.extraEfficiency
        @currentStation= BetaPowerEfficientSpaceStation.new(@currentStation)
      else
        @currentStation= PowerEfficientSpaceStation.new(@currentStation)
      end
      
      @spaceStations[@currentStationIndex] = @currentStation
    end
    
    def createSpaceCity 
      if !@haveSpaceCity
        aux= Array.new(@spaceStations)
        aux.delete_at(@currentStationIndex)
        @currentStation= SpaceCity.new(@currentStation, aux)
        @spaceStations[@currentStationIndex]= @currentStation
        @haveSpaceCity= true
      end
    end
    
  end #class
end #module