package com.basile.scala.ch15

/**
  * Created by basile.duplessis on 10/01/14.
  */
object Ex06 extends App {

  //@volatile var status = false
  //  var status = false
  //
  //  new Thread {
  //    override def run() {
  //      Thread.sleep(200)
  //      status = true
  //      println("## Status field to true")
  //    }
  //  }.start()
  //
  //  new Thread {
  //    override def run() {
  //      while (!status) {
  //       println("Status field is false")
  //       Thread.sleep(10)
  //      }
  //      println("Status field is true")
  //    }
  //  }.start()

  // Good Example https://dzone.com/articles/java-volatile-keyword-0

  @volatile var MY_INT = 0
//    var MY_INT = 0

  new Thread {
    override def run(): Unit = {
      var local_value = MY_INT
      while (local_value < 5) {
        if (local_value != MY_INT) {
          println(s"Got Change for MY_INT : ${MY_INT}")
          local_value = MY_INT
        }
      }
    }
  }.start()

  new Thread {
    override def run(): Unit = {
      var local_value = MY_INT
      while (MY_INT < 5) {
        local_value = local_value + 1;
        println(s"Incrementing MY_INT to ${local_value}")
        MY_INT = local_value

        try
          Thread.sleep(500)
        catch {
          case e: InterruptedException =>
            e.printStackTrace()
        }
      }
    }
  }.start()

}
