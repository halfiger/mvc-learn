package com.tommy.mvc.udemi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/car")
public class CarController {

    @RequestMapping("/home")
    public String homePage (Model model) {
        model.addAttribute("welcome", "Welcome to car home page");
        return "car-portal";
    }

    @RequestMapping("/create-car")
    public String createCar (Model model) {
        model.addAttribute("car", new Car());
        return "create-car";
    }


}
