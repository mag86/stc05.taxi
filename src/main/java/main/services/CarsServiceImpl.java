package main.services;

import java.util.ArrayList;
import java.util.List;

import main.model.dao.CarsDAO;
import main.model.dao.CarsDAOImpl;
import main.model.pojo.Cars;
import main.model.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 */
//@Profiling
@Service
@Scope("prototype")

public class CarsServiceImpl implements CarsService {

    private static final Logger logger = Logger.getLogger(CarsServiceImpl.class);



    @Autowired
    private CarsDAO carsDAO;

    @Override
    public Cars getById(Long id) {
        return carsDAO.getById(id);
    }

    @Override
    public void update(Cars car) {
        carsDAO.update(car);
    }

    @Override
    public List<Cars> getAllCars() {
        List<Cars> cars = new ArrayList<>();
        cars.addAll(carsDAO.getAll());
        return cars;
    }

    @Override
    public Cars add(String phone_number, String driver_name,
                    String car_type, String car_name, String car_number, String car_color) {
        Cars car = carsDAO.addCarbyParameters(phone_number, driver_name,
                car_type, car_name, car_number, car_color);
        logger.debug("car: " + car);

        if (car == null ) {
            return null;
        }
        logger.debug("car successfully added");

        return car;
    }

    @Override
    public Cars add(Cars car) {
        return null;
    }

    @Override
    public Boolean delete(int id) {
        Boolean deleteresult = carsDAO.deleteById(id);
        logger.debug("car with id: " + id+" was deleted");

        if (deleteresult == false ) {
            return false;
        }
        logger.debug("car successfully deleted");

        return true;
    }
}
