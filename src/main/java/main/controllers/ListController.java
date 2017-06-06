package main.controllers;

import javax.servlet.http.HttpServletRequest;

import main.model.pojo.Cars;
import main.services.CarsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 */
//public class ListController extends HttpServlet {
//
//    private static final Logger logger = Logger.getLogger(ListController.class);
//
//    private static CarsService carsService = new CarsServiceImpl();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String login = (String)(req.getSession().getAttribute("userLogin"));
//        req.setAttribute("login", login);
//        req.setAttribute("greeting", "Уважаемый,");
//        req.setAttribute("info", "Список такси для вызова");
//
//
//        List<Cars> cars = carsService.getAllCars();
//
//        req.setAttribute("cars", cars);
//
//        String delete = req.getParameter("delete");
//        if (delete!=null){
//            logger.debug("delete car with id: " + delete);
//
//            int car_id = Integer.parseInt(delete  );
//            carsService.delete(car_id);
//        }
//
//        getServletContext().getRequestDispatcher("/listCars.jsp")
//                .forward(req, resp);
//
//
//    }
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
//                config.getServletContext());
//    }
//}

@Controller
//@RequestMapping(value = "/listCars")
public class ListController {
    private static final Logger logger = Logger.getLogger(ListController.class);
    @Autowired
    public CarsService carsService;

    @RequestMapping(value = "/listCars", method = RequestMethod.GET)
    public String showList(Model model, HttpServletRequest req) {
        model.addAttribute("cars", carsService.getAllCars());
        //model.getClass(model, model);
        String login = (String) (req.getSession().getAttribute("userLogin"));
        //req.setAttribute("login", login);
        req.setAttribute("greeting", "Dear, user");
        req.setAttribute("info", "The list of available taxi cars is shown below ");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        model.addAttribute("username", name);

        return "listCars";
    }

    @RequestMapping(value = "/listCars/addcar", method = RequestMethod.GET)
    public String edit(ModelMap model) {
        return "addCar";
    }

    @RequestMapping(value = "/listCars/addcar", method = RequestMethod.POST)
    public String edit(@ModelAttribute(value = "car") Cars car, Model model, HttpServletRequest req) {
        logger.debug("Car from POST: " + car.getCar_name() + " " + car.getCar_color());
        carsService.add(car.getCar_phonenumber(), car.getDriver_name(), car.getCar_type(),
                car.getCar_name(), car.getCar_number(), car.getCar_color());
        logger.debug("Car was added");

        req.setAttribute("info", "You have succesfully added the new Car!");
        model.addAttribute("cars", carsService.getAllCars());
        return "listCars";
    }

    @RequestMapping(value = "/listCars/editcar/{id}", method = RequestMethod.GET)
    public String getCar(@PathVariable(value = "id") long id, ModelMap model) {
        Cars cars = carsService.getById(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username

        model.addAttribute("username", name);
        model.addAttribute("car", cars);
        return "editcar";
//        return new ModelAndView("editcar");
    }


    @RequestMapping(value = "/listCars/editcar", method = RequestMethod.POST)
    public String postCar(@ModelAttribute Cars car, ModelMap model) {
        logger.debug("TESTTEST" + car.getCar_name() + " " + car.getCar_id());
        carsService.update(car);
        return "redirect:/listCars";
    }

    @RequestMapping(value = "/listCars/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id") int id, Model model, HttpServletRequest req) {
        //model.addAttribute("cars", carsService.delete(id));
        logger.debug("THE ID IS: " + id);
        if (carsService.delete(id)) {
            logger.debug("Car was deleted");
            req.setAttribute("info", "Was deleted Car with id =" + id);
            model.addAttribute("cars", carsService.getAllCars());

            //model.addAttribute("info", "Уважаемый,");
        } else logger.debug("car wasn't deleted");
        return "listCars";
    }

    /**
     * Setter for property 'studentService'.
     *
     * @param carsService Value to set for property 'studentService'.
     */
    public void setStudentService(CarsService carsService) {
        this.carsService = carsService;
    }
}

