package me.luocaca.model.controller;


import me.luocaca.model.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 欢迎界面
 */
@Controller
public class HelloController {

//    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
//    public String index() {
//        return "login";
//    }


    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String index() {
        return "login";
    }


    @RequestMapping(value = {"/index2131"})
    @ResponseBody
    public String inde11111() {
        return "lobodygin";
    }

    @RequestMapping(value = "/success1", method = RequestMethod.GET)
    public String success1(Map<String, Object> map) {
//        map.put("hello", "<h1>你好</h1>");
//        map.put("users", Arrays.asList("zs", "ls", "ww"));
        return "/success";
    }


    @GetMapping("/query")
    @ResponseBody
    public String map() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM person");
        return list.toString();
    }


/**
 *    @RequestMapping(value = "/success1", method = RequestMethod.GET)
public String success1(Map<String, Object> map) {
map.put("hello", "<h1>你好</h1>");
map.put("users", Arrays.asList("zs", "ls", "ww"));
return "success";
}
 */

}
