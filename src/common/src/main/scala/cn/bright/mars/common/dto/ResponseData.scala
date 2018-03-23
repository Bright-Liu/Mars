package cn.bright.mars.common.dto

import scala.beans.BeanProperty


/**
  * Description:ResponseData
  *
  * @author bright
  * @date 2017/12/28
  */
class ResponseData[T] {
    /**
      * 数据
      */
    @BeanProperty
    var data: T = _

    /**
      * 错误描述
      */
    @BeanProperty
    var description: String = _

    /**
      * 错误码
      */
    @BeanProperty
    var resultCode = ResultStatus.OK

    def this(data: T) {
        this()
        this.data = data
        this.description = null
        this.resultCode = ResultStatus.OK
    }

    def this(data: T, description: String, resultCode: Int) {
        this()
        this.data = data
        this.description = description
        this.resultCode = resultCode
    }

    def this(description: String, resultCode: Int) {
        this()
        this.description = description
        this.resultCode = resultCode
    }

}

object ResultStatus {
    val OK: Int = 200
    val NG: Int = 500
    val PARAM_ERROR: Int = 400
}
