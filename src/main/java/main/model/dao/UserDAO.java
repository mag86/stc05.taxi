package main.model.dao;

import main.model.pojo.User;

/**
 *
 */
public interface UserDAO extends DAO<Long, User> {

    User findUserByLoginAndPassword(String login, String password);
    User regUserbyParameters(String name, String phone_number, String user_address, String login, String password);
}
