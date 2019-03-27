package me.luocaca.model.controller;

import com.google.gson.Gson;
import me.luocaca.model.entity.JaneItem;
import me.luocaca.model.util.testApi;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator
 */
@Controller
@RequestMapping(value = "/jane")
public class JanebookController {


    @RequestMapping(value = "/entries")
    @ResponseBody
    public String getEntries(@RequestParam("keyWord") String keyWord, @RequestParam("page") int page) {

        System.out.println(String.format("keyWord=%spage=%s", keyWord, page));

        return testApi.forkReose(keyWord, page);
    }


    @RequestMapping(value = "/search")
    public String janeSearch() {

        return "/xxsearch";
    }


    @RequestMapping(value = "/searchJson")
    @ResponseBody
    public String janeSearchJson(@RequestParam("keyWord") String keyWord) {
        System.out.println("keyworld = " + keyWord);

        return testApi.forkReose(keyWord, 0);
    }


    @RequestMapping(value = "/searchJson2web")
    public String searchJson2web(@RequestParam("keyWord") String keyWord, Model model) {
        System.out.println("keyworld = " + keyWord);

        model.addAttribute("html", testApi.forkReose(keyWord, 0));

        return "/webview";
    }


    @RequestMapping(value = "/janeItems")
    public String janeItems(Model model) {

        String json = testApi.forkReose("爬虫", 0);

        JaneItem janeItem = new Gson().fromJson(json, JaneItem.class);


        model.addAttribute("enties", janeItem.entries);


        return "/janeItems";
    }


}
