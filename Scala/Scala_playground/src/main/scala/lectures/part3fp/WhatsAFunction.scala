package lectures.part3fp

/**
 * Created by yinhaohe on Feb 27, 2022
 */
object WhatsAFunction extends App {

  // DREAM: use functions as first class elements
  // problem: JVM is designed for oop --- have to simulate FP

  // A Function-like Class === 长得像一个Function的Class
  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2)) // acts like a function

  // However Scala supports the function types by nature
  // function types = Function1[A, B]
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = ???
  }
}

// This is at most OOP can do, to make it more resuable
trait Action[A, B] {
  def excute(element: A): B = ???
}
// But with Scala, we do this
trait MyFunction[A, B] {
  def apply(element: A) : B
}