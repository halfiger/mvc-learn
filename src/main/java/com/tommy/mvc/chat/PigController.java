package com.tommy.mvc.chat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PigController {

    @RequestMapping("/home-pig")
    public String homePage (Model model) {
        model.addAttribute("text", "welcome message");
        return "pig-home";
    }

    @RequestMapping ("/create-pig")
    public String createPage () {
        return "pig-create";
    }

    @RequestMapping ("/show-pig")
    public String showPage (@RequestParam ("pigName") String pigName, Model model) {
        model.addAttribute("name", pigName);
        return "pig-show";
    }
}
