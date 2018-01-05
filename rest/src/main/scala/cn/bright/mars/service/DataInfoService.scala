package cn.bright.mars.service

import cn.bright.mars.common.dto.{Page, ResponseData}
import cn.bright.mars.dal.domain.DataInfo

/**
  * Description:
  *
  * @author bright
  * @date 2017/12/27
  */
trait DataInfoService {
    def saveDataInfo(info: DataInfo): ResponseData[DataInfo] {}

    def deleteDataInfo(id: Long): ResponseData[DataInfo] {}

    def findPagedDataInfo(info: DataInfo, currentPage: Int, pageSize: Int): ResponseData[Page[DataInfo]] {}
}
