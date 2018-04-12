package com.ibeifeng.sparkproject.test.二次排序

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by wanglei on 2018/4/12.
  * 测试二次排序
  */
object SortKeyTest {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("SortKey").setMaster("local")
    val sparkContext = new SparkContext(sparkConf)

    val arr = Array(Tuple2(new SortKey(30, 40, 50), "1"),
      Tuple2(new SortKey(35, 45, 55), "2"),
      Tuple2(new SortKey(35, 45, 50), "3"))

    val rdd = sparkContext.parallelize(arr, 1)

    //sortBykey传入的第一个参数讲的是倒序排序或者是正序排序,默认是正序排序
    val sortedRDD = rdd.sortByKey(false)

    //collect返回的是一个数组
    for (tuple <- sortedRDD.collect()) {
      println(tuple._2)
    }

    //foreach遍历的是一个RDD，本质是一个RDD的算子
    sortedRDD.foreach(tuple => {
      println(tuple._1.clickCount)
      println(tuple._1.orderCount)
      println(tuple._1.payCount)
      println(tuple._2)
    })


  }

}
