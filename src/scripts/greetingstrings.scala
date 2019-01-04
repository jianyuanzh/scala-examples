//val greetingstrings = new Array[String](3)
val greetingstrings: Array[String] = new Array[String](3)
greetingstrings(0) = "Hello"
greetingstrings(1) = "world"
greetingstrings(2) = "man"

// ()操作都会被翻译成 .apply(xxx)

// above code equals to
//greetingstrings.update(0, "hello")
//greetingstrings.update(1, "world")
//greetingstrings.update(2, "man")

for (s <- greetingstrings) {
  println(s)
}

println("Using index")
for (i <- 0 to 2) {
  println(greetingstrings(i))
  // above code equals to
//  println(greetingstrings.apply(i))
}

val numbers = Array("One", "Two", "Three", "Four")
// equals to
//val numbers = Array.apply("One", "Two", "Three", "Four")
numbers.foreach(println)