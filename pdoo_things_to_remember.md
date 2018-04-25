# Paquetes de java
+ Permiten agrupar clases
+ No permiten agrupar otros paquetes
+ `import` permite acceder de forma directa a clases de otro paquete:

~~~java
package animales;

class leon { ... }

class gallina { ... }

//En otro fichero
package animales.reptiles;

class serpiente { ... }

//En otro
import animales.gallina;

package granja;

class establo { ... }
~~~

# Módulos de ruby
+ Permiten agrupar clases, constantes, trozos de código y métodos, los cuales pueden ejecutarse por otra clase o módulo o ejecutarse directamente
+ Pueden agrupar a otros módulos
~~~ruby
module animales
  class leon
    ...
  end

  class gallina
    ...
  end

  def comer
    ...
  end

  PLANETA= tierra

  module reptiles
    class serpiente
      ...
    end

  leon1= leon.new
  var= leon1.met(2) + 8
end
~~~

# Uso de módulos de Ruby:
• `require`: para indicar la ruta
del fichero donde está el
código que necesitamos
cargar.
• `require_relative`: si el
fichero a cargar está en la
carpeta actual.
• `require*` solo si se utiliza el
nombre de una clase de
otro fichero.
• `include` permite importar un
módulo dentro de una
clase.

~~~Ruby
module cronometro
  def empezar...end
  def parar ... end
end
------------------------------------
require_relative “crono”
class Reloj
  include cronometro
  def mostrarHora...end
end

rel=Reloj.new
rel.mostrarHora
rel.empezar
~~~

#Especificadores de acceso java
| Class | Package | Subclass | Subclass | World
           |       |         |(same pkg)|(diff pkg)|
————————————+———————+—————————+——————————+——————————+————————
public      |   +   |    +    |    +     |     +    |   +     
————————————+———————+—————————+——————————+——————————+————————
protected   |   +   |    +    |    +     |     +    |         
————————————+———————+—————————+——————————+——————————+————————
no modifier |   +   |    +    |    +     |          |    
————————————+———————+—————————+——————————+——————————+————————
private     |   +   |         |          |          |    

+ : accessible
blank : not accessible

# Especificadores de acceso ruby
La visibilidad de las atributos de instancia, de clase y de instancia de la
clase es privada en Ruby, mientas que la de las constantes es pública. No pueden cambiarse.
• Por defecto los métodos son públicos.
• Cuando un método es privado solo puede ser invocado sin un receptor
explícito (tampoco self).

In Ruby, the inheritance hierarchy or the package/module don't really enter into the equation, it is rather all about which object is the receiver of a particular method call. When a method is declared private in Ruby, it means this method can never be called with an explicit receiver. Any time we're able to call a private method with an implicit receiver it will always succeed. This means **we can call a private method from within a class it is declared in as well as all subclasses of this class** e.g.
~~~ruby
class A
  def main_method
    method1
  end

  private
  def method1
    puts "hello from #{self.class}"
  end
end

class B < A
  def main_method
    method1
  end
end

A.new.main_method
B.new.main_method
~~~

~~~shell
alan@alan-ubuntu-vm:~/tmp$ ruby a.rb
hello from A
hello from B
~~~

However, as soon as we try to use an explicit receiver, even if the receiver is "self", the method call will fail e.g.

~~~ruby
class C < A
  def main_method
    self.method1
  end
end

C.new.main_method
~~~

~~~shell
alan@alan-ubuntu-vm:~/tmp$ ruby a.rb
a.rb:36:in main_method': private method `method1' called for #<C:0x7f67025a0648> (NoMethodError)
    from a.rb:40
~~~

Protected methods are also a little different. You can always call a protected method with an implicit receiver, just like private, but in addition you can call a protected method with an explicit receiver as long as this receiver is self or an object of the same class as self. Let's modify our example above and make the method protected:

~~~ruby
class A
  def main_method
    method1
  end

  protected
  def method1
    puts "hello from #{self.class}"
  end
end

class B < A
  def main_method
    method1
  end
end

class C < A
  def main_method
    self.method1
  end
end
~~~

~~~shell
alan@alan-ubuntu-vm:~/tmp$ ruby a.rb
hello from A
hello from B
hello from C
~~~

