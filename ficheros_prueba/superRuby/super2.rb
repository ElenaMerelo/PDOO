class Padre
  @@deClase="333"
  
  def hablaPadre()
    puts "Soy el padre"
  end
  
  def dime(*interlocutores)
    if (interlocutores!=nil)
      puts interlocutores.to_s
    end
    puts "bla,bla"
  end
  
  private
  def privadoPadre()
    puts "Privado en el padre"
  end
  
end

class Hija < Padre
 
#  alias_method :superHablaPadre, :hablaPadre
  alias :superHablaPadre :hablaPadre
  
  
  def hablaPadre()
    puts "Impersonando a mi padre:"
    super
  end

  def hablaHijo()   
    puts "Mi padre diria: "    
    #hablaPadre
    superHablaPadre
    puts "y yo soy el hijo"+@@deClase.to_s
  end    
  
  def dime(*interlocutores)
    puts "Estimados"
    super
    #super()
    #super(interlocutores[0])	
  end  
  
  def privadoPadre()
    puts "Llamo a un metodo privado de mi padre:"
    super
  end

end


p=Padre.new
h=Hija.new

p.hablaPadre
puts "---"
h.hablaPadre
puts "---"
h.hablaHijo
puts "---"
p.dime("ana","pepe","juan")
h.dime("ana","pepe","juan")
puts "---"
h.privadoPadre
