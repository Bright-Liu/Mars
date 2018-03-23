package cn.bright.mars.common.dto

/**
  * Description:PageQuery
  *
  * @author bright
  * @date 2017/12/28
  */
class PageQuery[T] {
    /**
      * 数据起始位置
      */
    var index: Int = 0

    /**
      * 每页多少数据
      */
    var pageSize: Int = 20

    var t: T = _

    def this(index: Int, pageSize: Int, t: T) {
        this()
        this.index = index
        this.pageSize = pageSize
        this.t = t
    }

}
