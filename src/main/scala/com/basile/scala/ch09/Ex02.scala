package com.basile.scala.ch09

import java.io.{File, PrintWriter}
import java.util.Date

import scala.io.Source

/**
 * Write a Scala program that reads a file with tabs, replaces each tab with spaces so that tab stops are
 * at n -column boundaries, and writes the result to the same file.
 */
object Ex02 extends App {

  println("Ch 9 Question 2 " + "-" * 60)
  val wFile = Ch9Q2Helper.createTempfile
  val tabPattern = """\t""".r
  val readContents = for(line <- Source.fromFile(wFile).getLines.toArray) yield {
    tabPattern.replaceAllIn(line, "    ")
  }

  //println(readContents.mkString("\n"))
  Ch9Q2Helper.writeToFile(wFile, readContents.mkString("\n"))

}

object Ch9Q2Helper{
  def writeToFile(wFile: File, data: String) : Unit = {
    val fileWriter = new PrintWriter(wFile)
    fileWriter.print(data)
    fileWriter.flush
    fileWriter.close
  }

  def createTempfile : File = {
    val testLines  = for(i <- 1 to 10) yield "Line " + i + " \t Tab Start \t Tab End;"
    val now = new Date
    val fileName = "resources/ch9q2-file-%td%tm%ty-tabs.txt".format(now,now,now)
    val wFile = new File(fileName)
    writeToFile(wFile, testLines.mkString("\n") )
    wFile
  }

}
