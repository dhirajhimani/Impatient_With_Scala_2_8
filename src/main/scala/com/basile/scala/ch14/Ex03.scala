package com.basile.scala.ch14

/**
 * Using pattern matching, write a function swap that swaps the first two elements of an array provided
 * its length is at least two.
 */
object Ex03 extends App {

  def swap(a: Array[Int]) = {
//    println(a.isDefinedAt(0))
    a match {
            case Array(a) => Array(a)
      //      case Array(a, b) => Array(b, a)
      case Array(a, b, end@_*) => Array(b, a) ++ end
      //      case Array(a, b, end @ _*) => Array(b, a, end)
    }

  }

  println(swap(Array(1)).mkString(" "))
  println(swap(Array(1,2)).mkString(" "))
  println(swap(Array(1,2,3,4)).mkString(" "))
//  assert( swap(Array(1,2,3,4)).deep == Array(2,1,3,4).deep )

}
