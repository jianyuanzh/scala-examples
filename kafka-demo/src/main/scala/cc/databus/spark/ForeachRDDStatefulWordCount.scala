package cc.databus.spark

import java.sql.DriverManager

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * 利用UpdateStateByKey统计单词出现的次数 nc -lk 6789
  *
  */
object ForeachRDDStatefulWordCount {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("ForeachRDDStatefulWordCount").setMaster("local[2]")
    val ssc = new StreamingContext(sparkConf, Seconds(3))

    val lines = ssc.socketTextStream("localhost", 6789)
    ssc.checkpoint(".") // must set if using the stateful calculator. suggest using HDFS directory
    val result = lines.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _)
//    result.foreachRDD(rdd => {
//      val connection = createConnection()
//      rdd.foreach { record =>
//        val sql = "insert into wordcount(word, count) values('" + record._1 + "', " + record._2 + ")"
//        connection.createStatement().execute(sql)
//      }
//    })

    result.print()
    result.foreachRDD(rdd => {
      rdd.foreachPartition(partitionWithRecords => {
        val connection = createConnection()
        partitionWithRecords.foreach(record => {
          val sql = "insert into wordcount(word, count) values('" + record._1 + "', " + record._2 + ")"
          connection.createStatement().execute(sql)
          connection.close()
        })
      })
    })


//    state.print() // log to console
    // write result to mysql

    ssc.start()
    ssc.awaitTermination()
  }


  def update(currentVals: Seq[Int], preValues: Option[Int]): Option[Int] = {
    val current = currentVals.sum
    val pre = preValues.getOrElse(0)
    Some(current + pre)
  }


  // should be connection pool
  def createConnection() = {
    Class.forName("com.mysql.jdbc.Driver")
    DriverManager.getConnection("jdbc:mysql://localhost:3306/spark", "root", "root")
  }
}
