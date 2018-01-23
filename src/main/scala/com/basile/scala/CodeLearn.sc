
object Suits extends Enumeration {
  val spades = Value("\u2660")

}
for (c <- Suits.values) println(c.id + " " + c)

