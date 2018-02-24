package com.basile.scala.ch15

/**
 * Created by basile.duplessis on 10/01/14.
 */
object Ex07 extends App {

  class Sum {
    // Note final: Its final and that's why doesn't overrides
    final def sumA(s: Seq[Int], partial: BigInt): BigInt =
      if (s.isEmpty)
        partial
      else
        sumA(s.tail, s.head + partial)

    def sumB(s: Seq[Int], partial: BigInt): BigInt =
      if (s.isEmpty)
        partial
      else
        sumB(s.tail, s.head + partial)
  }

  val s = 1 to 1000000

  val sum = new Sum()

  try {
    val resultA = sum.sumA(s, 0)
    println(resultA)
  } catch {
    case exc: StackOverflowError => println("Stack Overflow")
  }

  try {
    val resultB = sum.sumB(s, 0)
    println(resultB)
  } catch {
    case exc: StackOverflowError => println("Stack Overflow")
  }

}
