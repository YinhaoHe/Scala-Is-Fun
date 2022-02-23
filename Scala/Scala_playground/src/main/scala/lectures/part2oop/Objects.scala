package lectures.part2oop

/**
 * Created by yinhaohe on Feb 23, 2022
 */
object Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  // Go to see JavaPlayground.java for example in Java

  object Person { // Type + its only instance
    // "static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // Factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }
  class Person(val name: String) {
    // instance-level functionality
  }
  // Companions

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGLETON INSTANCE
  val mary = Person
  val john = Person
  println(mary == john) // True --- one singleton instance

  val person1 = new Person("Mary")
  val person2 = new Person("John")
  println(person1 == person2) // False --- Two different instances

  val bobbie = Person(person1, person2)

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit
}

