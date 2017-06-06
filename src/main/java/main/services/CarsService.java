package main.services;

import java.util.List;

import main.model.dao.CarsDAOImpl;
import main.model.pojo.Cars;

/**
 *
 */
public interface CarsService {

   List<Cars> getAllCars();

   public Cars add(String car_phonenumber, String driver_name, String car_type, String car_name, String car_number, String car_color);
   public Cars add(Cars car);
   Boolean delete(int id);

   public Cars getById(Long id);
   public void update(Cars car);
}
