package io.sanket.scm.controller;

import io.sanket.scm.dao.UserRepository;
import io.sanket.scm.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        User user = new User();
        user.setName("Sanket");
        user.setEmail("kutumbe.sanket@gmail.com");

        userRepository.save(user);
        return "True";
    }

    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("title", "Home - Smart Contacts manager");
        return "home";
    }

    @RequestMapping("/about")
    public String about(Model model){
        model.addAttribute("title", "About - Smart Contacts manager");
        return "about";
    }
}
