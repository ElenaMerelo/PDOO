# By Elena Merelo

require_relative 'EnemyToUI'
require_relative 'ShotResult'

module Deepspace
  class EnemyStarShip
    attr_reader :name, :ammoPower, :shieldPower, :loot, :damage
    
    def initialize(n, a, s, l, d)
      @name= n
      @ammoPower= a
      @shieldPower= s
      @loot= l
      @damage= d
    end

    def self.newCopy(e)
      EnemyStarShip.new(e.name, e.ammoPower, e.shieldPower, e.loot, e.damage)
    end

    def getUIversion
      EnemyToUI.new(self)
    end

    def fire
      @ammoPower
    end

    def protection
      @shieldPower
    end

    def receiveShot(shot)
      if @shieldPower < shot
        ShotResult::DONOTRESIST
      else
        ShotResult::RESIST
      end
    end
  end
end