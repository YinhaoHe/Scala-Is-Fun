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

- When you need loops, use recursion

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

![03typeInference](README.assets/03typeInference.png)