package com.epam.koval.carrent.bl.service;

import com.epam.koval.carrent.db.entity.User;
import com.epam.koval.carrent.web.bean.UserBean;
import com.epam.koval.carrent.web.bean.UserLoginBean;

/**
 * User service interface.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public interface UserService {
    /**
     * Logs user into system.
     * 
     * @param userLoginBean user login bean
     * @return user object
     */
    User login(UserLoginBean userLoginBean);

    /**
     * Registration user.
     * 
     * @param user user
     * @return user.
     */
    User registration(UserBean user);
}
