package com.epam.koval.carrent.bl.service;

import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

import com.epam.koval.carrent.bl.constants.Constants;
import com.epam.koval.carrent.bl.util.Sha;
import com.epam.koval.carrent.db.dao.DaoFactory;
import com.epam.koval.carrent.db.dao.FactoryType;
import com.epam.koval.carrent.db.dao.UserDao;
import com.epam.koval.carrent.db.entity.Role;
import com.epam.koval.carrent.db.entity.User;
import com.epam.koval.carrent.web.bean.UserBean;
import com.epam.koval.carrent.web.bean.UserLoginBean;

/**
 * User Service implementation.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public final class UserServiceImpl implements UserService {

    /** Logger. */
    private static final Logger LOG = Logger.getLogger(UserServiceImpl.class);

    /** User DAO. */
    private UserDao userDao;

    /**
     * Constructor.
     */
    public UserServiceImpl() {
	this.userDao = DaoFactory.getDaoFactory(FactoryType.MYSQL).getUserDao();
    }

    @Override
    public User login(final UserLoginBean userLoginBean) {
	User user = null;
	user = userDao.getUserByEmail(userLoginBean.getEmail());
	if (user == null) {
	    LOG.error(Constants.ERROR_USER_NOT_EXIST);
	} else {
	    String passwordHash = null;
	    try {
		passwordHash = Sha.md5(userLoginBean.getPassword());
		if (!passwordHash.equals(user.getPassword())) {
		    user = null;
		}
	    } catch (NoSuchAlgorithmException e) {
		LOG.error(Constants.ERROR_SHA_PASSWORD);
		throw new RuntimeException();
	    }
	}
	return user;
    }

    @Override
    public User registration(final UserBean userBean) {
	String password = null;
	try {
	    password = Sha.md5(userBean.getPassword());
	} catch (NoSuchAlgorithmException e) {
	    e.printStackTrace();
	}
	User user = new User(userBean, password, Role.client);
	userDao.insertUser(user);
	return user;
    }
}
