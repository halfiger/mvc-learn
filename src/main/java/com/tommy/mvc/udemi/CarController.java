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
    public String homePage(Model model) {
        model.addAttribute("welcome", "Welcome to car home page");
        return "car-portal";
    }

    @RequestMapping("/createCar")
    public String createCar(Model model) {
        Map privids = new HashMap();
        privids.put("front", "fr");
        privids.put("backward", "bk");
        privids.put("full", "4x4");
        model.addAttribute("privids", privids);

        Map <Integer, Integer> tos = new HashMap();
        tos.put(2020, 20);
        tos.put(2022, 22);
        tos.put(2024, 24);
        tos.put(2026, 26);
        model.addAttribute("tos", tos);

        Map countrys = new HashMap();
        countrys.put("germany", "gr");
        countrys.put("france", "fr");
        countrys.put("england", "en");
        countrys.put("ukraine", "uk");
        model.addAttribute("countrys", countrys);

        Car car = new Car();
        car.setVolume(44);
        car.setBrand("444");
        car.setColor("4444");
        model.addAttribute("car", car);

        return "create-car";
    }

    @RequestMapping("/showCar")
    public String showCar(@ModelAttribute("car") Car car) {

        return "show-car";
    }

}
