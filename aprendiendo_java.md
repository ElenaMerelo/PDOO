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
