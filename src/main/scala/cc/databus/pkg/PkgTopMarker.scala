package cc.databus.pkg
package subpkg // 如果顶部写  package cc.databus.pkg.subpkg, 下面没法直接使用TopPkgClass.sayHello，而需要导入

/**
  * Created by yuange.zjy on 2019/1/27.
  */
class PkgTopMarker(name: String) {
  def sayHello : String = TopPkgClass.sayHello(name)
}

object PkgTopMarker{
  def main(args: Array[String]): Unit = {
    println(new PkgTopMarker("Vincent").sayHello)
  }
}
