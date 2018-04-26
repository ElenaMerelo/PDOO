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

+ Lo más importante, **si en una clase abstracta declaramos varios métodos abstractos, las clases que extienden dicha clase pueden implementarlos o no, mientras que si una clase "implementa" una interfaz ha de proveer una declaración de todos los métodos que en ella están.**


> Interesting question in StackOverflow:

A curious thing happens in Java when you use an abstract class to implement an interface: some of the interface's methods can be completely missing (i.e. neither an abstract declaration or an actual implementation is present), but the compiler does not complain.

For example, given the interface:

~~~java
public interface IAnything {
  void m1();
  void m2();
  void m3();
}
~~~

the following abstract class gets merrily compiled without a warning or an error:

~~~java
public abstract class AbstractThing implements IAnything {
  public void m1() {}
  public void m3() {}
}
~~~

Can you explain why?

Several answers:

That's fine. To understand the above, you have to understand the nature of abstract classes first. They are similar to interfaces in that respect. This is what Oracle say about this here.

    Abstract classes are similar to interfaces. You cannot instantiate them, and they may contain a mix of methods declared with or without an implementation.

So you have to think about what happens when an interface extends another interface. For example ...

~~~java
//Filename: Sports.java
public interface Sports
{
   public void setHomeTeam(String name);
   public void setVisitingTeam(String name);
}

//Filename: Football.java
public interface Football extends Sports
{
   public void homeTeamScored(int points);
   public void visitingTeamScored(int points);
   public void endOfQuarter(int quarter);
}
~~~

... as you can see, this also compiles perfectly fine. Simply because, just like an abstract class, an interface can NOT be instantiated. So, it is not required to explicitly mention the methods from its "parent". However, ALL the parent method signatures DO implicitly become a part of the extending interface or implementing abstract class. So, once a proper class (one that can be instantiated) extends the above, it WILL be required to ensure that every single abstract method is implemented.


**That's because if a class is abstract, then by definition you are required to create subclasses of it to instantiate. The subclasses will be required (by the compiler) to implement any interface methods that the abstract class left out.**

Following your example code, try making a subclass of AbstractThing without implementing the m2 method and see what errors the compiler gives you. It will force you to implement this method.

## Herencia y polimorfismo

+ Por defecto en una interfaz los métodos son públicos

+ Si una clase que hereda de otra e implementa una interfaz y a su vez tiene clases hijas, las clases hijas no hace falta que rellenen los métodos de la interfaz, con que lo haga la clase en la que se pone el implements va, y desde las hijas se pueden llamar a dichos métodos, devolviéndose lo de la padre.

+ Sea por ejemplo la clase persona, que tiene una clase hija llamada alumno tal que cada una implementa el método hablar. Al ejecutar:

~~~Java
persona p4= new alumno("5432", "5432", "e", 1);
System.out.println(p4.hablar());
~~~~

Se llama al hablar del hijo, aunque su tipo dinámico sea persona.

Si ponemos:

~~~Java
persona p4= new persona("5432", "5432");
System.out.println(((alumno)p4).hablar());
~~~
Da el siguiente error:
~~~shell
Exception in thread "main" java.lang.ClassCastException: probando.persona cannot be cast to probando.alumno
	at probando.main.main(main.java:57)
/home/elena/.cache/netbeans/8.2/executor-snippets/run.xml:53: Java returned: 1
~~~

Otra opción sería:

~~~Java
persona p4= new alumno("5432", "5432", "e", 1);
System.out.println(((persona)p4).hablar());
~~~

Que llama al hablar de alumno.

Si asignamos varios tipos dinámicos a la misma variable se queda con el último:

~~~Java
persona p4= new alumno("5432", "5432", "e", 1);
p4= new persona("542", "432");
System.out.println(p4.hablar());
~~~

Llama al hablar de persona.

Teniendo en cuenta que buen_estudiante hereda de alumno:

~~~java
persona p4= new alumno("5432", "5432", "e", 1);
persona p5= (buen_estudiante) p4;
System.out.println(p4.hablar());
System.out.println(p5.hablar());
~~~

Da el error `Exception in thread "main" java.lang.ClassCastException: probando.alumno cannot be cast to probando.buen_estudiante`

Juntando los ejemplos anteriores, lo siguiente ejecutaría hablar desde alumno y hablar desde estudiante:

