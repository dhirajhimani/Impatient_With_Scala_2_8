package com.basile.scala.ch16

import scala.xml.{Elem, Text}

/**
 * Write a function that takes a dl element and turns it into a Map[String, String] .
 * This function should be the inverse of the function in the preceding exercise,
 * provided all dt children are distinct.
 */
object Ex08 extends App {

  def dlToMap(dl: Elem): Map[String, String] = {

    val keys, values = scala.collection.mutable.ArrayBuffer[String]()

    dl.child.foreach{
      n => n match {
        case <dt>{Text(t)}</dt> => keys.append(t)
        case <dd>{Text(t)}</dd> => values.append(t)
        case x => println("No Match " + x.xmlType())
      }
    }

    keys.zip(values).toMap

  }

  val map :Map[String,String] = Map("A" -> "1", "B" -> "2")
  val elem: Elem = Ex07.mapToDl(map)
//  println(elem)
  assert(elem == <dl><dt>A</dt><dd>1</dd><dt>B</dt><dd>2</dd></dl>)
  val map1 = dlToMap(elem)
//  println(map1)
  assert(map1 == map)


}
