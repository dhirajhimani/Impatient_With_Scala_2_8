def adjustToPair(fun: (Int,Int) => Int)(t: (Int,Int)) = {
  fun(t._1, t._2)
}

adjustToPair(_*_)((6,7))

((1 to 10) zip (11 to 20)).map(x => adjustToPair((a,b) => a*b)(x))