Now, the call with the implicit receiver in class B succeeds (as before) but the call with the explicit receiver in class C also succeeds (unlike when method1 was private). Furthermore, doing the following is also fine:

~~~ruby
class D < A
  def main_method
    B.new.method1
  end
end

D.new.main_method
~~~

~~~shell
alan@alan-ubuntu-vm:~/tmp$ ruby a.rb
hello from B
~~~


Everything works because B.new is the same type of object as self and so the call to method1 succeeds. If however we make class D NOT inherit from A, we get the following:

~~~ruby
class D
  def main_method
    B.new.method1
  end
end

D.new.main_method
~~~

~~~shell
alan@alan-ubuntu-vm:~/tmp$ ruby a.rb
a.rb:39:in main_method': protected method `method1' called for #<B:0x7fe81d00efa8> (NoMethodError)
    from a.rb:46
~~~

In this case B.new is no longer the same type of object as self and so trying to call a protected method with B.new as the receiver – fails. So, I guess the inheritance hierarchy does actually play a role when it comes to access control in Ruby, it's just not as big a role as it is in a language like Java.

Public methods are – of course – accessible with any kind of explicit or implicit receiver from anywhere (as the name implies).
En definitiva:
>
+ Private -- desde el propio objeto
+ Protected -- desde el propio objeto y la propia clase
+ Public -- desde el propio objeto, la propia clase y otra clase

# Comparando objetos en Ruby

equal? e == se usan para comparar, dan true si se referencia al mismo objeto. La diferencia es que equal? mira si los dos objetos tienen el mismo object id, si son el mismo objeto, mientras que == se suele usar para ver si dos objetos tienen el mismo valor. eql? se usa para ver si dos objetos tienen el mismo valor y tipo.

# Diagrama de clases UML
> Asociaciones especiales:

+ Agregación (rombito vacío): Asociación cuyo nombre es
“parte de”, en la que una de las clases representa el
“todo” y la otra la/s “parte/s”.

+ Composición ( rombito relleno ): Se trata de una agregación
fuerte, en que la/s parte/s no tiene/n sentido sin el
todo.

+ Asociación -- marcada con línea contínua
+ Dependencia -- línea discontínua
+ Restricción de navegabilidad si la flechita pequeña va al final de la línea, si pone trabaja para > en mitad la navegabilidad es en ambos sentidos
+ Si no se indica nada la multiplicidad por defecto es 1
+ Atributo de referencia son aquellos que no aparecen explícitamente en el diagrama de la clase, en su cajita, sino que se obtienen fijándonos en las relaciones de asociación con otras clases, por ejemplo si tenemos una clase barrio, un atributo de referencia será `private ArrayList<Ciudadano> ciudadanos`, si viene una flechita que va de Barrio a Ciudadano y pone la cardinalidad 1..* .


# delete_at(position) en ruby

Deletes the element at the specified index, returning that element, or nil if the index is out of range.

~~~ruby
a = %w( ant bat cat dog )
a.delete_at(2)    #=> "cat"
a                 #=> ["ant", "bat", "dog"]
a.delete_at(99)   #=> nil
~~~


#Differences between interfaces and abstract classes java
+ `abstract` keyword is used to create an abstract class and it can be used with methods also whereas `interface` keyword is used to create interface and it can’t be used with methods.

+ Subclasses use `extends` keyword to extend an abstract class and **they need to provide implementation of all the declared methods in the abstract class unless the subclass is also an abstract class** whereas subclasses use `implements` keyword to implement interfaces and **should provide implementation for all the methods declared in the interface**.

+ Abstract classes can have methods with implementation whereas interface provides absolute abstraction and can’t have any method implementations.

+ Abstract classes can have constructors but interfaces can’t have constructors.

+ Abstract classes have all the features of a normal java class except that we can’t instantiate it. We can use abstract keyword to make a class abstract but **interfaces** are a completely different type and **can only have public static final constants and method declarations**.

+ Abstract classes methods can have access modifiers as public, private, protected, static but interface methods are implicitly public and abstract, we can’t use any other access modifiers with interface methods.

+ A subclass can extend only one abstract class but it can implement multiple interfaces.

+ Abstract classes can extend other classes and implement interfaces but interfaces can only extend other interfaces.

+ We can run an abstract class if it has main() method but we can’t run an interface because they can’t have main method implementation.
