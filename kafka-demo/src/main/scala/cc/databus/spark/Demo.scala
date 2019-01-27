package cc.databus.spark

import org.apache.commons.lang.StringEscapeUtils

/**
  * 874  [2019-01-14 15:39:14] ./dp_cmp.sh 2019010111 2019011113  "[\"uct_mobile_abnormal_email\",\"\$eventEmail\"]"
  * 876  [2019-01-14 15:59:22] vim dp_cmp.sh
  * 877  [2019-01-14 15:59:55] ./dp_cmp.sh 2019010111 2019011113  "[\"uct_mobile_abnormal_email\",\"\$eventEmail\"]"
  * 878  [2019-01-14 16:05:35] ./dp_cmp.sh.bak 2019010111 2019011113  "[\"uct_mobile_abnormal_email\",\"\$eventEmail\"]"
  * 879  [2019-01-14 16:12:57] ./dp_cmp.sh.bak 2018120120 2018120121 "[\"uct_credential_location\",\"province\",\"\$cardCertNo\",\"\$userId\"]@[\"uct_credential_location\",\"province\",\"\$realNameNo\",\"\$userId\"]@[\"uct_credential_location\",\"province\",\"\$certificationNo\",\"\$userId\"]"
  * 892  [2019-01-14 17:12:00] ./dp_cmp.sh.bak 2018120120 2018120121 "[\"uct_credential_location\",\"province\",\"\$cardCertNo\",\"\$userId\"]@[\"uct_credential_location\",\"province\",\"\$realNameNo\",\"\$userId\"]@[\"uct_credential_location\",\"province\",\"\$certificationNo\",\"\$userId\"]"
  */
object Demo extends App {
  val protocol = "[\\\"uct_credential_location\\\",\\\"province\\\",\\\"\\$cardCertNo\\\",\\\"\\$userId\\\"]@[\\\"uct_credential_location\\\",\\\"province\\\",\\\"\\$realNameNo\\\",\\\"\\$userId\\\"]@[\\\"uct_credential_location\\\",\\\"province\\\",\\\"\\$certificationNo\\\",\\\"\\$userId\\\"]"
  val dpOrProtocols = StringEscapeUtils.unescapeJava(protocol)
  println(dpOrProtocols)

  val isProtocol = protocol.startsWith("[")
  if (!isProtocol) {
    dpOrProtocols.split("@")
    val dpSet = new java.util.HashSet[String]()



  } else {
    val protocols              = dpOrProtocols.split("@")
    protocols.foreach(println)
  }
}
