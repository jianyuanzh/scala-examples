package cc.databus.clazz

import cc.databus.clazz.Network2.Member

import scala.collection.mutable.ArrayBuffer

/**
  * Created by yuange.zjy on 2019/1/27.
  */
class Network2 {
  val members = new ArrayBuffer[Member]()

  def join(name: String): Member = {
    val m = new Member(name)
    members += m
    m
  }
}

object Network2 {
  class Member(name: String) {
    val contacts = new ArrayBuffer[Member]()
  }

  def main(args: Array[String]): Unit = {
    val vincent = new Network2
    val jianyuan = new Network2

    val fred = vincent.join("Fred")
    val fangfang = vincent.join("Fangfang")

    fred.contacts += fangfang

    val defang = jianyuan.join("Defang")
    fred.contacts += defang // this is ok
  }
}
