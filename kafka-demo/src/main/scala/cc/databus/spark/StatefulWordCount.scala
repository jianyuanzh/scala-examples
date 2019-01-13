package cc.databus.spark

import java.sql.DriverManager

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * 利用UpdateStateByKey统计单词出现的次数 nc -lk 6789
  *
  *  Create table wordCount(word varchar(50) default null, count int(10) default null);
  */
object StatefulWordCount {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("StatefulWordCount").setMaster("local[2]")
    val ssc = new StreamingContext(sparkConf, Seconds(3))

    val lines = ssc.socketTextStream("localhost", 6789)
    ssc.checkpoint(".") // must set if using the stateful calculator. suggest using HDFS directory
    val result = lines.flatMap(_.split(" ")).map((_, 1))

    val state = result.updateStateByKey(update)

    state.print()

    ssc.start()
    ssc.awaitTermination()
  }



  def update(currentVals: Seq[Int], preValues: Option[Int]): Option[Int] = {
    val current = currentVals.sum
    val pre = preValues.getOrElse(0)
    Some(current + pre)
  }
}
