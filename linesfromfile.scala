import scala.io.Source

// scala linesfromfile.scala linesfromfile.scala
if (args.length > 0)  Source.fromFile(args(0)).getLines().foreach(println)
else Console.err.println("linesfromfile <file path>")