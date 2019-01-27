package cc.databus.spark

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object NewBayStatistics extends App {

  def map_extract(elem: (String, String)): Array[(String, String)] = {
    val len = elem._1.length
    val year = elem._1.substring(len - 8, len - 4)
    elem._2.split("\r\n")
      .map((year, _))
  }

  val sparkConf = new SparkConf().setMaster("local[5]").setAppName("NewBayStatistics")
  val sc = new SparkContext(sparkConf)

  val res = sc.wholeTextFiles("/Users/zhangjianyuan/Downloads/ssa-baby-names-social-security-nat/names", 20).flatMap(map_extract).map(el => (el._1, el._2.split(",")(2).toInt)).reduceByKey(_ + _).filter(s => s._1.toInt < 1990).map(s => s._1 -> s._2 * 10).collect()


  Thread.sleep(100000)

}
