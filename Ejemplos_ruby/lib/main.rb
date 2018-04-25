require_relative "profesor"
require_relative "persona"

module Ejemplos_ruby
  class Prueba
    def self.main
      profe= Profesor.new("5432", "nolose", "pdoo", 4)
      # puts profe.nombre da error al ser nombre protected
      profe.nombre= "luis"
      puts Profesor.get_n_personas
      puts Persona.get_n_personas
      
      otro_profe= Profesor.new("trew", "gfds", "hgasd", 4)
      #Modificar un atributo de clase en la clase hija modifica la del padre también
      puts Profesor.get_n_personas
      puts Persona.get_n_personas
      # puts profe.dni error al ser dni private 
      profe.dni= "111111"
      puts profe.datos_to_s #llama a dni y nombre, pero desde la propia clase, por lo que no da error 
      puts profe.hablar("Ana", "Juan", "Pepe")
    end
  end
  Prueba.main
end
