package me.luocaca.model.web.controller;

import me.luocaca.model.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

    @RequestMapping( "/toIndex")
    public ModelAndView index() {
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

}
