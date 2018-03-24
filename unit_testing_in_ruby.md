As more and more unit tests accumulate for a given project, it becomes a real drag running them one at a time, and it also introduces the potential to overlook a failing test because you forget to run it. Suddenly it becomes very handy that the TestRunners can take any object that returns a Test::Unit::TestSuite in response to a suite method. The TestSuite can, in turn, contain other TestSuites or individual tests (typically created by a TestCase). In other words, you can easily wrap up a group of TestCases and TestSuites like this:
~~~ruby
require 'test/unit'
require 'tc_myfirsttests'
require 'tc_moretestsbyme'
require 'ts_anothersetoftests'

class TS_MyTests
  def self.suite
    suite = Test::Unit::TestSuite.new
    suite << TC_MyFirstTests.suite
    suite << TC_MoreTestsByMe.suite
    suite << TS_AnotherSetOfTests.suite
    return suite
  end
end
Test::Unit::UI::Console::TestRunner.run(TS_MyTests)
~~~
> Setup and Teardown

There are many cases where a small bit of code needs to be run before and/or after each test. Test::Unit provides the setup and teardown member functions, which are run before and after every test (member function).

~~~ruby
# File:  tc_simple_number3.rb

require "./simple_number"
require "test/unit"

class TestSimpleNumber < Test::Unit::TestCase

  def setup
    @num = SimpleNumber.new(2)
  end

  def teardown
    ## Nothing really
  end

  def test_simple
    assert_equal(4, @num.add(2) )
  end

  def test_simple2
    assert_equal(4, @num.multiply(2) )
  end

end
~~~

> Available Assertions

Test::Unit provides a rich set of assertions, which are documented thoroughly at Ruby-Doc. Here's a brief synopsis (assertions and their negative are grouped together. The text description is usually for the first one listed -- the names should make some logical sense):

