package cc.databus.spark

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * 使用spark streaming处理文件系统的数据
  */
object FileWordCount {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local").setAppName("FileWordCount")
    val sc = new StreamingContext(sparkConf, Seconds(3))

    val lines = sc.textFileStream("file:///Users/zhangjianyuan/testsource")
    val result = lines.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _)

    result.print()


    sc.start()
    sc.awaitTermination()
  }
}
