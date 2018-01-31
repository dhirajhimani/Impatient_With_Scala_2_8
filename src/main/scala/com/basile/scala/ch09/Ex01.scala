package com.basile.scala.ch09

import scala.io.Source

/**
 * Write a Scala code snippet that reverses the lines in a file (making the last line the first one, and so on).
 */
object Ex01 extends App {

  val url = getClass.getResource("/ch04_ex02.txt")

  val in = Source.fromURL(url)

  println( in.getLines.toArray.reverse.mkString("\n") )

//  Source.fromFile("/Users/dhirajkumarh/Documents/Codes/scala/scala_with_impatient/my-akka-http-project/src/main/resources/ch04_ex02.txt").getLines().toList.reverse.foreach(println(_))
}


