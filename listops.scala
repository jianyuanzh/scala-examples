val onetwo = List(1, 2)
val threefour = List(3, 4)
val onetwothreefour = onetwo ::: threefour
// ::: 是threefour的右操作符

println(onetwo + " and " + threefour + " are immutable")
println("Thus, " + onetwothreefour + " is new list")

// :: join elements

val oneToThree = 1 :: 2 :: 3 :: Nil
println(oneToThree)
val zeroToThree = 0 :: oneToThree
println(zeroToThree)

zeroToThree.init