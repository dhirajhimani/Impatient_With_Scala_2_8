package com.basile.scala.ch10

import java.awt.Point

import scala.collection.BitSet

/**
 * Define a class OrderedPoint by mixing scala.math.Ordered[Point] into java.awt.Point .
 *
 * Use lexicographic ordering, i.e. ( x , y ) < ( x ’, y ’) if x < x’ or x = x’ and y < y ’.
 */
object Ex02 extends App {

  class OrderedPoint(x: Int, y: Int) extends Point(x, y) with scala.math.Ordered[Point] {
    def compare(that: Point): Int = {
      ((this.x - that.x).signum, (this.y - that.y).signum) match {
        case (-1,_) | (0,-1) => -1
        case (0, 0) => 0
        case _ => 1
      }
    }


    override val toString = {
      "x:" + x + ", y:" + y
    }

  }


  val op1 = new OrderedPoint(10, 5)
  val op2 = new OrderedPoint(10, 6)
  val op3 = new OrderedPoint(10, 1)
  val op4 = new OrderedPoint(10, 3)
  val op5 = new OrderedPoint(10, 2)

  var list = List(op1,op2,op3,op4,op5)
  list = list.sortWith(_.compareTo(_) > 0)
  println(list)

  assert( op1 < op2 )

}
