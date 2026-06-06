package com.tommy.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {

    @RequestMapping("/")
    public String showFirstView () {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askDetails () {
        return "ask-details";
    }

    @RequestMapping("/showDetails")
    public String showDetails (HttpServletRequest request, Model model) {
        String empName = request.getParameter("employeeName");
        empName = "Mr " + empName;
        model.addAttribute("nameAttribute", empName);



        return "show-details";
    }



    //localhost:8080/mvc/
    //localhost:8080/mvc/askDetails
}
