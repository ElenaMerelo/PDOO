# Paquetes de java
+ Permiten agrupar clases
+ No permiten agrupar otros paquetes, aunque parezca que sí
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
+ Permiten agrupar clases, constantes, trozos de código y métodos, los cuales pueden ejecutarse por otra clase o módulo o directamente
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
+ `require`: para indicar la ruta del fichero donde está el código que necesitamos cargar.
+ `require_relative`: si el fichero a cargar está en la carpeta actual.
+ `require*` solo si se utiliza el nombre de una clase de otro fichero.
+ `include` permite importar un módulo dentro de una clase.

~~~Ruby
module cronometro
  def empezar...end
  def parar ... end
end
------------------------------------
require_relative 'crono'
class Reloj
  include cronometro
  def mostrarHora...end
end

rel=Reloj.new
rel.mostrarHora
rel.empezar
~~~

# Especificadores de acceso ruby
La visibilidad de los atributos de instancia, de clase y de instancia de la clase es privada en Ruby, mientras que la de las constantes es pública. No pueden cambiarse.

Por defecto los métodos son públicos. Cuando un método es privado solo puede ser invocado sin un receptor explícito (tampoco self).

In Ruby, the inheritance hierarchy or the package/module don't really enter into the equation, it is rather all about which object is the receiver of a particular method call. **When a method is declared private in Ruby, it means this method can never be called with an explicit receiver**. Any time we're able to call a private method with an implicit receiver it will always succeed. This means **we can call a private method from within a class it is declared in as well as all subclasses of this class.** For instance:

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

However, as soon as we try to use an explicit receiver, even if the receiver is "self", the method call will fail:

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


# Differences between interfaces and abstract classes java
+ `abstract` keyword is used to create an abstract class and it can be used with methods also whereas `interface` keyword is used to create interface and it can’t be used with methods.

+ Subclasses use `extends` keyword to extend an abstract class and **they need to provide implementation of all the declared methods in the abstract class unless the subclass is also an abstract class** whereas subclasses use `implements` keyword to implement interfaces and **should provide implementation for all the methods declared in the interface**.

+ Abstract classes can have methods with implementation whereas interface provides absolute abstraction and can’t have any method implementations.

+ Abstract classes can have constructors but interfaces can’t have constructors.

+ Abstract classes have all the features of a normal java class except that we can’t instantiate it. We can use abstract keyword to make a class abstract but **interfaces** are a completely different type and **can only have public static final constants and method declarations**.

+ Abstract classes methods can have access modifiers as public, private, protected, static but interface methods are implicitly public and abstract, we can’t use any other access modifiers with interface methods.

+ A subclass can extend only one abstract class but it can implement multiple interfaces.

+ Abstract classes can extend other classes and implement interfaces but interfaces can only extend other interfaces.

+ We can run an abstract class if it has main() method but we can’t run an interface because they can’t have main method implementation.

+ En definitiva, **si en una clase abstracta declaramos varios métodos, las clases que extienden dicha clase pueden implementarlos o no (si son método abstract tienen que implementarlos sí o sí), mientras que si una clase "implementa" una interfaz ha de proveer una declaración de todos los métodos que en ella están.** Además, en las clases abstractas podemos poner atributos de instancia y constructores, en las interfaces no.


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

The following abstract class gets merrily compiled without a warning or an error:

~~~java
public abstract class AbstractThing implements IAnything {
  public void m1() {}
  public void m3() {}
}
~~~

Can you explain why?

Several answers:

That's fine. To understand the above, you have to understand the nature of abstract classes first. They are similar to interfaces in that respect. This is what Oracle says about this:

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


## Herencia y polimorfismo

+ Por defecto en una interfaz los métodos son públicos

+ Si una clase hereda de otra e implementa una interfaz y a su vez tiene clases hijas, las clases hijas no hace falta que rellenen los métodos de la interfaz, con que lo haga la clase en la que se pone el implements va, y desde las hijas se pueden llamar a dichos métodos, devolviéndose lo de la padre.

