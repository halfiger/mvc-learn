package com.tommy.mvc.chat;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DogController {

    @RequestMapping ("/dog-home-page")
    public String homePage (Model model) {
        model.addAttribute("message", "hello MVC");
        return "dog-home";
    }

    @RequestMapping ("/dog-create-page")
    public String createDogPage () {
        return "dog-create";
    }


    @RequestMapping ("/dog-show-page")
    public String showDogPage (@RequestParam String dogName, Model model) {
        model.addAttribute("requestParamName", dogName);
        return "dog-show";
    }

}
