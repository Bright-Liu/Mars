package cn.bright.mars.dal.mapper

import cn.bright.mars.common.dto.PageQuery
import cn.bright.mars.dal.domain.DataInfo
import org.apache.ibatis.annotations.Mapper

/**
  * Description:DataInfoMapper
  *
  * @author bright
  * @date 2017/12/27
  */
@Mapper
trait DataInfoMapper {
    /**
      * 保存数据表信息
      *
      * @param array 数据表信息列表
      * @return 记录数
      */
    def save(array: Array[DataInfo]): Int

    /**
      * 更新数据表信息
      *
      * @param info 数据表信息
      * @return 记录数
      */
    def update(info: DataInfo): Int

    /**
      * 删除风场信息
      *
      * @param info 删除条件
      * @return 记录数
      */
    def delete(info: DataInfo): Int

    /**
      * 根据条件统计符合条件的数据表信息数
      *
      * @param info 检索条件
      * @return 记录数
      */
    def count(info: DataInfo): Int

    /**
      * 根据条件查询数据表列表信息
      *
      * @param info 数据表信息
      * @return 数据表列表信息
      */
    def findAll(info: DataInfo): Array[DataInfo]

    /**
      * 根据条件检索符合条件的数据表列表信息(分页)
      *
      * @param pageQuery 分页检索条件
      * @return 数据表列表（分页）
      */
    def findPagedAll(pageQuery: PageQuery[DataInfo]): Array[DataInfo]

}
