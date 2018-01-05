package cn.bright.mars.controller.rest

import cn.bright.mars.common.dto.{Page, ResponseData}
import cn.bright.mars.dal.domain.DataInfo
import cn.bright.mars.service.DataInfoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation
import org.springframework.web.bind.annotation._

/**
  * Description:
  *
  * @author bright
  * @date 2017/12/28
  */
@CrossOrigin
@RequestMapping(value = Array("/test/data"))
@RestController
class DataInfoController {

    @Autowired var dataInfoService: DataInfoService = null

    @annotation.RequestMapping(path = Array("/"), method = Array(RequestMethod.POST))
    def saveDataInfo(info: DataInfo): ResponseData[DataInfo] = {
        dataInfoService.saveDataInfo(info)
    }

    @RequestMapping(path = Array("/"), method = Array(RequestMethod.GET))
    def findPagedAllDataInfo(@RequestParam(value = "creator", required = false) creator: String,
                             @RequestParam(value = "currentPage", defaultValue = "1") currentPage: Int,
                             @RequestParam(value = "pageSize", defaultValue = "20") pageSize: Int): ResponseData[Page[DataInfo]] = {
        dataInfoService.findPagedDataInfo(new DataInfo(creator), currentPage, pageSize)
    }

    @RequestMapping(path = Array("/{id}"), method = Array(RequestMethod.DELETE))
    def deleteDataInfo(@PathVariable(value = "id") id: Long): ResponseData[DataInfo] = {
        dataInfoService.deleteDataInfo(id)
    }
}

