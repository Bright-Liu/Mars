package cn.bright.mars.controller

import cn.bright.mars.dal.dao.DataInfoDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.{CrossOrigin, RequestMapping, RequestParam}

/**
  * Description:
  *
  * @author bright
  * @date 2017/12/27
  */
@Controller
@CrossOrigin
@RequestMapping(value = Array("/test"))
class TestController {

    @RequestMapping(path = Array("/greeting"))
    def greeting(@RequestParam(value = "name", required = false, defaultValue = "Jack") name: String, model: Model): String = {
        model.addAttribute("name", name)
        "greeting"
    }
}
