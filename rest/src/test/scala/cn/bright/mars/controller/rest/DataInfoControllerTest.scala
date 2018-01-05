package cn.bright.mars.controller.rest

import java.sql.Timestamp

import cn.bright.mars.common.dto.ResultStatus
import cn.bright.mars.dal.dao.DataInfoDao
import cn.bright.mars.dal.domain.DataInfo
import org.hamcrest.core.Is.is
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.{jsonPath, status}


/**
  * Description:DataInfoController Test
  *
  * @author bright
  * @date 2017/12/28
  */
@RunWith(classOf[SpringRunner])
@SpringBootTest
@AutoConfigureMockMvc
class DataInfoControllerTest {

    @Autowired val mvc: MockMvc = null

    @Autowired val dataInfoDao: DataInfoDao = null

    private val creator: String = "bright_11223344556677889900"
    private val dataName: String = "data_11223344556677889900"

    @Test
    @throws[Exception]
    def testSaveDataInfo(): Unit = {
        this.mvc.perform(MockMvcRequestBuilders.post("/test/data/")
                .param("dataName", dataName)
                .param("status", "1")
                .param("fieldNumber", "10")
                .param("dataSize", "1024")
                .param("createTime", new Timestamp(System.currentTimeMillis()).toString)
                .param("creator", creator)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) //增加断言，正常返回
                .andExpect(jsonPath("resultCode", is(ResultStatus.OK)))
                .andDo(print())
    }

    @Test
    @throws[Exception]
    def testFindPagedAllDataInfo(): Unit = {
        this.mvc.perform(MockMvcRequestBuilders.get("/test/data/")
                .param("creator", creator)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("resultCode", is(ResultStatus.OK)))
                .andDo(print())
    }

    @Test
    @throws[Exception]
    def testDeleteDataInfo(): Unit = {
        val info = dataInfoDao.findOne(new DataInfo(dataName, creator))
        if (null == info)
            return
        this.mvc.perform(MockMvcRequestBuilders.delete("/test/data/" + info.getId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("resultCode", is(ResultStatus.OK)))
                .andDo(print())
    }

}
