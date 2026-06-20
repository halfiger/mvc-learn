package com.tommy.mvc.chat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cat")
public class CatController {

    @RequestMapping ("/cat-home")
    public String homePage (Model model) {
        model.addAttribute("message", "it's cat hello page and its hello message from task1");
    return "cat-home-view";
    }

}
