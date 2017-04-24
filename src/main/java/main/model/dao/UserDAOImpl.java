package main.model.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import main.model.ConnectionPool;
import main.model.pojo.User;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 */
public class UserDAOImpl implements UserDAO {

    private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

    @Override
    public Collection<User> getAll() {
        throw new NotImplementedException();
    }

    @Override
    public User getById(Long id) {
        throw new NotImplementedException();
    }

    @Override
    public Long insert(User entity) {
        throw new NotImplementedException();
    }

    @Override
    public void update(User entity) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(User entity) {
        throw new NotImplementedException();
    }

    @Override
    public User findUserByLoginAndPassword(String login, String password) {
        User user = null;

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement( "SELECT * FROM users WHERE login = ? AND password = ?")) {

            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = createEntity(resultSet);
            }

            logger.debug("user " + user);
        } catch (SQLException e) {
            logger.error(e);
        }

        return user;
    }

    @Override
    public User regUserbyParameters(String name, String phone_number, String user_address,
                                          String login, String password) {
        User user = null;

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement( "INSERT INTO users" +
                             " (user_phonenumber,user_name,user_address,login,password,is_blocked)" +
                             "VALUES (?,?,?,?,?,?)")) {

            statement.setString(1, phone_number);
            statement.setString(2, name);
            statement.setString(3, user_address);
            statement.setString(4, login);
            statement.setString(5, password);
            statement.setBoolean(6, false);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = createEntity(resultSet);
            }

            logger.debug("registred user " + user);
        } catch (SQLException e) {
            logger.error(e);
        }

        return user;
    }

    private User createEntity(ResultSet resultSet) throws SQLException {
        return new User(resultSet.getLong("id"),
                resultSet.getString("login"),
                resultSet.getString("password"),
                resultSet.getBoolean("is_blocked"));
    }
}
