package com.basile.scala.ch03

/**
 * Given an array of integers, produce a new array that contains all positive values of the original array,
 * in their original order, followed by all values that are zero or negative, in their original order.
 */
object Ex04 extends App {

  def sortPositive(a: Array[Int]) = a.filter( _ > 0 ) ++ a.filter( _ <=0 )

  assert( sortPositive(Array(-2, 8, 0, 4, -8, -1, 0, 9)).deep == Array(8, 4, 9, -2, 0, -8, -1, 0).deep )
}

//def filterPositives(arr: Array[Int]) = {
//  var l = arr.length
//  var count = 0
//  for(i <- 0.until(l,1)) {
//  if (arr(i) > 0) {
//  if (arr(count) <= 0) {
//  var temp = arr(i)
//  arr(i) = arr(count)
//  arr(count) = temp
//}
//  count += 1
//}
//}
//  arr
//}
