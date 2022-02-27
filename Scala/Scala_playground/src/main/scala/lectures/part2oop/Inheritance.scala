package lectures.part2oop

/**
 * Created by yinhaohe on Feb 23, 2022
 */
object Inheritance extends App {

  // signle class inheritance --- can only inherits one class at a time
  class Animal {
    val creatureType = "wide"
    def eat = println("nomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch


  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
    // override val creatureType: String = "domestic"
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
  }

  // Or
  class Dog1(dogType: String) extends Animal {
    override val creatureType: String = dogType
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // Type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // OverRIDING vs overLOADING

  // Super

  // preventing overrides
  // use final
}
