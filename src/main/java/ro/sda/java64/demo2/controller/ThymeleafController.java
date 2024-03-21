package ro.sda.java64.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ThymeleafController {

    @GetMapping("/thymeleaf/hello/{nume}")
    public  String helloWorld(Model model, @PathVariable String nume){
        model.addAttribute("value","Scufita rosie alearga prin padure!");
        model.addAttribute("name",nume);
        return "hello";
    }

    @GetMapping("/thymeleaf/hello3")
    public @ResponseBody String helloWorld3(){
        return "hello";
    }

    @GetMapping("/thymeleaf/hello2")
    public ModelAndView helloWorld2(Model model){
        ModelAndView view = new ModelAndView("hello");
        System.out.println(model.getAttribute("name"));
        view.addObject("name",(String)model.getAttribute("name"));
        return view;
    }

    @GetMapping("/thymeleaf/hello5")
    public String hello5(Model model){
        model.addAttribute("value","Vin din redirect");
        return "hello";
    }
}
