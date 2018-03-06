package com.basile.scala.ch17

/**
 * Look through the methods of the Iterable[+A] trait.
 * Which methods use the type parameter A ?
 * Why is it in a covariant position in these methods?
 */
object Ex07_1 extends App {
  //
  // A -> B -> C
  //
  class A {
    def doa: String = "doing a"
  }
  class B extends A {
    def dob: String = "doing b"
  }
  class C extends B {
    def doc: String = "doing c"
  }

  val printC: C => Unit = { c => println(c.doc) }
  val printB: B => Unit = { b => println(b.dob) }
  val printA: A => Unit = { a => println(a.doa) }

  def needsB(f: B => Unit, b: B) = f(b)

  needsB(printB, new B)
  needsB(printA, new B) // sub function of needsB(printB, new B)

  //  needsB(printC, new B)// => won't compile, because it would call (new B).doc



}
