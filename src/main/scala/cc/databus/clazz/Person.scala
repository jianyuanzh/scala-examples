package cc.databus.clazz

/**
  * Created by yuange.zjy on 2019/1/27.
  */
abstract class Person {
  val id: Int
  var name: String
}

class Employee(val id: Int) extends Person {
  var name = "" //  父类有子类也必须有
}
