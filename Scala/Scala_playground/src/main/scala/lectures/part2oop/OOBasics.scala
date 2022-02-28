package lectures.part2oop

import scala.annotation.tailrec

/**
 * Created by yinhaohe on Feb 21, 2022
 */
object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.age)
  person.greet("Daniel")

  val author = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectation", 1861, author)

  println(novel.getAuthorAge())

  val counter = new Counter()
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print
}

// constructor
class Person(name: String, val age: Int = 0) {
  // body
  val x = 2 // Field

  println(1 + 3)

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name") // if no parameter, same as this.name

  // multiple constructors
  def this(name: String) = this(name, 0)

  def this() = this("John Doe")
}

// class parameters are NOT FIELDS


/*
  Novel and a Writer
  Writer: first name, surname, year
    - method fullname
  Novel: name, year of release, author
  - authorAge
  - isWrittenBy(author)
  - copy (new year of release) = new instance of Novel
 */

class Writer(val firstName: String, val surName: String, val year: Int) {
  def getFullName(): String = s"$firstName $surName"
}

class Novel(val name: String, val year: Int, val author: Writer) {
  def getAuthorAge(): Int = year - author.year

  def isWritterBy(author: Writer): Boolean = author == this.author

  def copy(newYear: Int): Novel = new Novel(this.name, newYear, this.author)
}

/*
  Counter class
    - receives an int value
    - method current count
    - method to increment/decrement => new Counter
    - overload inc/dec to receive an amount
 */

class Counter(val count: Int = 0) {
  def inc = {
    println("Incrementing")
    new Counter(count + 1) // immutability
  }

  def dec = {
    println("Decrementing")
    new Counter(count - 1)
  }

  //  def inc(n: Int) = new Counter(count + n)
  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }

  //  def dec(n: Int) = new Counter(count - n)
  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }

  def print = println(count)
}
