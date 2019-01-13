package cc.databus.spark

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * nc -lk 6789
  */
object TransformApp extends App {

  val sparkConf = new SparkConf().setMaster("local[2]").setAppName("TransformApp")
  val ssc = new StreamingContext(sparkConf, Seconds(10))

  /**
    * 构建黑名单
    */
  val blacks = List("zs", "ls")
  val blackRdd = ssc.sparkContext.parallelize(blacks).map(x => (x, true))

  val lines = ssc.socketTextStream("localhost", 6789)
  val clickLog = lines.map(x => (x.split(",")(1), x)).transform(rdd => {
    rdd.leftOuterJoin(blackRdd)
      .filter(x => !x._2._2.getOrElse(false))
      .map(x => x._2._1)
  })

  clickLog.print()

  ssc.start()
  ssc.awaitTermination()
}
