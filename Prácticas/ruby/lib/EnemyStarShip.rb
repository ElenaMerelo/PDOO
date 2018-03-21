# By Elena Merelo

require_relative "EnemyToUI"

module Deepspace
  class EnemyStarShip
    attr_reader :name, :ammoPower, :ShieldPower, :loot, :damage
    def initialize(n, a, s, l, d)
      @name= n
      @ammoPower= a
      @shieldPower= s
      @loot= l
      @damage= d
    end

    def self.newCopy(e)
      new(e.name, e.ammoPower, e.shieldPower, e.loot, e.damage)
    end

    def getUIversion
      EnemyToUI.new(self)
    end

    def fire
      self.ammoPower
    end

    def protection
      self.shieldPower
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