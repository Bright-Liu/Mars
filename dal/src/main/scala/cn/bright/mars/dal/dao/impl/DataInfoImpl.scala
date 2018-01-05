package cn.bright.mars.dal.dao.impl

import cn.bright.mars.common.dto.PageQuery
import cn.bright.mars.dal.dao.DataInfoDao
import cn.bright.mars.dal.domain.DataInfo
import cn.bright.mars.dal.mapper.DataInfoMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

/**
  * Description:DataInfoImpl
  *
  * @author bright
  * @date 2017/12/28
  */
@Repository
class DataInfoImpl extends DataInfoDao {

    @Autowired var dataInfoMapper: DataInfoMapper = null

    /**
      * 保存单个数据表信息
      *
      * @param info 数据表信息
      * @return true:成功 false;失败
      */
    override def saveOne(info: DataInfo): Boolean = {
        return save(Array(info)) == 1
    }

    /**
      * 保存数据表信息
      *
      * @param array 数据表信息列表
      * @return 记录数
      */
    override def save(array: Array[DataInfo]): Int = {
        return dataInfoMapper.save(array)
    }

    /**
      * 更新数据表信息
      *
      * @param info 数据表信息
      * @return 记录数
      */
    override def update(info: DataInfo): Int = {
        return dataInfoMapper.update(info)
    }

    /**
      * 删除数据表信息
      *
      * @param info 删除条件
      * @return 记录数
      */
    override def delete(info: DataInfo): Int = {
        return dataInfoMapper.delete(info)
    }

    /**
      * 根据ID删除数据表信息
      *
      * @param id 数据表ID
      * @return true:成功 false:失败
      */
    override def deleteById(id: Long): Boolean = {
        return dataInfoMapper.delete(new DataInfo(id)) == 1
    }

    /**
      * 根据条件统计符合条件的数据表信息数
      *
      * @param info 检索条件
      * @return 记录数
      */
    override def count(info: DataInfo): Int = {
        return dataInfoMapper.count(info)
    }

    /**
      * 根据条件查询单个数据表信息
      *
      * @param info 条件
      * @return 单个数据表信息
      */
    override def findOne(info: DataInfo): DataInfo = {
        val array = dataInfoMapper.findAll(info)
        if (null == array || array.length != 1) {
            return null
        }
        return array(0)
    }

    /**
      * 根据条件查询数据表信息列表
      *
      * @param info 数据表信息
      * @return 数据表列表信息
      */
    override def findAll(info: DataInfo): Array[DataInfo] = {
        return dataInfoMapper.findAll(info)
    }

    /**
      * 根据条件检索符合条件的数据表信息列表(分页)
      *
      * @param pageQuery 分页检索条件
      * @return 数据表信息列表（分页）
      */
    override def findPagedAll(pageQuery: PageQuery[DataInfo]): Array[DataInfo] = {
        return dataInfoMapper.findPagedAll(pageQuery)
    }
}
