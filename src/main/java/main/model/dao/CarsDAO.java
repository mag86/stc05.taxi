package main.model.dao;

import main.model.pojo.Cars;

/**
 *
 */
public interface CarsDAO extends DAO<Long, Cars> {
    Cars findCarByNameAndNumber(String car_name, String car_number);
    Cars addCarbyParameters(String phone_number, String driver_name, String car_type, String car_name, String car_number, String car_color);
    Boolean deleteById(int id);
}
