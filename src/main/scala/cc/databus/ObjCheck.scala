package cc.databus

class ObjCheck(params: List[String]) {
  require(params != null)
  def getDataPoint: String = params.head

  // _这里表示默认值
  var protocol: String = _
  var age: Int = _

}

object ObjCheck {
  def main(args: Array[String]): Unit = {
    val obj = new ObjCheck(List("haha", "other"))
    println(obj.protocol)
    println(obj.age)
    println(obj.getDataPoint)
  }
}
