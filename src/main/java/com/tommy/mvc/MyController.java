package com.tommy.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping ("/data")
public class MyController {

    @RequestMapping("/")
    public String showFirstView () {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askDetails (Model model) {
        model.addAttribute("employee", new Employee());
        return "ask-details";
    }

    @RequestMapping("/showDetails")
    public String showDetails (@ModelAttribute("employee") Employee emp) {
        return "show-details";
    }

    //localhost:8080/mvc/
    //localhost:8080/mvc/askDetails
}