+ Sea por ejemplo la clase persona, que tiene una clase hija llamada alumno tal que cada una implementa el método hablar. Al ejecutar:

~~~Java
persona p4= new alumno("e", 1);
System.out.println(p4.hablar());
~~~~

Se llama al hablar del hijo, alumno, aunque su tipo estático sea persona.Si ponemos:

~~~Java
persona p4= new persona("5432", 32);
System.out.println(((alumno)p4).hablar());
~~~
Da el siguiente error:
~~~shell
Exception in thread "main" java.lang.ClassCastException: probando.persona cannot be cast to probando.alumno
	at probando.main.main(main.java:57)
/home/elena/.cache/netbeans/8.2/executor-snippets/run.xml:53: Java returned: 1
~~~
Debido a que no toda persona es un alumno.Otra opción sería:

~~~Java
persona p4= new alumno("e", 1);
System.out.println(((persona)p4).hablar());
~~~

Que llama al hablar de alumno.

Si asignamos varios tipos dinámicos a la misma variable se queda con el último:

~~~Java
persona p4= new alumno("e", 1);
p4= new persona("542", 12);
System.out.println(p4.hablar());
~~~

Llama al hablar de persona.

Teniendo en cuenta que buen_estudiante hereda de alumno:

~~~java
persona p4= new alumno("e", 1);
persona p5= (buen_estudiante) p4;
System.out.println(p4.hablar());
System.out.println(p5.hablar());
~~~

Da el error `Exception in thread "main" java.lang.ClassCastException: probando.alumno cannot be cast to probando.buen_estudiante`, al ser su tipo dinámico padre de la clase desde la cual hacemos casting, no todo alumno es un buen_estudiante aunque si sea cierto el recíproco.

Juntando los ejemplos anteriores, lo siguiente ejecutaría hablar desde alumno y hablar desde estudiante:

~~~java
persona p4= new alumno("e", 1);
persona p5= new buen_estudiante("543", 1);
System.out.println(((persona)p4).hablar());
System.out.println(((alumno)p5).hablar());
~~~

Aunque no funcionaría el hacer un casting de alumno a buen_estudiante:

~~~Java
persona p4= new alumno("e", 1);
persona p5= new buen_estudiante("t3", 1);
System.out.println(((buen_estudiante)p4).hablar());
System.out.println(((alumno)p5).hablar());
~~~

En definitiva: si declaramos una variable y como tipo estático ponemos una clase hija y de tipo dinámico su padre, da error al interpretarlo, antes incluso de compilar. Si una variable la creamos varias veces con distintos tipos dinámicos, se queda con la última llamada al constructor. A la hora de ejecutar, desde una clase hija se pueden hacer castings a clases que se encuentran por encima, no da errores de ningún tipo, pero al ejecutar ejecutará desde la clase de tipo dinámico. **Siempre se ejecutan los métodos desde el tipo dinámico.** Dará error si hacemos casting desde una clase padre a una inferior. **Si un método no está en el tipo estático y si en el dinámico, aunque no de error de compilación lo de da de ejecución.**

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

Igualmente un casting de una clase hermana a otra da error, los castings solo compilan si son de clase hija a alguna superior. Además, en la declaración el tipo dinámico ha de ser "menor o igual" que el estático; `buen_estudiante p7= new alumno("543", "p7", "543", 1);` hace que se muestre el siguiente error: `incompatible types: alumno cannot be converted to buen_estudiante`. El tipo estático es en el que se buscan los métodos, por lo que si tengo una interfaz zombie y declaro:

~~~Java
zombie z= new alumno("erwf", 23);
z.suenio();
System.out.println(z.getPlaneta());
~~~

Obtenemos:

~~~shell
cannot find symbol
symbol:   method getPlaneta()
location: variable z of type zombie
~~~

