## Scala

![](./README.assets/meme.png)

### Values Variables Types

![01part1basic](README.assets/01part1basic.png)

- `val` - immutable, cannot change vals

  - ```scala
    val x: Int = 12
    // x cannot be reassigned since x is a VAL
    ```

- `val` type is optional, complier can inder types

  - ```scala
    val x = 42
    ```

- `;` semicolumn is optional. Encouraged not to write `;` and write code on seperate lines

- `var` - mutable, can be re-assigned

- A variable is called **side effect**

### Expressions

![image-20220217204149552](README.assets/02expressions.png)

- Everything in Scala is an **Expression** NOT an Instruction

- Imperative programming (命令式编程): Java/Python/C

  - **NEVER** write imperative code in Scala

- `if` acts significantly different than other languages

  - if in Scala is an **Expression**, and it returns a value

  - Python/JS, we gave instructions let PC do something, but here in Scala or FP, we gave expressions, example below

```scala
// IF expression
val aCondition = true
val aConditionedValue = if(aCondition) 5 else 3 // IF EXPRESSION
println(aConditionedValue)
println(if(aCondition) 5 else 3)
```

- Loop exists in Scala but we do not encourage using them

  - Loop only excutes side effects but not returning values

- ```scala
  val aWeridValue = (aVariable = 3) // Unit === void
  ```

  - `aWeirdValue` is type of `unit`
  - Any side effects in Scala are actually expressions returning unit as value
  - side effects: println(), whiles, reassigning --- returning unit as value

- Code blocks:

  - Code blocks are expressions

    - And the value of the code block is the LAST expression of the code block

    - So the below example, this code block's value is if expression's value

    - ```scala
        val aCodeBlock = {
      
          val y = 2
          val z = y + 1
      
          if(z > 2) "hello" else "goodbye"
      
        }
      ```

  - Whatever in the code block is only visible inside the code block

- DO NOT USE WHILE LOOPS in Scala

### Functions

- Syntax:

  - ```scala
      def aFunction(a: String, b: Int): String = {
        a + " " + b
      }
    ```

- When you need loops, use **TAIL** recursion

  - ```scala
      def aRepeatedFunction(aString: String, n: Int): String = {
        if (n == 1) aString
        else aString + aRepeatedFunction(aString, n-1)
      }
    ```

- Can use auxiliary function to determine return type of the parent/outer function

  - ```scala
    def aBigFunction(n: Int): Int = {
      def aSmallerFunction(a: Int, b: Int) = a + b
    
      // Can use auxiliary function to determine return type of the parent/outer function
      aSmallerFunction(n, n - 1)
    }
    ```

### Type Inference

- Most of the time, complier can figure out the type on its own

  - ![03typeInference](README.assets/03typeInference.png)

  - ![image-20220218194243132](README.assets/image-20220218194243132.png)

- Recursive functions need to be specified Typed, complier won't infer types
  - ![image-20220218195056516](README.assets/image-20220218195056516.png)

### Recursion

- Tail Recursion

- TAIL RECURSION = use recursive call as the LAST expression

- use `@tailrec` in the function that has recursion, so the IDE will error if didn't use it as Tail Recursion

  - Two examples below to show how to make big recursion work in Scala

    - This one won't work - StackOverFlow

    ```scala
    def factorial(n: Int): Int =
      if (n <= 1) 1
      else {
        val result = n * factorial(n-1)
        result
      }
    ```

    - But this one works:

      ```scala
      def anotherFactorial(n: Int): Int = {
        def factHelper(x: Int, accumulator: Int): Int =
          if (x <= 1) accumulator
          else factHelper(x - 1, x * accumulator)
      
        factHelper(n, 1)
      }
      ```

  - The second one, we write the `factHelper()` function call at the very last expression of this code path, so Scala will preserve the call stack for this function, so it doesn't consume a lot memory

- AGAIN, when you need loops, USE TAIL RECURSION

- **Rule of thumb: The number of recursions you want is the number of accumulators you need in the tailRec function**

### Call-by-Name and Call-by-Value

![image-20220219185753256](README.assets/image-20220219185753256.png)

- Call by Value`:` - computer will evaluate the value first and throw that into the function
- Call by Name`=>`  - computer throw the literal into function, the literal got evaluated when it is called in the code path

```scala
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

// by value: 589136232950764
// by value: 589136232950764
// by name: 589136300788968
// by name: 589136301563084
```

```scala
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

 calledByValue(System.nanoTime())
```

Equals

```scala
  def calledByValue(x: Long): Unit = {
    println("by value: " + 589136232950764L)
    println("by value: " + 589136232950764L)
  }

 calledByValue(589136232950764L)
```

---

However,

