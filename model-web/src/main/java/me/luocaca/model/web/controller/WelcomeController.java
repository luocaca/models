package me.luocaca.model.web.controller;

import me.luocaca.model.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
public class WelcomeController {

    @RequestMapping("/toIndexJsp")
    public ModelAndView index() {
        return new ModelAndView("jsp/index");
    }

    @RequestMapping("/toIndexThy")
    public ModelAndView indexTh() {
        return new ModelAndView("index");
    }


    @RequestMapping(value = "/hello")
    @ResponseBody
    public String sayMoany() {
        DateUtil.printCurrentDateTime();
        DateUtil.printCurrentDateTime();
        DateUtil.printCurrentDateTime();
        DateUtil.printCurrentDateTime();
        return "200 块不用找";
    }

    @RequestMapping(value = "/hellopost", method = RequestMethod.POST)
    @ResponseBody
    public String hellopost() {
        DateUtil.printCurrentDateTime();
        DateUtil.printCurrentDateTime();
        DateUtil.printCurrentDateTime();
        DateUtil.printCurrentDateTime();
        return "200 块不用找hellopost";
    }


    @PostMapping("/loginPost")
    @ResponseBody
    public Map<String, Object> loginPost(String userName, String password, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        if (!"123456".equals(password)) {
            map.put("success", false);
            map.put("message", "密码错误");
            return map;
        }

        // 设置session
        session.setAttribute("loginUser", userName);

        map.put("success", true);
        map.put("message", "登录成功");
        return map;
    }

}
