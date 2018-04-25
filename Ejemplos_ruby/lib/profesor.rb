require_relative "persona"

module Ejemplos_ruby
  class Profesor < Persona
    def initialize(d, n, a, e)
      super(d, n)
      @asignatura= a
      @experiencia= e
    end
    
    def datos_to_s
      "Mi nombre es #{nombre} y mi DNI: #{@dni}"
    end
    
    def hablar(*interlocutores)
      puts "Estimados "
      # super(interlocutores[1]) llama a hablar de la clase padre pasando como parámetro solo i[1]
      # super llama a hablar de la clase padre con todos los argumentos
      super()   #llama a hablar de la clase padre sin argumentos
    end
  end
end