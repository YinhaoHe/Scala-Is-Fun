package lectures.part2oop

/**
 * Created by yinhaohe on Feb 27, 2022
 */
object Exceptions extends App {

  val x: String = null
  // println(x.length)
  // this will crash with a NPE

  // 1. throwing exceptions
  // val aWeirdValue: String = throw new NullPointerException

  // throwable classes extend the Throwable class.
  // Exception and Error are the major Throwable subtypes

  // 2. how to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try {
    // code that might fail
    getInt(false)
  } catch {
    case e: NullPointerException => println("caught a Runtim exception")
  } finally {
    // code that will get excuted NO MATTER WHAT
    // optional
    // does not influence the return type of this expression
    // use finally only for side effects --- E.G. log something into files
    println("finally")
  }

  println(potentialFail)

  // 3. how to define your own exceptions
  class MyException extends Exception

  val exception = new MyException

  //  throw exception

  /*
    1.  Crash your program with an OutOfMemoryError
    2.  Crash with SOError
    3.  PocketCalculator
        - add(x,y)
        - subtract(x,y)
        - multiply(x,y)
        - divide(x,y)
        Throw
          - OverflowException if add(x,y) exceeds Int.MAX_VALUE
          - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
          - MathCalculationException for division by 0
   */

  // OOM
  // val array = Array.ofDim(Int.MaxValue)

  // SOError
  def loop: Int = 1 + loop
  // val endlessLoop = loop

  class OverflowException extends RuntimeException

  class UnderflowException extends RuntimeException

  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int) = {
      val result = x + y

      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int) = {
      val result = x - y

      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int) = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }

  // println(PocketCalculator.add(Int.MaxValue, 10))
  // println(PocketCalculator.divide(2, 0))
}
