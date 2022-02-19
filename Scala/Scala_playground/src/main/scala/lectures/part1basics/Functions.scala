package lectures.part1basics

/**
 * Created by yinhaohe on Feb 17, 2022
 */
object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterLessFunction(): Int = 42

  println(aParameterLessFunction())

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello", 3))

  // WHEN YOU NEED LOOPS, use RECURSION.

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)
  // When only deals with side effect, can use the unit as return type

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int) = a + b

    // Can use auxiliary function to determine return type of the parent/outer function
    aSmallerFunction(n, n - 1)
  }

  /*
  Exercises:
  1.  A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
  2.  Factorial function 1 * 2 * 3 * .. * n
  3.  A Fibonacci function
      f(1) = 1
      f(2) = 1
      f(n) = f(n - 1) + f(n - 2)
  4.  Tests if a number is prime.
 */

  def greetingForKids(name: String, age: Int): String = {
    s"Hi, my name is ${name} and I am ${age} years old."
  }

  println(greetingForKids("David", 12))

  def factorial(number: Int): Int = {
    if (number <= 0) 1
    else number * factorial(number - 1)
  }

  println(factorial(5))

  def fibonacci(number: Int): Int = {
    if (number == 1) 1
    else if (number == 2) 1
    else fibonacci(number - 1) + fibonacci(number - 2)
  }

  println(fibonacci(5))

  def isPrime(number: Int, start: Int = 2): Boolean = {
    if (start <= math.sqrt(number) && number % start == 0) false
    else if (start >= math.sqrt(number)) true
    else isPrime(number, start + 1)
  }

  println(isPrime(37 * 17))

  def isPrime2(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }

  println(isPrime2(37 * 17))
}
