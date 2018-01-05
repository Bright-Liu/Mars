package cn.bright.mars.service.impl

import cn.bright.mars.common.dto.{Page, PageQuery, ResponseData, ResultStatus}
import cn.bright.mars.dal.dao.DataInfoDao
import cn.bright.mars.dal.domain.DataInfo
import cn.bright.mars.service.DataInfoService
import org.apache.commons.lang.StringUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
  * Description:
  *
  * @author bright
  * @date 2017/12/28
  */
@Service
class DataInfoServiceImpl extends DataInfoService {
    @Autowired var dataInfoDao: DataInfoDao = null;

    override def findPagedDataInfo(info: DataInfo, currentPage: Int, pageSize: Int): ResponseData[Page[DataInfo]] = {
        val index = (currentPage - 1) * pageSize
        val totalCount = dataInfoDao.count(info)
        val array = dataInfoDao.findPagedAll(new PageQuery[DataInfo](index, pageSize, info))
        val page = new Page(currentPage, pageSize, totalCount, array)
        return new ResponseData[Page[DataInfo]](page)
    }

    override def saveDataInfo(info: DataInfo): ResponseData[DataInfo] = {
        if (null == info || StringUtils.isBlank(info.getDataName) || StringUtils.isBlank(info.getCreator)) {
            return new ResponseData[DataInfo]("数据表信息不能为空！", ResultStatus.PARAM_ERROR)
        }

        val oInfo = dataInfoDao.findOne(info)
        if (null == oInfo) {
            if (dataInfoDao.saveOne(info)) {
                return new ResponseData[DataInfo]("新建数据表信息成功！", ResultStatus.OK)
            } else {
                return new ResponseData[DataInfo]("新建数据表信息失败！", ResultStatus.NG)
            }
        } else {
            if (StringUtils.isNotBlank(info.getDataName)) {
                oInfo.setDataName(info.getDataName)
            }

            if (dataInfoDao.update(oInfo) == 1) {
                return new ResponseData[DataInfo]("更新数据表信息成功！", ResultStatus.OK)
            } else {
                return new ResponseData[DataInfo]("更新数据表信息失败!", ResultStatus.NG)
            }
        }
    }

    override def deleteDataInfo(id: Long): ResponseData[DataInfo] = {
        if (dataInfoDao.deleteById(id)) {
            return new ResponseData[DataInfo]("删除数据表信息成功！", ResultStatus.OK)
        }
        return new ResponseData[DataInfo]("删除数据表信息失败！", ResultStatus.NG)
    }
}