```scala
  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }
  
  calledByName(System.nanoTime())
```

Equals

```scala
  def calledByName(x: => Long): Unit = {
    println("by name: " + System.nanoTime())
    println("by name: " + System.nanoTime())
  }
  
  calledByName(System.nanoTime())
```

### Default and Named Arguments

![image-20220221002913251](README.assets/image-20220221002913251.png)

- Syntax

```scala
def trFact(n: Int, acc: Int = 1): Int =
  if (n <= 1) acc
  else trFact(n - 1, n * acc)
```

### Smart Operations on Strings

- From Java

  - ```scala
      // From Java
      println(str.charAt(2))
      println(str.substring(7, 11))
      println(str.split(" ").toList)
      println(str.startsWith("Hello"))
      println(str.replace(" ", "-"))
      println(str.toLowerCase())
      println(str.toUpperCase())
      println(str.length())
    ```

- Only in Scala

  - ```scala
      // Only in Scala
      val aNumberString = "45"
      val aNumber = aNumberString.toInt
      println('a' +: aNumberString :+ 'z') // prepending and appending
      println(str.reverse)
      println(str.take(2))
    ```

- Scala Intepolators

  - ```scala
      // S-interpolators
      val name = "David"
      val age = 12
      val greeting = s"Hello, my name is $name and I am $age years old"
      val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old"
      println(anotherGreeting)
    
      // F-interpolators
      val speed = 1.2f
      val myth = f"$name can eat $speed%2.2f burgers per minutes"
      println(myth)
    ```

  - ![image-20220221005714060](README.assets/image-20220221005714060.png)

- raw interpolators

  - ```scala
      // raw-interpolator
      println(raw"This is a \n newline")
      val escaped = "This is a \n newline"
      println(raw"$escaped")
    
    
    This is a \n newline
    This is a 
     newline
    ```

  - `\` escape character will not be escaped in `raw"this is \n a new line"`

  - but it will be escaped when works with injected value like `raw"$escaped"`

### OO Basics

![image-20220221225057664](README.assets/image-20220221225057664.png)

- constructor can print `person.age`

  - ```scala
    class Person (name: String, val age: Int) // 
    ```

- cannot print `person.age`

  - ```scala
    class Person (name: String, age: Int)
    ```

- Need to add a `var` or `val` to the parameters, to let it be fields

- Field - values in a class

  - ```scala
    val x = 2 // Field
    ```

- Methods - functions in a class

  - ```scala
    // method
    def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
    ```

- Overloading

  - ```scala
    // overloading
    def greet(): Unit = println(s"Hi, I am $name") // if no parameter, same as this.name
    ```

- Multiple constructors

  - ```scala
    // multiple constructors
    def this(name: String) = this(name, 0)
    def this() = this("John Doe")
    ```

- **Object Immutability** - whenever you make changes to an object, you create a new object instance.

### Syntactic Sugar Method Notations

![image-20220223015618045](README.assets/image-20220223015618045.png)

```scala
class Person(val name: String, favouriteMovie: String) {
  def likes(movie: String): Boolean = movie == favouriteMovie
  def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
}
```

- When only one parameter for a method - `def likes(movie: String)`

  - ```scala
    val mary = new Person("Mary", "Inception")
    println(mary.likes("Inception"))
    println(mary likes "Inception") // equivalent
    // infix notation = operator notation
    ```

- In-fix notation, ALL operators are methods!!! 

  - Can define a method's name as a "+" plus sign, which is allowed in Scala

  - ```scala
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    ```

  - The method actually works like an "Operator" in below example

  - ```scala
    // "operators" in Scala
    val tom = new Person("Tom", "Fight Club")
    println(mary + tom)
    println(mary.+(tom))
    ```

  -  Another good example would be plus operator is also a METHOD

  - ```scala
    println(1 + 2)
    println(1.+(2))
    ```

- Prefix notation

  - unary prefix

    ```scala
    val x = -1 // equivalent with 1.unary_-
    val y = 1.unary_-
    ```

  - **unary_prefix only works with - + ~ !**

- Postfix notation

  - Only availible for methods without parameters

  - ```scala
    // Postfix notation
    println(mary.isAlive)
    println(mary isAlive)
    ```

- `def apply()`

  - When you see an object gets called like a function, Scala will go into that object and look for a method call `apply` - example below

  - Can call `mary()` like a function

  - ```scala
    class Person(val name: String, favouriteMovie: String) {
      def likes(movie: String): Boolean = movie == favouriteMovie
      def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
      def unary_! : String = s"${name}, what the heck!?"
      def isAlive : Boolean = true
      def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"
    }
    
    
      // apply
      println(mary.apply())
      println(mary())
    ```

  - This is super dope.