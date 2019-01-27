package cc.databus

/**
  * Created by yuange.zjy on 2019/1/27.
  * 包对象可以用来存放一些静态变量和方法，作为工具方法的集合
  */
package object pkg {
  def join(str: String, str2: String, separator: String): String = String.join(separator, str, str2)
}
