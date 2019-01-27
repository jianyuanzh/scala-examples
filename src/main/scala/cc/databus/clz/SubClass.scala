package cc.databus.clz

/**
  * Created by yuange.zjy on 2019/1/27.
  */

class Person(nm: String) {
  val name = nm
  override def toString: String = "I'm " + name + "!"
}

class Employee(nm: String) extends Person(nm) {
  override val name: String = "Secret"

  override def toString: String = "I'm " + name + "!"

  def meet(p: Person{def greeting: String}): Unit = {
    println(s"${p.name} says ${p.greeting}")
  }
}

object SubClass {
  def main(args: Array[String]): Unit = {
    val person = new Person("Vincent")
    println(person)

    val employee = new Employee("Gary")
    println(employee)

    val alien = new Person("Fred") {
      def greeting = "Grettings, Erthling! My name is Fred."
    }

    employee.meet(alien)
  }
}