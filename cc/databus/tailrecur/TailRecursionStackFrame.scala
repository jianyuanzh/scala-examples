package cc.databus.tailrecur

import scala.annotation.tailrec

object TailRecursionStackFrame {

@tailrec
def tailRecStackFrame(n: Int): Int =
  if (n == 0) throw new Exception("boom!")
  else tailRecStackFrame(n - 1)

def headRecStackFrame(n: Int): Int =
  if (n == 0) throw new Exception("boom!")
  else n * headRecStackFrame(n - 1)

def main(args: Array[String]): Unit = {
  try {
    tailRecStackFrame(5)
  }
  catch {
    case e: Exception =>
      e.printStackTrace()
  }

  try {
    headRecStackFrame(5)
  }
  catch {
    case e: Exception =>
      e.printStackTrace()
  }
}
}