Aunque alumno herede de persona, en la que sí que tenemos definido `getPlaneta()`, solo se pueden llamar desde ella métodos que están en la interfaz. Igualmente, si ponemos en lugar de zombie persona, no podemos llamar al método `suenio()` que está en zombie, aunque alumno implemente esa interfaz, y sí a métodos de la clase persona --> **El tipo estático sirve para establecer en tiempo de compilación a qué métodos podemos llamar.**

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
reptil = (Reptil) animal; //error en ejecución, se ejecutarán los métodos como si fuera animal, que es su tipo dinámico
-------------------------------------------------------------------------
Animal animal= new Reptil();
Reptil reptil = new Reptil();
reptil = animal; //Da error al interpretarlo, al ser el tipo estático de reptil hijo del de animal.
~~~

**No se puede convertir de una clase hija a una clase padre a la hora de crear objetos**. Veámoslo en nuestro ejemplo:

~~~java
persona p6= new persona("$325342", "gef");
alumno a= new alumno("5432",1);

p6= a;
a= p6;
System.out.println(p6.hablar());
~~~

Al ser alumno heredero de persona `a= p6` da error, dice que no puede convertir uno en otro. Al hacer `p6= a` el último tipo dinámico asignado a p6 es alumno, luego `p6.hablar()` se ejecutará desde alumno.

El siguiente ejemplo ilustra la segunda parte de lo anterior:
~~~java
persona p6= new persona("5432", "persona");
alumno a= new alumno("alumno", 1);

a= (alumno) p6;
System.out.println(a.get_nombre());
~~~

No da error de compilación pero al ejecutar lo último devuelve alumno, que es el nombre de a, cuando debería devolver persona, porque se está haciendo el casting de una clase padre a una hija. Si se hace desde una hija a una padre no da error de ejecución:

~~~java
p3= new buen_estudiante("buen estudiante", 1, 4.5);
persona p6= new persona("persona", 11);
alumno a= new alumno("alumno", 1);

a= (alumno) p3;
System.out.println(a.get_nombre());
~~~

Imprime buen estudiante.

+ Si desde una instancia de una clase se llama a un método de clase, se imprimirá el de la clase correspondiente al tipo estático. Así por ejemplo si tenemos en un fichero llamado `Padre.java`:

~~~Java
package polimorfismo;


public class Padre {
    static int c= 33;
    private int a= 44;

    Padre(int b){
        a= b;
        System.out.println("Constructor de padre");
    }

    public void deInstancia() {
        System.out.println("Desde el padre. Instancia");
    }

    public static void deClase() {
        System.out.println("Desde el padre. Clase" + c);
    }

    public void llama_c(){
        System.out.println(c + " desde padre");
    }  
}
~~~
Y en otro llamado `Hija.java`:

~~~java
package polimorfismo;

public class Hija extends Padre{
  Hija(int p){
      super(p);
  }

  @Override
  public void deInstancia() {
      System.out.println("Desde la hija. Instancia");
  }

  public static void deClase() {
      System.out.println("Desde la hija. Clase" + c);
  }

  public void llama_c(){
      c++;
      System.out.println(c + " desde hija");
  }
}
~~~

Y ejecutamos:

~~~java
package polimorfismo;


public class Polimorfismo {
    public static void main(String[] args) {  
        Padre p1=new Padre(5);
        p1.deInstancia();
        Hija h1=new Hija(6);
        h1.deInstancia();
        Padre p2=new Hija(3);
        p2.deInstancia();

        Padre.deClase();
        Hija.deClase();

        //Recordad que no se debe hacer lo siguiente
        //Quiero mostrar que a nivel de clase las cosas no funcionan igual
        p1.deClase();
        h1.deClase();
        p2.deClase();      
    }  
}
~~~
`p1.deInstancia()` imprime "desde el padre. instancia", `h1.deInstancia()` "desde la hija.instancia", como es normal. Por otro lado `p2.deInstancia()` imprime "desde la hija. instancia", al ser Hija su tipo dinámico. `Padre.deClase()` e `Hija.deClase()` imprimen lo que podría esperarse, "desde el padre. clase 33" y "desde la hija. clase 33" lo curioso es cuando llamas desde p1 al método `deClase()`, que ejecuta al mismo, pero ahora fijándose en el tipo estático, por ello `p2.deClase()` imprime "desde el padre. clase". Si implementamos constructor en la clase padre tenemos que hacer otro para hija, al no funcionar ya los de por defecto.

