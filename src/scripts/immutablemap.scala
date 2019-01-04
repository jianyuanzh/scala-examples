val romanNum = Map[Int, String](1 -> "I", 2 -> "II",
  3 -> "III", 4 -> "IV", 5 -> "V")

// following will fail because romanNum is a val not var.
//romanNum += (6 -> "VI")

println(romanNum)