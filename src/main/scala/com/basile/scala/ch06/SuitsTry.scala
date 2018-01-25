package com.basile.scala.ch06

import com.basile.scala.ch06.Suits._

object SuitsTry extends App {

  def isRed(cards: Suits) = {
    cards == Suits.hearts || cards == Suits.diamonds
  }

  println(isRed(Suits.diamonds))
}
