class BitSequence {

  var bits: Array[Int] = null

  def apply(bits: Array[Int]): BitSequence =  {
    this.bits = bits
    new BitSequence()
  }

}