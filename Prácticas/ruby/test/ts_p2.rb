# Author: Elena Merelo

require 'test/unit'
require_relative 'tc_hangar'

module Deepspace
  class TS_p2
    def self.suite
      suite= Test::Unit::TestSuite.new
      
      suite << TC_Hangar.suite
      
      return suite
    end
  end #class
end #module