Si ahora en la clase padre creamos el método:

~~~java
void otro_met(){
    System.out.println("Desde padre");
    deClase();
}
~~~

Y lo llamamos desde hija con:

~~~Java
void met_propio(){
    otro_met();
}
~~~

Entonces imprimirá "Desde padre" seguido de "desde el padre. clase", es decir, `met_propio()` busca a `otro_met()` en la clase padre, y ejecuta `deClase()` también desde el padre, no como en ruby; supongamos que tenemos el siguiente fichero:

~~~ruby
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
~~~

Al ejecutarlo imprimiría:

~~~sh
Soy el padre
333
---
Impersonando a mi padre:
Soy el padre
334
334
---
Mi padre diria:
Impersonando a mi padre:
Soy el padre
y yo soy el hijo 334
---
["ana", "pepe", "juan"]
bla,bla
Estimados
["ana", "pepe", "juan"]
bla,bla
---
Llamo a un metodo privado de mi padre:
Privado en el padre
-------------
Desde el padre
Yo soy la hija
~~~

Vemos así el hecho de que si tenemos un atributo de clase en la clase padre y lo modificamos desde la clase hija, se modifica en la clase padre. Es más, si en la clase hija al principio ponemos `@@deClase= 0`, en la segunda línea imprimiría 0, toma el último valor con el que se haya inicializado el atributo de clase, incluso aunque lo hayamos cambiado en hija y lo llamemos primero desde padre. También, a diferencia de java, al ejecutar `met_propio` de hija se va a `otro_met` de padre, pero luego `habla` lo vuelve a ejecutar desde la hija. No muy arriba hemos visto que haciendo lo equivalente en java el método de dentro de `otro_met` lo ejecuta desde el padre.

Lo de que si redefinimos el atributo de clase en la clase hija se cambie inmediatamente en la clase padre es diferente en java; si pongo en `Hija` `static int c= 0` las veces que imprima c desde padre imprimirá 33 o lo que valga, y cuando lo haga desde hija imprimirá 0, y será ese el que vaya incrementando, no el c de padre.

> En resumen, en java si tenemos un atributo de clase en la clase padre y creamos uno igual en la clase hija con otro valor, al llamarlo desde la clase padre usará el valor que tenga en ésta, y en la clase hija el valor que tenga ahí, mientras que en ruby se cambia en los dos, si creo un atributo de clase en la clase hija con el mismo nombre que en la clase padre, la de la clase padre pasa a tener el valor del de la clase hija, aunque no creemos una instancia de hija ni la usemos, se queda con el último valor asignado al atributo de clase, y cualquier modificación desde la clase hija afecta el de la padre, cosa que no ocurre en java, donde son independientes.

>También si desde la clase hija ejecutamos un método que llama a un método de la clase padre y a su vez desde éste se llama a un método que está implementado en las dos clases, en java se tomará el del padre mientras que en ruby se tomará la definición que se da en la clase Hija del mismo.

# Visibilidad Java

+ Basically, `private` hides from other classes within the package, `public` exposes to classes outside the package and `protected` is a version of public restricted only to subclasses.

+ En resumen: `protected` se puede usar por una clase y subclases suyas ya sea desde el mismo paquete o distinto, es como public para las subclases, `public` desde todos lados, `default` desde la propia clase y subclases que estén en el mismo paquete y privado únicamente desde la propia clase en la que está declarado el método o atributo.

+ Se pueden pasar como parámetros cosas en plan test.visibilidad siempre que:
  + el atributo al que referencian no sea privado
  + Si la visibilidad del atributo es protegido o paquete se puede si es una subclase o están en el mismo paquete, respectivamente.
  + si es público siempre

# super en ruby

Sea el siguiente fichero:

