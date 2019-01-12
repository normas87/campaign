package com.normas.springmvc;


import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CustomerController {

    private RestTemplate template = new RestTemplate();

    @GetMapping("/customer")
    public ModelAndView userPage() {
        return new ModelAndView("customer").addObject("customer", new Customer());
    }

    @PostMapping("/customer/save")
    public ModelAndView save(@ModelAttribute Customer customer) {
        template.postForLocation("http://localhost:8091/customer", customer);
        return new ModelAndView("index");
    }

    @GetMapping("/loginForm")
    public ModelAndView loginPage() {
        return new ModelAndView("login").addObject("loginForm", new LoginForm());
    }
}