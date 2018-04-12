package com.ibeifeng.sparkproject.test.二次排序

/**
  * Created by wanglei on 2018/4/12.
  * 二次排序
  */
class SortKey(val clickCount: Int, val orderCount: Int, val payCount: Int) extends Ordered[SortKey] with Serializable {


  def compare(that: SortKey): Int = {
    //二次排序这里，clickCount - that.clickCount的顺序应该无关，因为在调用算子SortByKey的时候，要传入正序还是倒序的参数
    //第一个元素的值减去第二个元素的值，
    //如果结果为负数，小的在左边，大的在右边
    if (clickCount - that.clickCount != 0) {
      clickCount - that.clickCount
      //      that.clickCount - clickCount
    } else if (orderCount - that.orderCount != 0) {
      orderCount - that.orderCount
      //      that.orderCount - orderCount
    } else if (payCount - that.payCount != 0) {
      payCount - that.payCount
      //      that.payCount - payCount
    } else {
      0
    }
  }

}
