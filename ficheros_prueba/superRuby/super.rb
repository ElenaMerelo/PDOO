class Padre
  @@deClase=333

  def hablaPadre()
    puts "Soy el padre"
  end

  def dime(*interlocutores)
    if (interlocutores!=nil)
      puts interlocutores.to_s
    end
    puts "bla,bla"
  end

  def self.deClase #si no ponemos self da error
    @@deClase
  end

  def habla
    "Yo soy tu padre "
  end

  def otro_met
    puts "Desde el padre "
    habla
  end

  private
  def privadoPadre()
    puts "Privado en el padre"
  end

end

class Hija < Padre

  @@deClase= 0
#  alias_method :superHablaPadre, :hablaPadre
#  alias :superHablaPadre :hablaPadre


  def hablaPadre()
    puts "Impersonando a mi padre:"
    super
  end

  def self.deClase
    @@deClase += 1
  end

  def hablaHijo()
    puts "Mi padre diria: "
    hablaPadre
    #superHablaPadre
    puts "y yo soy el hijo "+@@deClase.to_s
  end

  def habla
    puts "Yo soy la hija"
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

  def met_propio
    otro_met
  end

end


p=Padre.new
h=Hija.new

p.hablaPadre
puts Padre.deClase #si lo llamamos con p.deClase da error
puts "---"
h.hablaPadre
puts Hija.deClase
puts Padre.deClase
puts "---"
h.hablaHijo
puts "---"
p.dime("ana","pepe","juan")
h.dime("ana","pepe","juan")
puts "---"
h.privadoPadre

puts "-------------"
h.met_propio
