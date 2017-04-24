package main.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import main.model.pojo.Cars;
import main.services.CarsService;
import main.services.CarsServiceImpl;

/**
 *
 */
public class ListController extends HttpServlet {

    private static CarsService carsService = new CarsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String)(req.getSession().getAttribute("userLogin"));
        req.setAttribute("login", login);
        req.setAttribute("greeting", "Здравствуйте,");
        req.setAttribute("info", "Список такси для вызова");


        List<Cars> cars = carsService.getAllCars();

        req.setAttribute("cars", cars);

        getServletContext().getRequestDispatcher("/listCars.jsp")
                .forward(req, resp);
    }
}
