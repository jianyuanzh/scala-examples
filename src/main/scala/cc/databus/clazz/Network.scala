package cc.databus.clazz

import scala.collection.mutable.ArrayBuffer

/**
  * Created by yuange.zjy on 2019/1/27.
  */
class Network {
  class Member(val name: String) {
    val contacts = new ArrayBuffer[Member]
  }

  private val members = new ArrayBuffer[Member]()

  def join(name: String) = {
    val m = new Member(name)
    members += m
    m
  }
}

object Network {
  def main(args: Array[String]): Unit = {
    val chatter = new Network
    val myFace = new Network

    val fred = chatter.join("Fred")
    val wilma = chatter.join("Wilma")

    fred.contacts += wilma

    val barney = myFace.join("Barney")
    /// fred.contacts += barney  //  不能这样fred的类型是 chatter.Member, barney的类型是myFace.Member
    // 如果想 val barney = myFace.join("Barney")工作，
    // 1. 可以吧Member的定义挪到Network的伴生对象中
    // 2. 可以使用类型投影，将private val members = new ArrayBuffer[Network#Member]()
  }
}
