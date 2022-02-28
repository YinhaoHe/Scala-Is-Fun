package lectures.part2oop

/**
 * Created by yinhaohe on Feb 25, 2022
 */
object Generics extends App {

  class MyList[+A] {
    // use the type A inside the class defination
    def add[B >: A](element: B): MyList[B] = ???
    /*
      A = Cat
      B = Animal
    * */
  }

  class MyMap[Key, Value]

  val lisfOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = new MyList[A]
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal

  class Cat extends Animal

  class Dog extends Animal

  // Question: if Cat extends Animal, does list of Cats extend Animal?
  // 1. Yes List[Cat] extends List[Animal] = Co-variance
  class CovariantList[+A]

  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? HARD QUESTION => We return a list of Animals

  // 2. No = Invariance
  class InvarianceList[A]

  // Can only put the animal Type into the list
  val invariantAnimalList: InvarianceList[Animal] = new InvarianceList[Animal]

  // 3. Hell, no! Contravariance
  class Trainer[-A]

  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage[A <: Animal](animal: A) // class Cage only allows types that are subtypes of Animal

  val cage = new Cage(new Dog)

  class Car
  // generic types needs proper bounded types
  //  val newCage = new Cage(new Car)

  // expand MyList to be generic

}
