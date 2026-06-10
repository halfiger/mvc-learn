package com.tommy.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping ("/employee")
public class MyController {

    @RequestMapping("/home")
    public String showFirstView (Model model) {
        model.addAttribute("message", "Welcome to Employee Portal");
        model.addAttribute("koko", "hello kokokoko" );
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

    @RequestMapping("/info")
    public String showInfo (Model model) {

        Employee emp = new Employee();
        emp.setName("boba");
        emp.setSalary(111);
        emp.setSurname("biba");
        emp.setDepartment("SSS");

        model.addAttribute("data", emp);

        return "company-info";
    }

    @RequestMapping("/contact")
    public String showContacts () {
        return "show-contact";
    }

//-----------------askName-------------------
    @RequestMapping("/askName")
    public String askName () {
        return "ask-name";
    }

    @RequestMapping("/showGreeting")
    public String showGreeting (@RequestParam("employeeName") String name, Model model) {
        model.addAttribute("greetingName", name);
        return "show-greeting";
    }


    //localhost:8080/mvc/
    //localhost:8080/mvc/employees/askName
}