import scala.io.Source

println("Hello")

Source.fromFile("/Users/dhirajkumarh/Documents/Codes/scala/scala_with_impatient/my-akka-http-project/src/main/resources/ch04_ex02.txt").getLines().toList.reverse.foreach(println(_))