Assertion | Explanation
--- |---
| assert( boolean, [message] ) | 	True if boolean
| assert_equal( expected, actual, [message] ), assert_not_equal( expected, actual, [message] ) |	True if expected == actual
| assert_match( pattern, string, [message] ), assert_no_match( pattern, string, [message] ) |	True if string =~ pattern
| assert_nil( object, [message] ), assert_not_nil( object, [message] ) |	True if object == nil
| assert_in_delta( expected_float, actual_float, delta, [message] ) |	True if (actual_float - expected_float).abs <= delta
| assert_instance_of( class, object, [message] ) |	True if object.class == class
| assert_kind_of( class, object, [message] ) |	True if object.kind_of?(class)
| assert_same( expected, actual, [message]), assert_not_same( expected, actual, [message] ) |	True if actual.equal?( expected ).
| assert_raise( Exception,... ) {block}, assert_nothing_raised( Exception,...) {block} |	True if the block raises (or doesn't) one of the listed exceptions.
| assert_throws( expected_symbol, [message] ) {block}, assert_nothing_thrown( [message] ) {block} |	True if the block throws (or doesn't) the expected_symbol.
| assert_respond_to( object, method, [message] ) |	True if the object can respond to the given method.
| assert_send( send_array, [message] ) |	True if the method sent to the object with the given arguments return true.
| assert_operator( object1, operator, object2, [message] ) |	Compares the two objects with the given operator, passes if true

> Requiring files

Ways to include a file:

~~~ruby
require_relative '../../file
require File.expand_path(../../file)

lib = File.expand_path("../lib", __FILE__)
$LOAD_PATH.unshift(lib) unless $LOAD_PATH.include?(lib)
require "your_gem/version"
~~~

Question from stackoverflow:
I am trying to require a rake file that I have created inside another file I have. These two files are inside two different directories. I have require at the top of my first file with the name of the second file inside the quotes after the require. It is telling me that it can't load such file. Does that mean because its in different directory it can't find it? I tried sticking in the full path to the second file but it still can't load the file. Does anyone know how I can load the second file into the first?
Answer:
require will search for files in only a set of locations referred to as the "Load Path." You can view the load path by using the global variable $LOAD_PATH in a script or irb session. If it is not in the load path, it won't find it.

Ruby 1.9 introduced require_relative which searches using the current file's location as a starting point.

~~~ruby
# Will search $LOAD_PATH for file.
require 'test/unit'
# Notice the '/' which tells it to look in the
# 'test' folder for a file named 'unit.rb'

# Will look in current folder of file
require_relative 'my_folder/my_file'
# Will search in 'my_folder' for the file 'my_file.rb'
~~~
Note that require_relative will not work in irb.

Also note, that if you really want to use require, you can start your script by adding a location to the $LOAD_PATH variable.

~~~ruby
$LOAD_PATH << File.join('users', 'yourusername', 'your_folder')
# or
$LOAD_PATH << File.dirname(__FILE__)
# The second one enables you to move the file around on your
# system and still operate correctly
require 'my_file'
~~~

> Por ejemplo: tengo en un proyecto llamado Deepspace las carpetas lib, nbproject, pkg, spec y test, y a su vez en la carpeta test los archivos ts_p1.rb y tc_weapon_type.rb. Desde el archivo tc_weapon_type.rb necesito un archivo que está en la carpeta lib llamado WeaponType.rb. Para poder usarlo hay que añadir al principio de tc_weapon_type.rb `require_relative ../lib/WeaponType`, porque tengo que irme un directorio antes. Si queremos llamar a un archivo que está en el mismo directorio desde el cual lo llamamos simplemente usamos `require_relative 'nombre_archivo'`:

~~~ruby
# File: ts_p1.rb, en la misma carpeta que tc_weapon_type.rb, todos dentro del módulo Deepspace

require 'test/unit'
require_relative 'tc_weapon_type'

module Deepspace
  class TS_p1
    def self.suite
      suite= Test::Unit::TestSuite.new
      suite << TC_WeaponType.suite

      return suite
    end
  end

  # Test::Unit::UI::Console::TestRunner.run(TS_p1)
end
~~~

~~~ruby
# File: tc_weapon_type.rb, que llama a WeaponType.rb, en otra carpeta, lib, que está a su vez en el mismo directorio que la carpeta test donde se encuentra tc_weapon_type.rb

require 'test/unit'
require_relative '../lib/WeaponType'


module Deepspace
  class TC_WeaponType < Test::Unit::TestCase
    def test_weapon_type
      assert_equal(2.0, WeaponType::LASER.power, "LASER.power doesn't work")
      assert_equal(3.0, WeaponType::MISSILE.power, "MISSILE.power doesn't work")
      assert_equal(4.0, WeaponType::PLASMA.power, "PLASMA.power doesn't work")
    end
  end
end
~~~

> Automatizando tests: setup, teardown y rake

Algunas veces necesitamos que ocurran cosas antes y después de cada test. Los métodos setup y teardown son tus compañeros en esta aventura. Cualquier código escrito en setup será ejecutado antes del código, y el código escrito en teardown será ejecutado a posteriori.

Si estás escibiendo tests para todo tu código (como debería ser), el número de ficheros a testear empieza a crecer. Una cosa que puede facilitarte la vida, es automatizar los tests, y rake es la herramienta para este trabajo.

~~~ruby
# fichero_rake

require 'rake'
require 'rake/testtask'

task :default => [:test_units]

desc "Ejecutando los tests"
Rake::TestTask.new("test_units") { |t|
  t.pattern = 'test/*_test.rb'  # busca los ficheros acabados en '_test.rb'
  t.verbose = true
  t.warning = true
}
~~~

Básicamente, un fichero_rake define las tareas que rake puede hacer. En el fichero_rake, la tarea por defecto (la que sucede cuando se ejecuta rake en un directorio con un fichero_rake en él) es configurada hacia la tarea tests_units. En la tarea tests_units, rake es configurado para buscar ficheros en el directorio que terminen en "_ test.rb" y los ejecute. Resumiendo: puedes poner todos los tests en un directorio y dejar que rake haga el trabajo.

> Differences between ==, ===, eql?, equal?

+ **== — generic "equality"**
    At the Object level, == returns true only if obj and other are the **same object**. Typically, this method is overridden in descendant classes to provide class-specific meaning.

    This is the most common comparison, and thus the most fundamental place where you (as the author of a class) get to decide if two objects are "equal" or not.

+ **=== — case equality** For class Object, effectively the same as calling #==, but typically overridden by descendants to provide meaningful semantics in case statements.

+ **eql? — Hash equality**

    The eql? method returns true if obj and other refer to the same hash key. This is used by Hash to test members for equality. For objects of class Object, eql? is synonymous with ==. Subclasses normally continue this tradition by aliasing eql? to their overridden == method, but there are exceptions. Numeric types, for example, perform type conversion across ==, but not across eql?, so:

    1 == 1.0     #=> true
    1.eql? 1.0   #=> false

    So you're free to override this for your own uses, or you can override == and use alias :eql? :== so the two methods behave the same way.
+ **equal? — identity comparison**

    Unlike ==, the equal? method should never be overridden by subclasses: it is used to determine object identity (that is, a.equal?(b) if a is the same object as b).This is effectively pointer comparison.
    Unlike the == operator which tests if both operands are equal, the equal method checks if the two operands refer to the same object. This is the strictest form of equality in Ruby.

    Example:
    ~~~ruby
    a = "zen" b = "zen"

    a.object_id  # Output: => 20139460
    b.object_id  # Output :=> 19972120

    a.equal? b  # Output: => false
    ~~~
    In the example above, we have two strings with the same value. However, they are two distinct objects, with different object IDs. Hence, the equal? method will return false.

    Let's try again, only this time b will be a reference to a. Notice that the object ID is the same for both variables, as they point to the same object.

    ~~~ruby
    a = "zen"
    b = a

    a.object_id  # Output: => 18637360
    b.object_id  # Output: => 18637360

    a.equal? b  # Output: => true
    ~~~

> Diferencias entre assert_equal y assert_same

`assert_equal expected, actual` comprueba que actual == expected, que referencien al mismo objeto. Así, si tenemos un objeto de la clase Foo llamado f1, `f1 = Foo.new(1, 2, 3)`, `f2 = Foo.new(1, 2, 3)`, `f3= Foo.newCopy(f1)` al escribir `assert_equal f1, f2` nos da error, ya que no son iguales en el sentido de que "apuntan" al mismo objeto, aunque sus atributos de instancia estén inicializados a los mismos valores. Igualmente con `assert_equal f1, f3` dará failure, son objetos distintos, uno es copia de otro, pero no referencian a lo mismo.

Para que dos cosas que comparemos con assert_same sean iguales han de tener el mismo object_id











#
