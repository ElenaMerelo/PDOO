> Example JUnit test

The following code shows a JUnit test using the JUnit 5 version. This test assumes that the MyClass class exists and has a multiply(int, int) method.

~~~java
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MyTests {

    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {
        MyClass tester = new MyClass(); // MyClass is tested

        // assert statements
        assertEquals(0, tester.multiply(10, 0), "10 x 0 must be 0");
        assertEquals(0, tester.multiply(0, 10), "0 x 10 must be 0");
        assertEquals(0, tester.multiply(0, 0), "0 x 0 must be 0");
    }
}
~~~

> Testing enums

From stackoverflow:
Q: I'm currently trying to build a more or less complete set of unit tests for a small library. Since we want to allow different implementations to exist we want this set of tests to be (a) generic, so that we can re-use it to test the different implementations and (b) as complete as possible. For the (b) part I'd like to know if there is any best-practice out there for testing enum types. So for example I have an enum as follows:

~~~java
public enum Month {
    January,
    February,
    ...
    December;
}
~~~

Here I want to ensure that all enum types really exist. Is that even necessary? Currently I'm using Hamcrests `assertThat` like in the following example:
~~~java
assertThat(Month.January, is(notNullValue()));
~~~
A missing "January" enum would result in a compile time error which one can fix by creating the missing enum type.

Edit:

Testing enums may not be necessary since the compiler won't compile when you are using an enum type which isn't there. But I still want to test those enums since we want to build a seperate TCK-like test.jar which will run the same test on different implementations. So my question was more meant to be like: What is the best way to test enum types?

After thinking about it a bit more I changed the Hamcrest statement above to:
~~~java
assertThat(Month.valueOf("January"), is(notNullValue()));
~~~

A: For enums, I test them only when they actually have methods in them. If it's a pure value-only enum like your example, I'd say don't bother.

But since you're keen on testing it, going with your second option is much better than the first. The problem with the first is that if you use an IDE, any renaming on the enums would also rename the ones in your test class.

> assertEquals()

The assertEquals() method compares two objects for equality, using their equals() method.

Here is a simple example:

~~~java
import org.junit.Test;
import static org.junit.Assert.*;

public class MyUnitTest {

    @Test
    public void testConcatenate() {
        MyUnit myUnit = new MyUnit();

        String result = myUnit.concatenate("one", "two");

        assertEquals("onetwo", result);
    }
}
~~~

First the myUnit.concatenate() method is called, and the result is stored in the variable result.

Second, the result value is compared to the expected value "onetwo", using the assertEquals() method.

If the two objects are equal according to their implementation of their equals() method, the assertEquals() method will return normally. Otherwise the assertEquals() method will throw an exception, and the test will stop there.

This example compared to String objects, but the assertEquals() method can compare any two objects to each other. The assertEquals() method also come in versions which compare primitive types like int and float to each other.



Statement |	Description
--- | ---
| fail([message]) | Let the method fail. Might be used to check that a certain part of the code is not reached or to have a failing test before the test code is implemented. The message parameter is optional.

| assertTrue([message,] boolean condition) | Checks that the boolean condition is true.

| assertFalse([message,] boolean condition) | Checks that the boolean condition is false.

| assertEquals([message,] expected, actual) | Tests that two values are the same. Note: for arrays the reference is checked not the content of the arrays.

| assertEquals([message,] expected, actual, tolerance) | Test that float or double values match. The tolerance is the number of decimals which must be the same.

| assertNull([message,] object) | Checks that the object is null.

| assertNotNull([message,] object) | Checks that the object is not null.

| assertSame([message,] expected, actual) | Checks that both variables refer to the same object.

| assertNotSame([message,] expected, actual) | Checks that both variables refer to different objects.

> Create Test Suite Class

+ Create a java class.
+ Attach @RunWith(Suite.class) Annotation with the class.
+ Add reference to JUnit test classes using @Suite.SuiteClasses annotation.

Create a java class file named TestSuite.java to execute test case(s).

~~~java
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   TestJunit1.class,
   TestJunit2.class
})

public class JunitTestSuite {   
}  	
~~~

> Create Test Runner Class

Create a java class file named TestRunner.java to execute test case(s).

~~~java
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(JunitTestSuite.class);

      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }

      System.out.println(result.wasSuccessful());
   }
}  
~~~	



#
