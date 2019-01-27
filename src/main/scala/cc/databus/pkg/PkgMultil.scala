import com.horstmann.impatient.Employee
package com {
  package horstmann {

    object Utils { // package com.horstman
      def percentageOf(value: Double, rate: Double): Double = value * rate / 100
    }

  }

}

package com {
  package horstmann {
    package impatient { // com.horstmann.impatient, utils是这个包的父包中的类。 用这种非串联的方式，子包中可以访问父包中的类
      class Employee(slry: Double) {
        var salary = slry

        def giveRaise(rate: Double): Double = {
          salary += Utils.percentageOf(salary, rate)
          salary
        }
      }
    }
  }
}

package com.horstmann.impatient {


  class Manager(slry: Double) {
    var salary = slry

    def giveRaise(rate: Double): Double = {
      salary += com.horstmann.Utils.percentageOf(salary, rate) // 这里必须加上com.horstmann.包路径
      salary
    }
  }
}

object PkgMultil {
  def main(args: Array[String]): Unit = {
    val employee = new Employee(12.3)
    val originSalary = employee.salary
    val increasedTo = employee.giveRaise(30)
    println(s"Salary increased from $originSalary to $increasedTo by 30 percentages.")
  }
}