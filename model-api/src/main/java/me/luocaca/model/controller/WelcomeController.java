package me.luocaca.model.controller;


import me.luocaca.model.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/home")
    public String hello() {
        return "hello,Spring Boot";
    }

    @RequestMapping(value = "/home2")
    public String hello2() {
        return "hello,Spring Boot22222";
    }

    /**
     * @RequestMapping("/home") public String getHome() {
     * return "home";
     * }
     */


    @RequestMapping(value = "/hello")
    public String hello1() {
        return "hello";
    }

    @RequestMapping(value = "/students/{id}")
    public String studentList(@PathVariable("id") long id) {
        return personService.queryById(id).toString();
    }


    @RequestMapping(value = "/studentList")
    public String studentAllList() {
        return personService.queryList(Integer.MAX_VALUE, 0).toString();
    }


}