~~~ruby
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
	def metodo
		puts "Hijo"
		###Un ejemplo en Ruby usando APARENTE sintaxis Java.
		super.metodo2
	end

	def metodo2
		puts "Hijo2"
	end

end

Hijo.new.metodo
~~~

Al ejecutarlo, contrario a lo que podríamos pensar, devuelve

~~~shell
Hijo
Padre
Elem2
~~~

No da pues error al compilarlo pero sí al ejecutarlo, no hace lo que debiera, que es imprimir "Padre2", sino que simplemente llama a `metodo` de `Padre` después de llamar al de `Hijo`, y no imprime Hijo, Padre2. Si quitamos el `super` ejecuta el `metodo2` de `Hijo`:

~~~sh
Hijo
Hijo2
~~~

Con poner `super` bastaría para que llamara a `metodo` de la clase padre. La única manera de llamar a un método de la clase padre desde otro método de la clase hija que no tenga el mismo nombre es haciendo un alias o un binding:

~~~ruby
class Parent
    def method
    end
end

class Child < Parent
    alias_method :parent_method, :method
    def method
        super
    end

    def other_method
        parent_method
        #OR
        Parent.instance_method(:method).bind(self).call
    end
end
~~~

# What is the question mark in Java Generics used for?

This is a type wildcard. It is a little bit convoluted, but let me show some examples first.

~~~java
    List<String> strings = ...
    List<Object> list = strings; // syntax error
~~~
You would expect this to work, but it doesn't. Although `String` is an `Object`, this relationship does not extend into generics. A list of one type is not a list of the other, their types are invariant.

You can loosen this by using wildcards. You can allow the type parameter to accept subclasses by using `<? extends T>`, and you can allow the type parameter to accept superclasses by using `<? super T>`:
~~~java
    List<? extends Object> strings = new ArrayList<String>();
    List<? extends Object> objects = new ArrayList<Object>();
    // You can abbreviate <? extends Object> to simply <?>

    List<? super String> strings2 = new ArrayList<String>();
    List<? super String> objects2 = new ArrayList<Object>();
~~~
There is a price to pay for this flexibility:

    when you use `<? extends T>`, you are restricted to use only the covariant (T producing) methods of the class;
    when you use `<? super T>`, you are restricted to use only the contravariant (T consuming) methods of the class.

What does it mean in practical terms? In the first case, you lose the ability to call consuming methods such as add :

~~~java
    objects.add(new Object()); // syntax error
    Object object = objects.get(0);
~~~
In the second case, you lose the ability to call producing methods, such as get on the strings variable:

~~~java
    strings2.add("d");
    String string = strings2.get(0); // syntax error
~~~
The typical use-cases for both are usually summarised as P.E.C.S. mnemonic: Producer Extends, Consumer Super. Here are two examples from the source code of the List interface:

~~~java
    default void sort(Comparator<? super E> c) { ... }
    boolean addAll(Collection<? extends E> c);
~~~
In the first case, the comparator will consume the values we provide to give us a sorting order. If we skipped the wildcard, we would not be able to use an Object comparator on any lists of strings.
~~~java
    List<String> strings = ArrayList<>(Arrays.asList("a", "b", "c"));
    Comparator<Object> comparator = (o1, o2) -> o1.hashCode() - o2.hashCode();
    strings.sort(comparator); // works!
~~~
In the second case the collection will produce the values we are going to add to the list. If we skipped the wildcard, we would not be able to add any subclass objects to lists.

~~~java
    List<Number> numbers = ArrayList<>();
    List<Integer> integers = Arrays.asList(1, 2, 3);
    numbers.addAll(integers); // works!
~~~
What if you need to use something as both a producer and a consumer? In that case, you simply cannot use wildcards at all. For example, another method from List interface is:

`default void replaceAll(UnaryOperator<E> operator) { ... }`
Here, the operator will consume a value to produce another value. If we try to use extends, the operator will not be able to consume values we pass, and if we try to use super, the operator will not be able to produce values for us to use.

From https://www.quora.com/What-is-the-question-mark-in-Java-Generics-used-for

# Copiando en java

