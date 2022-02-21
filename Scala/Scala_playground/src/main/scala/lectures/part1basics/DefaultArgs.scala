package lectures.part1basics

import scala.annotation.tailrec

/**
 * Created by yinhaohe on Feb 19, 2022
 */
object DefaultArgs extends App {

  @tailrec
  def trFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n - 1, n * acc)

  val fact10 = trFact(10, 2)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")

  savePicture()
  // savePicture(800) - when only one parameter, complier will be confused
  savePicture(width = 800) // this time it will just fine

  /*
  * 1. pass in every leading argument
    2. Name the arguments
  * */

  // when name the paramenters, we can even pass in the parameters in different order
  savePicture(height = 600, width = 800, format = "bmp")
}
