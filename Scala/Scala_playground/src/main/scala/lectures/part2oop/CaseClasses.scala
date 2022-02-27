package lectures.part2oop

/**
 * Created by yinhaohe on Feb 27, 2022
 */
object CaseClasses extends App {
  /*
  * equals, hashCode, toString
  * */

  case class Person(name: String, age: Int)

  // 1. class parameters are frelds
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  // println(instance) = println(instance.toString) // syntactic sugar
  println(jim)

  // 3. equals and hashCode implemented Out of the Box
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. Case classes have handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5. Case classes have companion objects
  // it called apply() method, which is constructor in case classes
  val thePerson = Person
  val mary = Person("Mary", 23)

  // 6. Case classes are serializable
  // Akka - actually send case classes through network

  // 7. Case classes extractor patterns = CCs can be used in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "The UK of GB and Ni"
  }

  // exercise: MyList - use case classes and case objects
}
