package cn.bright.mars.common.dto

import scala.beans.BeanProperty

/**
  * Description:Page
  *
  * @author bright
  * @date 2017/12/28
  */
class Page[T] {
    /**
      * 基本属性分析：
      * 1.当前页 currentPage
      * 2.每页多少数据 pageSize
      * 3.数据总条数 totalCount
      * 4.总页数 pageCount
      * 5.数据集合 List<T> list
      */
    @BeanProperty
    var currentPage: Int = 1

    @BeanProperty
    var pageSize: Int = 20

    @BeanProperty
    var totalCount: Int = 0

    @BeanProperty
    var pageCount: Int = 0

    @BeanProperty
    var array: Array[T] = null

    def this(currentPage: Int, pageSize: Int, totalCount: Int, array: Array[T]) {
        this()
        this.currentPage = currentPage
        this.pageSize = pageSize
        this.totalCount = totalCount
        this.array = array
    }

}
