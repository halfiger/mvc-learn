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

    @RequestMapping ("/catCreateText")
    public String createCatText (Model model) {
        model.addAttribute("newCat", new Cat());
        return "cat-newtext-view";
    }

    @RequestMapping ("/catShowText")
    public String showText (@RequestParam("any") String any, Model model) {
        model.addAttribute("any", any);
        return "cat-showtext-view";
    }

    @RequestMapping ("/catNew")
    public String createCat (Model model) {
        model.addAttribute("cat", new Cat());
        return "cat-new";
    }

    @RequestMapping ("/catShow")
    public String showCat (@ModelAttribute ("cat") Cat cat) {
        return "cat-show";
    }

}