package main.controllers;

import main.model.pojo.User;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.services.UserService;
import main.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 */

@Controller
@SessionAttributes("user")
public class LoginController {

    static {
        PropertyConfigurator.configure(LoginController.class.getClassLoader()
                .getResource("log4j.properties"));
    }

    private static final Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    public UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sayHello() {
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam(value = "login") String login,
                           @RequestParam(value = "password") String password,
                           @RequestParam(value = "phone_number") String phoneNumber,
                           @RequestParam(value = "user_name") String userName,
                           @RequestParam(value = "user_address") String userAddress

    ) {
        userService.reg(userName,phoneNumber,userAddress,login,password);
        return "redirect:/";
    }


}

