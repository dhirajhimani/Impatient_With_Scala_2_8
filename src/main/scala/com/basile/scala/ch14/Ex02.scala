package com.basile.scala.ch14

/**
 * Using pattern matching, write a function swap that receives a pair of integers and returns the pair with
 * the components swapped.
 */
object Ex02 extends App {

//  def swap(p: (Int,Int)): (Int, Int) = p match { case (x, y) => (y, x) }
  def swap(p: (Int,Int)): (Int, Int) = (p._2, p._1)

  assert( swap(1, 2) == (2, 1))

}
