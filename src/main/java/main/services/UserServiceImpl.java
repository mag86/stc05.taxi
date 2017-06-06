package main.services;

import org.apache.log4j.Logger;

import main.model.dao.UserDAO;
import main.model.dao.UserDAOImpl;
import main.model.pojo.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 */

//@Profiling
@Service
@Scope("prototype")

public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    private static UserDAO userDAO = new UserDAOImpl();

    @Override
    public User reg(String name, String phone_number, String user_address,
                    String login, String password) {
        User user = userDAO.regUserbyParameters(name, phone_number, user_address,login, password);
        logger.debug("user11: " + user);

        if (user != null && user.isBlocked()) {
            return null;
        }
        logger.debug("user successfully registred");

        return user;
    }

    @Override
    public User auth(String login, String password) {
        User user = userDAO.findUserByLoginAndPassword(login, password);
        logger.debug("user11: " + user);

        if (user != null && user.isBlocked()) {
            return null;
        }
        logger.debug("user not blocked");

        return user;
    }
}
