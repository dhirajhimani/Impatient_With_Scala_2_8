package com.basile.scala.ch18

import scala.collection.mutable.ArrayBuffer

/**
 * 4. Implement the equals method for the Member class that is nested inside the Network class in Section 18.2,
 * “ Type Projections ,” on page 247 .
 * For two members to be equal, they need to be in the same network.
 */
object Ex04 extends App {

  class A {
    override def equals(obj:Any):Boolean = {
      true
    }
  }

  class Network {
    class Member(val name: String) {
      val contacts = new ArrayBuffer[Member]

      def equals(that: Member):Boolean = true
    }
    private val members = new ArrayBuffer[Member]

    def join(name: String) = {
      val m = new Member(name)
      members += m
      m
    }
  }

  val NetworkA = new Network
  val NetworkB = new Network

  val Basile = NetworkA.join("Basile")
  val John = NetworkA.join("John")
  val Alfred = NetworkB.join("Alfred")

  assert(Basile.equals(Alfred) == false)
  assert(Basile.equals(John) == true) // here the catch is the Member object are different for both network, when the equals method is called for same Network the overrided method calls up, but for diff n/w the parent equals method is called up.



}
