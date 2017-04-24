package main.services;

import java.util.ArrayList;
import java.util.List;

import main.model.dao.CarsDAO;
import main.model.dao.CarsDAOImpl;
import main.model.pojo.Cars;

/**
 *
 */
public class CarsServiceImpl implements CarsService {

    private static CarsDAO carsDAO = new CarsDAOImpl();

    @Override
    public List<Cars> getAllCars() {
        List<Cars> cars = new ArrayList<>();
        cars.addAll(carsDAO.getAll());
        return cars;
    }
}
