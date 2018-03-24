# Author: Elena Merelo

require 'test/unit'
require_relative '../lib/ShieldBooster'

module Deepspace
  class TC_ShieldBooster < Test::Unit::TestCase
    def setup
      @s= ShieldBooster.new("s", 43.32, 3)
      @s1= ShieldBooster.newCopy(@s)
    end

    def test_equals
        assert_equal "s", @s.name, "Error en name"
        assert_equal 43.32, @s.boost, "Error en boost"
        assert_equal 3, @s.uses, "Error en uses"
      end

      def test_instance_of
        s2= @s
        s3= ShieldBooster.new("s", 43.32, 3)
        assert_instance_of ShieldBooster, @s, "s no es una instancia de ShieldBooster"
        assert_instance_of ShieldBooster, @s1, "s1 no es una instancia de ShieldBooster"
        assert_instance_of ShieldBooster, s2, "s2 no es una instancia de ShieldBooster"
        assert_instance_of ShieldBooster, s3, "s3 no es una instancia de ShieldBooster"
      end

      def test_comparison
        s2= @s
        s3= ShieldBooster.new("s", 43.32, 3)
        assert_equal @s, @s1, "s != s1"
        assert_equal @s, s2, "s != s2"
        assert_equal @s1, s2, "s1 != s2"
        assert_equal @s, s3, "s != s3"

        assert_same @s, @s1, "@s no es el mismo objeto que @s1"
        assert_same @s, s2, "@s no es el mismo objeto que s2"
        assert_same @s1, s2, "@s1 no es el mismo objeto que s2"
        assert_same @s, s3, "@s no es el mismo objeto que s3"

      end
  end
end