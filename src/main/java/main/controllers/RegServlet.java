package main.controllers;

import main.services.UserService;
import main.services.UserServiceImpl;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**

 */
public class RegServlet extends HttpServlet {
    static {
        PropertyConfigurator.configure(LoginController.class.getClassLoader()
                .getResource("log4j.properties"));
    }

    private static final Logger logger = Logger.getLogger(RegServlet.class);

    private static UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String phone_number = req.getParameter("phone_number");
        String user_address = req.getParameter("user_address");
        String login = req.getParameter("login");
        String password = req.getParameter("password");


        if (userService.reg(name, phone_number, user_address,
                login, password) != null) {

            logger.debug("user: " + login + " registred" );
            req.getSession().setAttribute("greeting new user", "Здравствуйте, вы успешно зарегистрировались, ");
            req.getSession().setAttribute("loginnew", login);

            resp.sendRedirect(req.getContextPath() + "/login");
        }

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }
}
