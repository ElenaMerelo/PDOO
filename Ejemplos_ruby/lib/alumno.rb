module Ejemplos_ruby
  class Alumno < Persona
    def initialize(d, n, ca, cu)
      super(d, n)
      @carrera= ca
      @curso= cu
    end
  end
end