package main.services;

import main.model.pojo.User;

/**
 *
 */
public interface UserService {

    User auth(String login, String password);
    User reg(String name, String phone_number, String user_address,
             String login, String password);
}
