class Elem
	def metodo2
		puts "Elem2"
	end
end

class Padre
	def metodo
		puts "Padre"
		#La siguiente línea es importante para que funcione la siguiente comentada
		return Elem.new
	end

	def metodo2
		puts "Padre2"
	end
end

class Hijo<Padre
	alias_method :parent_metodo2, :metodo2
	#Equivalente a alias :parent_metodo2 :metodo2
	def metodo
		puts "Hijo"
		###Un ejemplo en Ruby usando APARENTE sintaxis Java.
		#super.metodo2
		#Solución:
		parent_metodo2
		#o
		Padre.instance_method(:metodo2).bind(self).call
	end

	def metodo2
		puts "Hijo2"
	end

end

Hijo.new.metodo
