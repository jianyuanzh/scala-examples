package cc.databus.tailrecur

object NonTailRecursionExample {
  val fun = funcValRecursion _
  def funcValRecursion(a: Int): Int =
    if(a == 0) throw new Exception("Boom!")
    else fun(a - 1)  // 函数值调用


  def anotherFunc(a: Int): Int =
    nestFunRecursion(a)

  def nestFunRecursion(a: Int): Int =
    if (a == 0) throw new Exception("Boom!")
    else anotherFunc(a - 1)

  def main(args: Array[String]): Unit = {
    try {
      funcValRecursion(3)
    }
    catch {
      case e: Exception => e.printStackTrace()
    }
    try {
      nestFunRecursion(3)
    }
    catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
