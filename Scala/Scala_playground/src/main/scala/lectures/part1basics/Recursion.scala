package lectures.part1basics

import scala.annotation.tailrec
import scala.jdk.Accumulator

/**
 * Created by yinhaohe on Feb 18, 2022
 */
object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)

      result
    }

  println(factorial(10))

  def anotherFactorial(n: Int): Int = {
    @tailrec
    def factHelper(x: Int, accumulator: Int): Int =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression

    factHelper(n, 1)
  }

  // WHEN YOU NEED LOOPS, USE TAIL RECURSION

  /*
  Exercises:
  1.  Concatenate a string n times
  2.  IsPrime function tail recursive
  3.  Fibonacci function, tail recursive.
 */

  def concatString(n: Int, s: String): String = {
    @tailrec
    def concatHelper(x: Int, accumulator: String): String =
      if (x <= 0) accumulator
      else concatHelper(x - 1, accumulator + s)

    concatHelper(n, "")
  }

  println(concatString(5, "Hello"))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeHelper(x: Int, accumulator: Int): Boolean =
      if (accumulator > x / 2) true
      else if (x % accumulator == 0) false
      else isPrimeHelper(x, accumulator + 1)

    isPrimeHelper(n, 2)
  }

  println(isPrime(1289327198))

  def isPrime2(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailRec(n / 2, true)
  }

  def fibonacci(n: Int): Int = {
    def fibHelper(x: Int, beforeLast: Int, last: Int): Int =
      if (x >= n) last
      else fibHelper(x + 1, last, last + beforeLast)

    if (n <= 2) 1
    else fibHelper(2, 1, 1)
  }

  println(fibonacci(8))
}
