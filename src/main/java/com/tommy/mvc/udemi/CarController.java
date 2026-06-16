package com.tommy.mvc.udemi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/car")
public class CarController {

    @RequestMapping("/home")
    public String homePage (Model model) {
        model.addAttribute("welcome", "Welcome to car home page");
        return "car-portal";
    }

    @RequestMapping("/createCar")
    public String createCar (Model model) {
        Map privids = new HashMap();
        privids.put("front", "fr");
        privids.put("backward", "bk");
        privids.put("full", "4x4");
        model.addAttribute("privids", privids);

        Car car = new Car();
        car.setVolume(44);
        car.setBrand("444");
        car.setColor("4444");
        model.addAttribute("car", car);

        return "create-car";
    }

    @RequestMapping("/showCar")
    public String showCar (@ModelAttribute("car")Car car) {

        return "show-car";
    }

}
