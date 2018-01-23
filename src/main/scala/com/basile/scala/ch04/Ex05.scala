package com.basile.scala.ch04

import scala.collection.JavaConversions.mapAsScalaMap
import java.util.{Scanner, TreeMap}
import scala.collection.mutable.Map

/**
 * Repeat the preceding exercise with a java.util.TreeMap that you adapt to the Scala API.
 */
object Ex05 extends App {

  val url = getClass.getResource("/ch04_ex02.txt")

  val words = new Scanner(url.openStream()).useDelimiter("\\W+")

  val tree = new TreeMap[String, Int]()

  while (words.hasNext()) {
    val word = words.next()
    if (tree.contains(word)) tree(word)+=1 else tree(word)=1
  }

  val map: Map[String, Int] = tree

  map.foreach(println)

}

//val in = fromURL(url).mkString.split("\\W+")
//
//val uw = new util.TreeMap[String, Int]()
//
//in.map(s => if (uw.containsKey(s)){uw.put(s, uw.get(s) + 1)} else uw.put(s, 1))
//
//uw
