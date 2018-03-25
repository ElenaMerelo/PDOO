# Author: Elena Merelo

require 'test/unit'
require_relative '../lib/ShieldBooster'

module Deepspace
  class TC_ShieldBooster < Test::Unit::TestCase
    def setup
      @s= ShieldBooster.new("s", 43.32, 3)
      @s1= ShieldBooster.newCopy(@s)
      @s2= ShieldBooster.new("s", 43.32, 3)
      @s3= @s
    end

    def test_equals
      assert_equal "s", @s.name, "Error en name de s"
      assert_equal 43.32, @s.boost, "Error en boost de s"
      assert_equal 3, @s.uses, "Error en uses de s"

      assert_equal "s", @s1.name, "Error en name de s1"
      assert_equal 43.32, @s1.boost, "Error en boost de s1"
      assert_equal 3, @s1.uses, "Error en uses de s1"
        
      assert_equal "s", @s3.name, "Error en name de s3"
      assert_equal 43.32, @s3.boost, "Error en boost de s3"
      assert_equal 3, @s3.uses, "Error en uses de s3"
      end

      def test_instance_of
        assert_instance_of ShieldBooster, @s, "s no es una instancia de ShieldBooster"
        assert_instance_of ShieldBooster, @s1, "s1 no es una instancia de ShieldBooster"
        assert_instance_of ShieldBooster, @s2, "s2 no es una instancia de ShieldBooster"
        assert_instance_of ShieldBooster, @s3, "s3 no es una instancia de ShieldBooster"
      end

      def test_comparison
        assert_not_equal @s, @s1, "s == s1"
        assert_not_equal @s, @s2, "s == s2"
        assert_not_equal @s1, @s2, "s1 == s2"
        assert_equal @s, @s3, " s != s3"

        assert_not_same @s, @s1, "@s es el mismo objeto que @s1"
        assert_not_same @s, @s2, "@s es el mismo objeto que s2"
        assert_not_same @s1, @s2, "@s1 es el mismo objeto que s2"
        assert_same @s, @s3, "s no es el mismo objeto que s3"
      end
      
      def test_uses
        for i in 0..2
          assert_equal 43.32, @s.useIt, "Error en useIt"
        end
        
        assert_equal 1.0, @s.useIt, "Error en useIt"
        
        for i in 0..2
          assert_equal 43.32, @s1.useIt, "Error en useIt"
        end
        
        assert_equal 1.0, @s1.useIt, "Error en useIt"
        
        for i in 0..2
          assert_equal 43.32, @s2.useIt, "Error en useIt"
        end
        
        assert_equal 1.0, @s2.useIt, "Error en useIt"
       
      end
      
      def test_other_methods_definition
        assert_respond_to @s, :getUIversion, "Error en @s.getUIversion"
        assert_respond_to @s1, :getUIversion, "Error en @s.getUIversion"
        
        assert_respond_to @s, :to_s, "Error en to_s de @s"
        assert_respond_to @s1, :to_s, "Error en to_s de @s1"
      end
  end
end