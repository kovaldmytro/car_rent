package com.epam.koval.carrent.db.dao.mysql;

import com.epam.koval.carrent.db.dao.CarDao;
import com.epam.koval.carrent.db.dao.DaoFactory;
import com.epam.koval.carrent.db.dao.UserDao;
import com.epam.koval.carrent.db.dao.UserOrderDao;

/**
 * Dao Factory implementation for MySQL DB.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public class MysqlDaoFactory extends DaoFactory {

    @Override
    public final CarDao getCarDao() {
	return new MysqlCarDao();
    }

    @Override
    public final UserDao getUserDao() {
	return new MysqlUserDao();
    }

    @Override
    public final UserOrderDao getUserOrderDao() {
	return new MysqlUserOrderDao();

    }
}