Si llamamos al método `clone()` desde cualquier clase que hayamos creado, si no es Object entonces habrá que hacer un casting a dicha clase. Por ejemplo, si tengo en una clase un atributo de instancia privado `ArrayList<numero> numeros`, donde numero es otra clase que tiene un Integer dentro, al hacer `numeros.clone()` me dirá que no se puede convertir de tipo Object a ArrayList<numero>, por eso hemos de hacer el casting:

~~~java
ArrayList<numero> getNumeros(){
  return (ArrayList<numero>) numeros.clone(); //se hace el casting porque clone es de la clase Object
}
~~~

# Mezclando herencia y clases abstractas

Supongamos que tenemos en un archivo A.java:

~~~java
package pruebas;


public class A {
    private int a= 10;
    private static String s= "hola";

    A(int b, String r){
        a= b;
        s= r;
    }

    public void met1(int a){
        this.a= a;
    }

    protected void met2(String s){
        this.s= s;
    }

    public void showA(){
        System.out.println(a);
    }

    public void showS(){
        System.out.println(s);
    }
}
~~~

En otro llamado B.java:

~~~java
package pruebas;

public abstract class B extends A {
    B(){
        super(100, "hola abstracto");
    }
}
~~~
Si no se pone ningún constructor nos dice que el constructor de A "cannot be applied to given types", tenemos que proveer con otro constructor, aunque en la clase C, que hereda de la clase abstracta B, si no ponemos constructor no pasa nada.
Y en C.java:

~~~java
package pruebas;


public class C extends B {

}
~~~

Y ejecutamos main.java:

~~~java
package pruebas;


public class main {
    public static void main(String [] args){
        C c= new C();
        c.showA();
        c.showS();

        c.met1(5);
        c.met2("adios");
        c.showA();
        c.showS();
    }
}
~~~

Muestra
100
hola abstracto
5
adios

Vemos así como podemos usar métodos de la clase A aunque en B no hagamos nada, al ser su hija. Cambiemos ligeramente B:

~~~java
//B.java
package pruebas;

public abstract class B extends A {
    B(){
        super(100, "hola abstracto");
    }

    public void met1(int a){
        System.out.println("Met1 abstracto");
        super.met1(a+10);
    }

    public abstract void met2(String s);
}
~~~
Al haber añadido un método abstracto, ahora en C tenemos que implementarlo:

~~~java
//C.java
package pruebas;


public class C extends B {
    public void met2(String s){
        System.out.println("Met2 modificado");
    }
}
~~~

Ahora, al ejecutar lo anterior obtenemos:
100
hola abstracto
Met1 abstracto
Met2 modificadoadios
15
hola abstracto

Observamos así el hecho de que ahora que en B hemos hecho el método, cuando hacemos c.met1(5), usa el met1 de B, igual que met2, ya no los busca en la clase padre.

# Trasteando con interfaces

Aunque en una interfaz declare un método con visibilidad de paquete, esto es, no le ponga ningún especificador de acceso, se declara como si fuera público, luego si creo una clase que implementa la interfaz, al hacer los métodos de la interfaz siempre hay que ponerlos públicos. Si pongo private o protected da error. Ejemplo:

~~~java
//Interfaz1.java
package pruebas;

public interface Interfaz1 {
    public void met1();
    void met2();
}
~~~

~~~java
//Interfaz2.java
package pruebas;


public interface Interfaz2 extends Interfaz1 {
    void met1();
    void met3();
}
~~~

~~~java
//HijaDeInterfaces.java
package pruebas;


public class HijaDeInterfaces implements Interfaz2 {
    public void met1(){
        System.out.println("Soy met1");
    }

    public void met2(){
        System.out.println("Soy met2");
    }

    public void met3(){
        System.out.println("Soy met3");
    }
}
~~~
Como vemos, en este último fichero he tenido que declarar todos los métodos públicos, si no decía `met3() in HijaDeInterfaces cannot implement met3() in Interfaz2
  attempting to assign weaker access privileges; was public`










#
