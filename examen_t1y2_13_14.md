#Ejercicio 1:
**Indicar razonadamente la salida que se obtendrá al procesar el código anterior.**
~~~Ruby
class A
  def initialize
    @atributo=1
  end

  attr_accessor :atributo
end

class B
  def initialize
    @atributo=2
  end

  attr_accessor :atributo
end

class C
  def initialize(a)
    @atributo=a
  end

  attr_accessor :atributo
end

class Test
  @@a=A.new
  @b=B.new

  def self.b
    @b
  end

  def initialize
    @c=C.new(99)
  end

  def to_s
    @@a.atributo.to_s+" "+
    self.class.b.atributo.to_s+" "+
    @c.atributo.to_s
  end

  def modifica
    @@a.atributo=11
    @c.atributo=33
  end

  def modifica2
    @@a.atributo=111
    @c.atributo=333
  end

  end

t1=Test.new
t2=Test.new
t3=t1

puts t1.to_s  # 1 2 99 al ser las correspondientes inicializaciones por defecto de a, b y c
puts t2.to_s  # 1 2 99 por lo mismo
puts t3.to_s  # 1 2 99

t1.modifica
puts t1.to_s  # 11 2 33, el método modifica cambia el atributo de clase a por 11 y el de instancia c por 33, b lo deja igual
puts t2.to_s  # 11 2 99, al ser a de clase también se cambia en t2
puts t3.to_s  # 11 2 33, es igual que t1 al ser una referencia a dicha clase

t2.modifica2
puts t1.to_s  # 111 2 33, modifica2 cambia el atributo de clase a, afecta a todas las claes
puts t2.to_s  # 111 2 333
puts t3.to_s  # 111 2 33
~~~

# Ejercicio 2
**Indicar razonadamente si la llamada al método “copiaAtributo” produce algún tipo de error. En
caso afirmativo, cual sería la solución para eliminar el error sin que eso implique dar acceso de
lectura total al atributo.**
~~~Ruby
class Test
  def initialize(a)
    @atributo=a
  end

  public
  def copiaAtributo(otro)
    @atributo=otro.atributo
  end

  def to_s
    @atributo.to_s
  end
end

t1=Test.new(333)
t2=Test.new(444)
puts t1.to_s  #Imprime 333
puts t2.to_s  #Imprime 444
t1.copiaAtributo(t2)  #Da error de que no se puede acceder a otro.atributo, al no haber creado el getter, no reconoce el método
puts t1.to_s  # No llega a esta parte al dar error anteriormente
puts t2.to_s
~~~
Una solución paa eliminar el error sin que eso implique dar acceso de lectura total al atributo sería crear el método como si fuera un constructor de copia:
