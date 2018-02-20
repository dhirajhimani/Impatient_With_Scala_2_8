package com.basile.scala.ch13

import scala.collection.mutable.LinkedList

/**
 * Write a function that removes all zeroes from a linked list of integers.
 */

// 1,x -> 2,x -> 0,x -> 3,x -> 0,x
// Int,x is node where Int is element and x is the next node address

object Ex03 extends App {

  def rmZeroes(l: LinkedList[Int]) {
    l match {
      case LinkedList(0) => {
        l.next = l // override def isEmpty = next eq this
      }
      case LinkedList(0, _*) => {
        l.elem = l.next.elem
        l.next = l.next.next
        rmZeroes(l)
      }
      case LinkedList(_, _*) => {
        rmZeroes(l.next)
      }
      case _ => {
        ()
      }
    }
  }

  val l1 = LinkedList(0,0,1,6,5,0,99,0,8,0)
  rmZeroes(l1)
  assert(l1 == LinkedList(1,6,5,99,8))

  val l2 = LinkedList(0)
  rmZeroes(l2)
  assert(l2 == LinkedList())

}
