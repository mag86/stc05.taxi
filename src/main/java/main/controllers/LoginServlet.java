package main.controllers;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.services.UserService;
import main.services.UserServiceImpl;

/**
 *
 */
public class LoginServlet extends HttpServlet {

    static {
        PropertyConfigurator.configure(LoginServlet.class.getClassLoader()
                .getResource("log4j.properties"));
    }

    private static final Logger logger = Logger.getLogger(LoginServlet.class);

    private static UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        req.getSession().getAttribute("greeting");

        if (userService.auth(login, password) != null) {
            req.getSession().setAttribute("userLogin", login);
            logger.debug("user: " + login + " logged" );
            resp.sendRedirect(req.getContextPath() + "/listCars");
        }
        else{
            resp.sendRedirect(req.getContextPath() + "/error");
        }
    }
}
