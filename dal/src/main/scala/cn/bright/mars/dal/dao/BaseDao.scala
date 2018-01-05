package cn.bright.mars.dal.dao

import cn.bright.mars.common.dto.PageQuery

/**
  * Description:BaseDao
  *
  * @author bright
  * @date 2017/12/28
  */
trait BaseDao[T] {
    /**
      * 保存单条记录
      *
      * @param t 单条记录
      * @return true:成功 false;失败
      */
    def saveOne(t: T): Boolean

    /**
      * 保存多条记录
      *
      * @param array 多条记录
      * @return 记录数
      */
    def save(array: Array[T]): Int

    /**
      * 更新
      *
      * @param t 更新条件
      * @return 记录数
      */
    def update(t: T): Int

    /**
      * 删除
      *
      * @param t 删除条件
      * @return 记录数
      */
    def delete(t: T): Int

    /**
      * 根据ID删除单条记录
      *
      * @param id ID
      * @return true:成功 false:失败
      */
    def deleteById(id: Long): Boolean

    /**
      * 根据检索条件统计符合条件的记录数
      *
      * @param t 检索条件
      * @return 记录数
      */
    def count(t: T): Int

    /**
      * 根据检索条件查询单条记录
      *
      * @param t 检索条件
      * @return 单条记录
      */
    def findOne(t: T): T

    /**
      * 根据检索条件查询多条记录
      *
      * @param t 检索条件
      * @return 多条记录
      */
    def findAll(t: T): Array[T]

    /**
      * 根据检索条件检索符合条件的多条记录(分页)
      *
      * @param pageQuery 分页检索条件
      * @return 多条记录（分页）
      */
    def findPagedAll(pageQuery: PageQuery[T]): Array[T]
}
