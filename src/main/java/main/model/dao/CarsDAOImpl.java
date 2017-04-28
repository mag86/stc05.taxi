package main.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import main.model.ConnectionPool;
import main.model.pojo.Group;
import main.model.pojo.Cars;
import main.model.pojo.User;
import main.services.UserServiceImpl;
import org.apache.log4j.Logger;

/**
 *
 */
@SuppressWarnings("Duplicates")
public class CarsDAOImpl implements CarsDAO {


    private static final Logger logger = Logger.getLogger(CarsDAOImpl.class);

    private static final String SELECT_ALL = "SELECT car_id, car_phonenumber, driver_name, car_type," +
            "car_name, car_number, car_color, group_id FROM cars ORDER BY car_id";

    private static final String INSERT_INTO = "INSERT INTO cars (car_phonenumber, driver_name, car_type," +
            "car_name,car_number,car_color) " +
            "VALUES (?, ?,?,?,?,?)";
    private static final String UPDATE_WHERE = "UPDATE cars SET car_phonenumber = ?, driver_name = ?, car_type = ?, " +
            "car_name = ?, car_number = ?, car_color = ? " +
            "WHERE car_id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM cars WHERE car_id=?";

    @Override
    public Collection<Cars> getAll() {
        Set<Cars> entities = new HashSet<>();

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                logger.debug("getAll has next");
                entities.add(createEntity(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }


    @Override
    public Cars getById(Long id) {
        Cars car = null;

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement(SELECT_ALL + " WHERE car_id = ?")) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                car = createEntity(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return car;
    }

    @Override
    public Boolean deleteById(int id) {


        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement(DELETE_BY_ID)) {

            statement.setInt(1, id);
            if ((statement.executeUpdate()) != 0) {

                logger.debug("Added 1 car ");
                logger.debug("After car added");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public Long insert(Cars entity) {
        long result = -1;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_INTO,
                     Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, entity.getCar_phonenumber());
            statement.setString(1, entity.getDriver_name());
            statement.setString(1, entity.getCar_type());
            statement.setString(1, entity.getCar_name());
            statement.setString(1, entity.getCar_number());
            statement.setString(1, entity.getCar_color());

            statement.setInt(3, entity.getGroupId());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                result = resultSet.getLong(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void update(Cars entity) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement(UPDATE_WHERE)) {
            statement.setString(1, entity.getCar_phonenumber());
            statement.setString(1, entity.getDriver_name());
            statement.setString(1, entity.getCar_type());
            statement.setString(1, entity.getCar_name());
            statement.setString(1, entity.getCar_number());
            statement.setString(1, entity.getCar_color());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Cars entity) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement(DELETE_BY_ID)) {

            statement.setLong(1, entity.getCar_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Cars createEntity(ResultSet resultSet) throws SQLException {
        Cars cars = new Cars();
        cars.setCar_id(resultSet.getInt("car_id"));
        cars.setCar_phonenumber(resultSet.getString("car_phonenumber"));
        cars.setDriver_name(resultSet.getString("driver_name"));
        cars.setCar_type(resultSet.getString("car_type"));
        cars.setCar_name(resultSet.getString("car_name"));
        cars.setCar_number(resultSet.getString("car_number"));
        cars.setCar_color(resultSet.getString("car_color"));

        cars.setGroupId(resultSet.getInt("group_id"));

        Group group = new GroupDAOImpl().getById(cars.getGroupId());
        cars.setGroup(group);

        return cars;
    }

    @Override
    public Cars findCarByNameAndNumber(String car_name, String car_number) {
        Cars car = null;

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement("SELECT * FROM cars WHERE car_name = ? AND car_number = ?")) {

            statement.setString(1, car_name);
            statement.setString(2, car_number);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                car = createEntity(resultSet);
            }

            logger.debug("car " + car);
        } catch (SQLException e) {
            logger.error(e);
        }

        return car;
    }

    @Override
    public Cars addCarbyParameters(String phone_number, String driver_name,
                                   String car_type, String car_name,
                                   String car_number, String car_color) {
        Cars car = null;

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement("INSERT INTO cars" +
                             " (car_phonenumber,driver_name,car_type,car_name,car_number,car_color)" +
                             "VALUES (?,?,?,?,?,?)")) {

            statement.setString(1, phone_number);
            statement.setString(2, driver_name);
            statement.setString(3, car_type);
            statement.setString(4, car_name);
            statement.setString(5, car_number);
            statement.setString(6, car_color);
            logger.debug("Befor car added");

            if ((statement.executeUpdate()) != 0) {
                car = this.findCarByNameAndNumber(car_name, car_number);
                logger.debug("Added 1 car ");
                logger.debug("After car added");
            }


        } catch (SQLException e) {
            logger.error(e);
        }

        return car;
    }
}
