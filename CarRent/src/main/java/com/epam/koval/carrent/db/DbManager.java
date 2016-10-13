package com.epam.koval.carrent.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

/**
 * Data base manager.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public final class DbManager {
    /** Logger. */
    private static final Logger LOG = Logger.getLogger(DbManager.class);

    /** An instance of DbManager. Singletone. */
    private static DbManager instance;

    /**
     * Returns instance of DbManager. Singletone.
     *
     * @return instance of DbManager
     */
    public static synchronized DbManager getInstance() {
	if (instance == null) {
	    instance = new DbManager();
	}
	return instance;
    }

    /**
     * Hidden constructor.
     */
    private DbManager() {
    }

    /**
     * Returns DB connection from the Connection Pool.
     *
     * @return DB Connection
     * @throws SQLException {@link SQLException}
     */
    public Connection getConnection() throws SQLException {
	Connection connection = null;
	try {
	    Context context = new InitialContext();
	    DataSource dataSource = (DataSource) context
		    .lookup("java:comp/env/jdbc/car_rent");
	    connection = dataSource.getConnection();
	    connection.setAutoCommit(false);
	    connection.setTransactionIsolation(
		    Connection.TRANSACTION_READ_COMMITTED);
	} catch (NamingException e) {
	    LOG.error("Cannot obtain a connection from the pool:", e);
	    throw new RuntimeException(e);
	}
	return connection;
    }
}
