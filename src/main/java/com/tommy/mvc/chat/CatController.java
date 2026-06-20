package com.tommy.mvc.chat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cat")
public class CatController {

    @RequestMapping ("/")
    public String homePage (Model model) {
        model.addAttribute("message", "it's cat hello page and its hello message from task1");
        return "cat-home-view";
    }

    @RequestMapping ("/catCreate")
    public String createCat (Model model) {
        model.addAttribute("newCat", new Cat());
        return "cat-new-view";
    }

    @RequestMapping ("/catShow")
    public String showCat (@RequestParam("any") String any, Model model) {
        model.addAttribute("any", any);
        return "cat-show-view";
    }
}