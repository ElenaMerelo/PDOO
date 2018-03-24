# Author: Elena Merlo


require 'test/unit'
require_relative '../lib/Dice'

module Deepspace
  class TC_Dice < Test::Unit::TestCase
    def setup
      @d= Dice.new
    end

    def test_probs
      #La posición 0 se corresponde con initWithNHangars, 1 con initWithNShields,
      # 2 con initWithNWeapons cuando sale 1, 3 con initWithNWeapons cuando sale 2,
      # 4 con firstShot y 5 con spaceStationMoves
      prob= [0, 0, 0, 0, 0, 0]

      for i in 0...99999
        if @d.initWithNHangars == 0
          prob[0] += 1
        end

        if @d.initWithNShields == 0
          prob[1] += 1
        end

        if @d.initWithNWeapons == 1
          prob[2] += 1
        elsif @d.initWithNWeapons == 2
          prob[3] += 1
        end

        if @d.firstShot == GameCharacter::SPACESTATION
            prob[4] += 1
        end

        if @d.spaceStationMoves(0.34) == true 
            prob[5] += 1
        end

        assert_operator 0, :<=, @d.whoStarts(34), "d.whoStarts(34) es < 0"
        assert_operator @d.whoStarts(34), :<=, 34, "d.whoStarts (34) es > 34"
      end

      # Para que se expresen como tantos por cientos
      for i in 0..5
        prob[i] /= 100000.0
      end

      assert_operator prob[0], :<, 0.26, "initWithNHangars sale 0 con una prob mayor que 0.25"
      assert_operator prob[1], :<, 0.26, "initWithNShields sale 0 con una prob mayor que 0.25"
      assert_operator prob[2], :<, 0.34, "initWithNWeapons sale 1 con una prob mayor que 0.33"
      assert_operator prob[3], :<, 0.34, "initWithNWeapons sale 2 con una prob que no esta entre 0.33 y 0.66"
      assert_operator prob[4], :<, 0.51, "firstShot sale GameCharacter::SPACESTATION con una prob mayor que 0.5"
      assert_operator prob[5], :<, 0.35, "spaceStationMoves con una prob > 0.34"
    end
  end #class
end #module