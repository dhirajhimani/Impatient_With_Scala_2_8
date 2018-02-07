package com.basile.scala.ch10

// How the trait inheritance works :- Trait construction order
object GoodConcept extends App {

  trait A extends B {
    println("constr A")
    override def logbyMsg: Unit = {
      println("HI its A")
    }
  }

  trait B  {
    println("constr B")
    def logbyMsg: Unit = {
      println("HI its B")
    }
  }

  class C extends B with A {
    println("constr C")

    def this(name:String) {
      this()
      println("constr C with arg")
    }
    //    override def logbyMsg(): Unit = {
    //    println("HI its C")
    //  }
  }

  val c:C = new C("a")
  c.logbyMsg

}
