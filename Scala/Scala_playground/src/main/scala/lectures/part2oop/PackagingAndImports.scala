package lectures.part2oop

import playground.{ATestClass => AnotherName, PrinceCharming}
import playground._
// The above line of code is actually NOT expression

import java.util.Date
import java.sql.{Date => SqlDate}

/**
 * Created by yinhaohe on Feb 27, 2022
 */
object PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writer = new Writer("Daniel", "RockTheJVM", 2018)

  // if not package members, import the package
  val aTestClass = new AnotherName
  // playground.ATestClass = fully qualified name
  val bTestClass = new playground.ATestClass // also works

  // packages are in hierarchy
  // matching folder structure

  // package object --- universal constants/methods
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceCharming

  // 1. use Fully Qualified names
  val date = new Date
  val sqlDate = new java.sql.Date(2018, 5, 4)

  // 2. use aliasing
  val sqlD = new SqlDate(2018, 5, 4)

  // default imports
  // java.lang --- String, Object, Exception
  // scala --- Int, Nothing, Function
  // scala.Predef --- println, ???

}
