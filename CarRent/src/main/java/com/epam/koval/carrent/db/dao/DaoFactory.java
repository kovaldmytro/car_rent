package com.epam.koval.carrent.db.dao;

import com.epam.koval.carrent.db.dao.mysql.MysqlDaoFactory;

/**
 * Abstract Dao Factory.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public abstract class DaoFactory {
    /**
     * Returns car DAO.
     *
     * @return {@linkplain CarDao}
     */
    public abstract CarDao getCarDao();

    /**
     * Returns user DAO.
     * 
     * @return {@linkplain UserDao}
     */
    public abstract UserDao getUserDao();

    /**
     * Returns user order DAO.
     * 
     * @return {@linkplain UserOrderDao}
     */
    public abstract UserOrderDao getUserOrderDao();

    /**
     * Returns DaoFactory depending on argument string.
     *
     * @param whichFactory DAO factory name
     * @return {@linkplain DaoFactory}
     */
    public static DaoFactory getDaoFactory(final String whichFactory) {
	switch (whichFactory) {
	case "MYSQL":
	    return new MysqlDaoFactory();
	default:
	    return null;
	}
    }
}
