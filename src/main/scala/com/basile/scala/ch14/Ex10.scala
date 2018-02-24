package com.basile.scala.ch14

/**
 * Write a function that composes two functions of type Double => Option[Double] , yielding another function
 * of the same type. The composition should yield None if either function does. For example,
 *
 * def f(x: Double) = if (x >= 0) Some(sqrt(Double)) else None def g(x: Double) = if (x != 1) Some(1 / (x - 1))
 * else None val h = compose(f, g) Then h(2) is Some(1) , and h(1) and h(0) are None .
 */
object Ex10 extends App {

  import scala.math._

  def f(x: Double) = if (x > 0) Some(sqrt(x)) else None
  def g(x: Double) = if (x != 1) Some(1 / (x-1)) else None

  def compose(f1: Double => Option[Double], f2: Double => Option[Double]): Double => Option[Double] =
    (x: Double) => (f1(x), f2(x)) match {
      case (Some(_), r @ Some(_)) => r
      case _ => None
    }

//  def compose(f1: Double => Option[Double], f2: Double => Option[Double]): Double => Option[Double] =
//    (x: Double) => f1(x) match {
//              case Some(x) => f2(x) match {
//                          case Some(x) => Some(x)
//                          case _ => None
//                        }
//              case _ => None
//    }

  val c = compose(f, g)
  println(c(6))
  println(c(5))
  println(c(4))
  println(c(3))
  println(c(2))
  println(c(1))
  println(c(0))

  assert( c(1) == None )

}
