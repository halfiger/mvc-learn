package com.tommy.mvc.chat;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String createDogPage (Model model) {
        model.addAttribute("dog", new Dog());
        return "dog-create";
    }


    @RequestMapping ("/dog-show-page")
    public String showDogPage (@ModelAttribute ("dog") Dog dog) {
        return "dog-show";
    }


}
