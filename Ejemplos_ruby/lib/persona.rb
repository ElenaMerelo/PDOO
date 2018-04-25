module Ejemplos_ruby
  class Persona
    @@n_personas= 0
    attr_accessor :dni, :nombre

    def initialize(d, n)
      @dni= d
      @nombre= n
      @@n_personas += 1
    end

    def self.get_n_personas
      @@n_personas
    end

    def hablar(*interlocutores)
      if interlocutores != nil
        puts interlocutores.to_s
      end
      "bla bla bla"
    end

    protected :nombre
    private :dni
  end
end