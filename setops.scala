import scala.collection.mutable

var immutable = Set("China", "America", "Japan")
println(immutable.getClass)
immutable += "Korea"
println(immutable)
println(immutable.getClass)
// this equals: imutable = imutable + "Thailand"
immutable.+=("Thailand")
println(immutable)
println(immutable.getClass)

val mutableOne = mutable.Set("China", "America", "Japan")

println(mutableOne.getClass)
mutableOne += "Korea"
println(mutableOne)
// this is a method invoking
mutableOne.+=("Thailand")
println(mutableOne)
println(mutableOne.getClass)

