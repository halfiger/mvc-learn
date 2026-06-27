package com.tommy.mvc.chat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String createPage (Model model) {
        model.addAttribute("pig", new Pig());
        return "pig-create";
    }

    @RequestMapping ("/show-pig")
    public String showPage (@ModelAttribute("pig") Pig pig, Model model) {
        model.addAttribute("pig", pig);
        return "pig-show";
    }
}
