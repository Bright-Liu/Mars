package cn.bright.mars.dal.domain

import java.sql.Timestamp

import scala.beans.BeanProperty

/**
  * Description:DataInfo
  *
  * @author bright
  * @date 2017/12/28
  */
class DataInfo {
    @BeanProperty
    var id: Long = _

    @BeanProperty
    var dataName: String = _

    @BeanProperty
    var status: Int = _

    @BeanProperty
    var fieldNumber: Int = _

    @BeanProperty
    var dataSize: Int = _

    @BeanProperty
    var createTime: Timestamp = _

    @BeanProperty
    var creator: String = _

    def this(id: Long) {
        this()
        this.id = id
    }

    def this(creator: String) {
        this()
        this.creator = creator
    }

    def this(dataName: String, creator: String) {
        this()
        this.dataName = dataName
        this.creator = creator
    }
}
