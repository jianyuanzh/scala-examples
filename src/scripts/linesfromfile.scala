import scala.io.Source

// scala linesfromfile.scala linesfromfile.scala
//if (args.length > 0)
//  Source.fromFile(args(0)).getLines().foreach(println)
//else
//  Console.err.println("linesfromfile <file path>")

if (args.length > 0) {
  val lines =  Source.fromFile(args(0)).getLines().toList
  val longestLine = lines.reduceLeft((a, b) => longerStr(a, b))
  val maxWidth = widthOfLength(longestLine)
  for (elem <- lines) {
    val paddingCount = maxWidth - widthOfLength(elem)
    val padding = " " * paddingCount + elem.length
    println(padding + "|" + elem)
  }
}
else Console.err.println("linesfromfile <filepath>")

def longerStr(a: String, b: String) = if (a.length > b.length) a else b

def widthOfLength(s: String) = s.length.toString.length