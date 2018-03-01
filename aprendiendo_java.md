# Atributos en Java

Un atributo es una característica que se representa mediante un valor almacenado en una variable. Distinguimos:
+ **Atributo de instancia**: Representa una característica de un objeto particular. Así, cada objeto tiene su propia copia de cada atributo de instancia, con lo que objetos diferentes pueden dar valores diferentes a un mismo atributo, si tenemos la clase perro, el atributo de instancia `color` de un perro será distinto del de otro. Se declaran:
~~~Java
public class perro{
  private int manchas;
  ...
}
~~~

+ **Atributo de clase**: Representa una característica compartida por un conjunto de objetos y la propia clase. El atributo se almacena en la propia clase, por lo que su valor será el mismo para todas las instancias de la clase. Se declaran con la palabra `static`, se puede añadir la keyword `final` para indicar que no va a cambiarse dicho atributo. A diferencia de las constantes, el valor de una variable final no tiene por qué conocerse en tiempo de compilación. Solo se pueden inicializar una vez, ya sea con un constructor, en la propia declaración.
~~~Java
public class perro{
  private static String color;
  private final static String name;
  ...
}
~~~
> Consecuentemente, un atributo de clase es una característica de cada objeto que creemos de un tipo determinado, cambia de un objeto a otro, no es estático, mientras que un atributo de clase es igual en todos los objetos que se creen de un mismo tipo, es estático.

# Constructores de copia
~~~Java
/**
  * Copy constructor.
  */
  public Galaxy(Galaxy g) {
    this(g.getMass(), g.getName());
    //no defensive copies are created here, since
    //there are no mutable object fields (String is immutable)
  }

  /**
  * Alternative style for a copy constructor, using a static newInstance
  * method.
  */
  public static Galaxy newInstance(Galaxy g) {
    return new Galaxy(g.getMass(), g.getName());
  }

  //Another option:
  public Galaxy(Galaxy g){
    this.mass= g.mass;
    this.name= g.name;
  }

  public Person(Person original) {
    this.id = original.id;

    this.name = new String(original.name);

    this.city = new City(original.city);
  }
  ~~~

  >Cuando nos dicen de crear una clase, enumerado,... con visibilidad de paquete quiere decir que no tendremos que poner ni public ni private a la hora de declararlo, la opción por defecto, default, es crearlo con este tipo de visibilidad.

  # Enumerados
  Para crear un enumerado en Netbeans pulsamos botón derecho en source packages y seleccionamos Java Enum. Los valores que tienen dentro se consideran constantes, se pueden añadir además métodos, pero Java requiere que las constantes vayan primero y para hacer referencia a ellos hemos de escribir `nombre_del_enum.lo_que_queremos_acceder`. Así por ejemplo:
  ~~~Java
  //Puede ser también private o public, como lo hemos declarado le estamos dando visibilidad de paquete.
  enum Comidas{ MACARRONES, CHOCOLATE, MANTECADOS, LENTEJAS, FRUTA }

  //Si ahora queremos acceder a éste desde otra clase, dentro del mismo paquete:
  Comidas ricas= Comidas.FRUTA;
  ~~~
