package me.luocaca.model.controller;

import me.luocaca.model.entity.BigBook;
import me.luocaca.model.entity.Book;
import me.luocaca.model.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@Controller
public class ThymeleafController {

    @RequestMapping("/toThymeleaf")

    public String toThymeleaf(ModelMap map) {
        System.out.println("toThymeleaf....");
        map.addAttribute("host", "http://blog.didispace.com");
        map.addAttribute("msg", "hahhaha");
        map.addAttribute("count", 100);
        map.addAttribute("isEven", true);
        BigBook bigBook = new BigBook("跟着大傻学java", "真开心！………——…");
        map.addAttribute("bigBook", bigBook);

        return "thymeleaf";
    }


}
