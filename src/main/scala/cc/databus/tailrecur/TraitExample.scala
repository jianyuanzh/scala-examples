package cc.databus.tailrecur

object TraitExample {

  trait Equal {
    def isEqual(x: Any): Boolean
    def isNotEqual(x: Any): Boolean = !isEqual(x)
  }

  class Point(xc: Int, yc: Int) extends Equal {
    val x = xc
    val y = yc
    override def isEqual(x: Any): Boolean = {
      isPoint(x) && x.asInstanceOf[Point].x == this.x && x.asInstanceOf[Point].y == this.y
    }

    private def isPoint(a: Any): Boolean = {
      a.isInstanceOf[Point]
    }

  def main(args: Array[String]): Unit = {
    val p1 = new Point(1, 2)
    val p2 = new Point(2, 1)
    val p3 = new Point(1, 2)
    println(p1.isEqual(p2))
    println(p1.isEqual(p3))
  }
}
}
