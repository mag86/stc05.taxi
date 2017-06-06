package main.controllers;

import main.services.CarsService;
import main.services.CarsServiceImpl;
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
 * Created by admin on 27.04.2017.
 */
public class AddCarServlet extends HttpServlet{

    static {
        PropertyConfigurator.configure(LoginController.class.getClassLoader()
                .getResource("log4j.properties"));
    }

    private static final Logger logger = Logger.getLogger(LoginController.class);

    private static CarsService carsService = new CarsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/addCar.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            String car_phonenumber = req.getParameter("car_phonenumber");
            String driver_name = req.getParameter("driver_name");
            String car_type = req.getParameter("car_type");
            String car_name = req.getParameter("car_name");
            String car_number = req.getParameter("car_number");
            String car_color = req.getParameter("car_color");
            if (carsService.add(car_phonenumber, driver_name,
                    car_type, car_name,car_number,car_color) != null) {

                logger.debug("car: " +car_name+car_number+ " added" );
                req.getSession().setAttribute("newcaradded", "Вы успешно добавили авто!");


                resp.sendRedirect(req.getContextPath() + "/listCars");
            }

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }
}
