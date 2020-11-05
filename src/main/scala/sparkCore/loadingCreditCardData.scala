package sparkCore

import org.apache.spark.sql.SparkSession

object loadingCreditCardData {
  def main(args: Array[String]): Unit = {
    val master=args(0)
    val inputPath=args(1)
    val spark=SparkSession
      .builder()
      .master(master)
      .appName("Loading of credit card transaction data")
      .getOrCreate()
    val transactionRdd=spark.sparkContext.textFile(inputPath)
    val result=transactionRdd.collect().toList
    result.take(10).foreach(println)
  }




}
