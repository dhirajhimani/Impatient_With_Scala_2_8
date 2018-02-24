val lines = List("asdf", "zxcv")

val temp = "asdf";
temp.scanLeft(temp)((t,x)=> {println(x); t.tail + t.head})



println(lines.map(
  x => x.scanLeft(x)(
    (t,_)=>t.tail + t.head).drop(1).mkString(" "))
  .mkString("\n"))