package main.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.model.dao.CarsDAO;
import main.model.dao.CarsDAOImpl;
import main.model.pojo.Cars;
import main.services.CarsService;
import main.services.CarsServiceImpl;
import main.services.UserServiceImpl;
import org.apache.log4j.Logger;

/**
 *
 */
public class ListController extends HttpServlet {

    private static final Logger logger = Logger.getLogger(ListController.class);

    private static CarsService carsService = new CarsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String)(req.getSession().getAttribute("userLogin"));
        req.setAttribute("login", login);
        req.setAttribute("greeting", "Уважаемый,");
        req.setAttribute("info", "Список такси для вызова");


        List<Cars> cars = carsService.getAllCars();

        req.setAttribute("cars", cars);

        String delete = req.getParameter("delete");
        if (delete!=null){
            logger.debug("delete car with id: " + delete);

            int car_id = Integer.parseInt(delete  );
            carsService.delete(car_id);
        }

        getServletContext().getRequestDispatcher("/listCars.jsp")
                .forward(req, resp);


    }
}
