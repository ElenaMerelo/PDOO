=begin
Indicar razonadamente si la llamada al método “copiaAtributo” produce algún tipo de error. En
caso afirmativo, cual sería la solución para eliminar el error sin que eso implique dar acceso de
lectura total al atributo.
=end

class Ejer2
  def initialize(a)
    @atributo=a
  end
  
  public
  def copiaAtributo(otro)
    @atributo=otro
  end
 
  def to_s
    @atributo.to_s
  end
end

t1=Ejer2.new(333)
t2=Ejer2.new(444)
puts t1.to_s  #333
puts t2.to_s  #444
t1.copiaAtributo(t2.to_s)
puts t1.to_s  #444
puts t2.to_s  #444


