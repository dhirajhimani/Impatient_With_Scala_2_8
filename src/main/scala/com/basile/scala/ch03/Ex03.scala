package com.basile.scala.ch03

/**
 * Repeat the preceding assignment, but produce a new array with the swapped values. Use for / yield .
 */
object Ex03 extends App {

  def swapAdjacent(a: Array[Int]):Array[Int] =
    (for(i <- 0 until a.length) yield
      if (i%2==0 && (i+1)==a.length) a(i) //last element for odd length
      else if (i%2==0) a(i+1)
      else a(i-1)
    ).toArray


  assert( swapAdjacent(Array(51,42,30,4,25)).deep == Array(42,51,4,30,25).deep )

  assert( swapAdjacent(Array(51,42,30,4)).deep == Array(42,51,4,30).deep )

}
//Alternate
//
//
//def swapAdjacent3[A](arr: Array[A]) = {
//  var l:Int = arr.length - 0
//  for(i <- 0.until(l,1)) yield {
//  if (i % 2 == 0 && i != l-1) {
//  var temp = arr(i)
//  arr(i) = arr(i+1)
//  arr(i+1) = temp
//}
//  arr(i)
//}
//}