~~~java
persona p4= new alumno("5432", "5432", "e", 1);
persona p5= new buen_estudiante("543", "543", "t3", 1, 0.0);
System.out.println(((persona)p4).hablar());
System.out.println(((alumno)p5).hablar());
~~~

Aunque no funcionaría:

~~~Java
persona p4= new alumno("5432", "5432", "e", 1);
persona p5= new buen_estudiante("543", "543", "t3", 1, 0.0);
System.out.println(((buen_estudiante)p4).hablar());
System.out.println(((alumno)p5).hablar());
~~~

En definitiva: si declaramos una variable y como tipo estático ponemos una clase hija y de tipo dinámico su padre, da error al interpretarlo, antes incluso de compilar. Si una variable la creamos varias veces con distintos tipos dinámicos, se queda con la última llamada al constructor. A la hora de ejecutar, desde una clase hija se pueden hacer castings a clases que se encuentran por encima, no da errores de ningún tipo, pero al ejecutar ejecutará desde la clase de tipo dinámico. Dará error si hacemos casting desde una clase padre a una inferior.

Al crear objetos mediante castings, dará error si intentamos hacer un casting de una clase padre a una hija, funcionará bien si hacemos casting de clase hija a clase padre, y ejecutará los métodos desde la clase que sea del tipo dinámico. Así, en el ejemplo de abajo no daría error al hacer casting y se llama a hablar desde alumno cuando se ejecuta `p6.hablar()`:

~~~java
persona p4= new alumno("5432", "5432", "e", 1);
persona p5= new buen_estudiante("543", "543", "t3", 1, 0.0);
System.out.println(((persona)p4).hablar());
System.out.println(((alumno)p5).hablar());

persona p6= (persona) p4;
System.out.println(p6.hablar());
~~~

Por otro lado, si hacemos casting alumno a buen_estudiante da error (`Exception in thread "main" java.lang.ClassCastException: probando.alumno cannot be cast to probando.buen_estudiante`):

~~~java
persona p4= new alumno("5432", "5432", "e", 1);
persona p5= new buen_estudiante("543", "543", "t3", 1, 0.0);
System.out.println(((persona)p4).hablar());
System.out.println(((alumno)p5).hablar());

persona p6= (buen_estudiante) p4;
System.out.println(p6.hablar());
~~~

Igualmente un casting de una clase hermana a otra da error, los castings solo compilan si son de clase hija a alguna superior.

#### Otros casos

~~~java
// Animal > reptil y animal > ave, reptil y ave son clases hermanas
Animal animal= new Animal();
Reptil reptil = new Reptil();
animal = reptil;  //ok
reptil = animal; // da error en compilación al estar asignando a una clase hija su padre
-------------------------------------------------------------------------
Animal animal= new Animal();
Reptil reptil = new Reptil();
reptil = (Reptil) animal; //error en ejecución, se ejecutarán los métodos como si fuera reptil
-------------------------------------------------------------------------
Animal animal= new Reptil();
Reptil reptil = new Reptil();
reptil = animal; //Da error al interpretarlo, al ser el tipo estático de reptil hijo del de animal.
~~~

**No se puede convertir de una clase hija a una clase padre a la hora de crear objetos**. Veámoslo en nuestro ejemplo:

~~~java
persona p6= new persona("$325342", "gef");
alumno a= new alumno("gtrew", "5432", "5432",1);

p6= a;
a= p6;
System.out.println(p6.hablar());
~~~

Al ser alumno heredero de persona `a= p6` da error, dice que no puede convertir uno en otro. Al hacer `p6= a` el último tipo dinámico asignado a p6 es alumno, luego `p6.hablar()` se ejecutará desde alumno.

El siguiente ejemplo ilustra la segunda parte de lo anterior:
~~~java
persona p6= new persona("5432", "persona");
alumno a= new alumno("6543", "alumno", "5432",1);

a= (alumno) p6;
System.out.println(a.get_nombre());
~~~

No da error de compilación pero al ejecutar lo último devuelve alumno, que es el nombre de a, cuando debería devolver persona, porque se está haciendo el casting de una clase padre a una hija. Si se hace desde una hija a una padre no da error de ejecución:

~~~java
p3= new buen_estudiante("34", "buen estudiante", "54", 1, 4.5);
persona p6= new persona("5432", "persona");
alumno a= new alumno("6543", "alumno", "5432",1);

a= (alumno) p3;
System.out.println(a.get_nombre());
~~~

Imprime buen estudiante.





#
