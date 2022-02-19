package lectures.part1basics

/**
 * Created by yinhaohe on Feb 17, 2022
 */

object ValuesVariablesTypes extends App {

  val x: Int = 42
  println(x)

  // VALS ARE IMMUTABLE

  // Complier can infer types

  val sString: String = "hello"
  val anotherString = "Goodbye"

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4613
  val aLong: Long = 81293019234909824L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // Variables
  // Can be reassigned
  var aVariable: Int = 4

  aVariable = 5 // side effects
}


