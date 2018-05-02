class A
	attr_accessor :a
	def initialize(a)
		puts "Creando A"
		@a=a
	end
end

class B<A
end

a1= A.new(77)
puts a1.a
#B.new
b1= B.new(88) #Aunque en B no hay initialize, implicitamente se llama al del padre que tiene parámetros
puts b1.a
###############################################################

class C
	attr_accessor :c
	def initialize(c)
		puts "Creando C"
		@c=c
	end
end

class D<C
	attr_accessor :d
	def initialize
		puts "Creando D"
		@d=88
	end
end

c1= C.new(99)
puts c1.c
d1=D.new #No se llama al initialize de C
puts d1.d
puts d1.inspect #Eso hace que las instancias de D no tengan el atributo @c

###############################################################
class E
	attr_accessor :e
	def initialize(e)
		puts "Creando E"
		@e=e
	end
end

class F<E
	attr_accessor :f
	def initialize
		puts "Creando F"
		@f=88
		super(99) #Ahora si llamamos al initialize de la clase padre
	end
end

e1= E.new(99)
puts e1.e
f1=F.new
puts f1.e
puts f1.f
puts f1.inspect

###############################################################
class G
	def initialize
		puts "Creando G"
		@g=66
	end
end

class H<G
	def initialize
		puts "Creando H"
		@h=88
	end
end

G.new
h=H.new #Tampoco se llama al initialize de G aunque no tenga parámetros
puts h.inspect #Eso hace que las instancias de H no tengan el atributo @g

#En Ruby tenemos la responsabilidad de llamar al método initialize de la clase padre si hemos creado uno en la clase hija
#Si no lo hacemos no se producen automáticamente errores que aborten la ejecución, pero pueden aparecer otros problemas
#Ejemplo:

class Padre
	def initialize
		@atributo=33
	end

	def metodo
		puts @atributo+1
	end
end

class Hija<Padre
	def initialize
	end
end

Padre.new.metodo
Hija.new
# Hija.new.metodo #Error al ejecutar

#Al crear la instancia de Hija, olvidamos llamar al initialize de la clase Padre y no se crea el atributo
#Al intentar ejecutar el metodo desde una instancia de la clase Hija se produce un error
