package lectures.part1basics

/**
 * Created by yinhaohe on Feb 17, 2022
 */
object Expressions extends App {

  val x = 1 + 2 // EXPRESSION
  println(x)

  println(2 + 3 * 4)
  // Math expressions:
  // + - * / & | ^ << >> >>> (right shift with zero extension)

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // also works with -= *= /= ...... this are all side effects
  println(aVariable)

  // Instructions(DO) vs Expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3 // IF EXPRESSION
  println(aConditionedValue)
  println(if (aCondition) 5 else 3)

  // NEVER WRITE THIS AGAIN.
  var i = 0
  val aWhile = while (i < 10) {
    println(i)
    i += 1
  }

  // NEVER WRITE THIS AGAIN.

  // Everything in Scala is an Expression!

  val aWeridValue = (aVariable = 3) // Unit === void
  println(aWeridValue)

  // side effects: println(), whiles, reassigning --- returning unit as value

  // Code blocks
  // Code block is an expression

  val aCodeBlock = {

    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"

  }

  // 1. difference between "hello world" vs println("hello world")?
  // A string vs a unit
  // println is also side effect

  // 2.

  val someValue = {
    2 < 3
  }
  println(someValue)
  // A Boolean
  // True

  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }
  println(someOtherValue)
  // 42

}
