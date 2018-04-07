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

# Collections.ncopies method

  It can be used when we need to initialize the ArrayList with the same value for all of its elements. Syntax: count is number of elements and element is the item value
~~~java
ArrayList<T> obj = new ArrayList<T>(Collections.nCopies(count, element));

Example:

import java.util.*;

public class Details {
   public static void main(String args[]) {
	   ArrayList<Integer> intlist = new ArrayList<Integer>(Collections.nCopies(10, 5));
	  System.out.println("ArrayList items: "+intlist);
   }
}
~~~
Output:

ArrayList items: [5, 5, 5, 5, 5, 5, 5, 5, 5, 5]

# Conditionally remove elements from a List in Java 8
Java 8 introduces a new method available for Collection types: removeIf(). It accepts a predicate which defines the condition on which the elements should be removed. It returns a boolean where a true response means that at least one item has been removed and false otherwise:
~~~java

Collection<String> stringStack = new Stack<>();
stringStack.add("Hello");
stringStack.add("my");
stringStack.add("dear");
stringStack.add("world");

stringStack.removeIf(s -> s.contains("ll"));
~~~
The above example will remove “Hello” from the list stack.

Note that not all collections support item removal. In that case the method will throw an `UnsupportedOperationException` in case an attempt is made to remove a matching element. The ArrayList is one such collection:

~~~java
Collection<String> asList = Arrays.asList("hello", "my", "dear", "world");
asList.removeIf(s -> s.contains("ll"));
~~~
This will throw an exception unfortunately as the Array.asList method returns an ArrayList of type java.util.Arrays.ArrayList (which is read only and fixed size) and not the classic java.util.ArrayList (resizable and item-removable).

# Printing an arrayList as a String

Gotten from: https://stackoverflow.com/questions/31601952/need-to-print-an-arraylist-using-tostring-and-also-add-remove-elements

Q:I am tinkering with a code for a library and am having a lot of trouble so the first thing I need to sort out is how to add and remove books while also using a tostring to print the current and previous contents of the array. It is printing them out fine, but it isn't removing them. Could anyone let me know why? and when it prints them out I want it to only say title once like

title: The Gunlsinger

The Drawing of the three

not: Title:Gunslinger

Title:Drawing of the Three
~~~java
class Library {

    private String books;

    Library(String b) {
        // this.owner=o;
        this.books = b;
    }

    //
    public String toString() {
        return "\nTitle:" + this.books;
        // System.out.println
    }

    public static void main(String[] args) {
        ArrayList<Library> books = new ArrayList<Library>();
        books.add(new Library("The Gunslinger"));
        books.add(new Library("The Drawing of the Three"));
        books.remove("The Gunslinger");
        for (Library a : books) {
            System.out.println(a);
        }

    }
}
~~~
A: Let's look at what you were trying.

    You added 2 objects to an ArrayList
    You then tried to remove one of the objects from the ArrayList by calling remove(String s).

First, there is no remove(String s). What your code is actually calling is remove(Object o). Even though a String is an Object, the Object this method really expects is your Library object, which is why you have answers that suggest that you have to override the equals() and hashCode()

Another approach would be to extend the ArrayList class with your own custom class (Library), that has Book objects, and implement a remove(String s).

As far as the "Titles: " only appearing once in your results, an `@Override toString()` is in order for that.

Library custom class that extends ArrayList:
~~~java
public static class Library extends ArrayList<Book> {
    // Adding an overload remove method that accepts a String
    public void remove(String book) {
        // Find the book to remove
        for (int i = 0; i < size(); i++) {
            if (get(i).getTitle().equals(book)) {
                // This remove() is one of the default remove methods
                // that is part of an ArrayList
                remove(i);
                break;
            }
        }
    }

    // This will display "Titles: " once along with every
    // book in the ArrayList
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Titles: ");
        // Append each book to the returning String
        forEach(book -> sb.append(book).append("\n"));
        return sb.toString();
    }
}
~~~

Book custom class:

~~~java
public static class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        // You could append additional information like
        // author, publisher, etc...
        return title;
    }
}
~~~
Usage:

~~~java
public static void main(String[] args) throws Exception {
    Library books = new Library();
    books.add(new Book("The Gunslinger"));
    books.add(new Book("The Drawing of the Three"));
    System.out.println("After add: ");
    System.out.println(books);

    books.remove("The Gunslinger");
    System.out.println("After remove: ");
    System.out.println(books);      
}
~~~

Entonces, si en mi clase Hangar del proyecto deepspace tengo un vector de weapons, cuyos elementos son de tipo Weapon, y tienen sobrecargado el toString, para sobrecargar el método toString de Hangar basta añadir en la clase Hangar:

~~~java
public String toString(){
    StringBuilder sb = new StringBuilder("Weapons: ");
    // Append each weapon to the returning String
    for(Weapon w: weapons)
        sb.append(w).append("\n");
    return sb.toString();
}
~~~
