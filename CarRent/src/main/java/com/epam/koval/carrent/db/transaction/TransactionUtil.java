package com.epam.koval.carrent.db.transaction;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * Transaction util.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public final class TransactionUtil {
    /** Logger. */
    private static final Logger LOG = Logger.getLogger(TransactionUtil.class);

    /**
     * Hidden constructor.
     */
    private TransactionUtil() {
    }

    /**
     * Commits given connection.
     *
     * @param aConnection Connection to be comitted
     */
    public static void commit(final Connection aConnection) {
	try {
	    aConnection.commit();
	} catch (SQLException e) {
	    LOG.error(e.getMessage());
	}
    }

    /**
     * Rollbacks given connection.
     *
     * @param aConnection Connection to be rollbacked
     */
    public static void rollback(final Connection aConnection) {
	try {
	    aConnection.rollback();
	} catch (SQLException e) {
	    LOG.error(e.getMessage());
	}
    }

    /**
     * Closes given connection.
     *
     * @param aConnection Connection to be closed
     */
    public static void close(final Connection aConnection) {
	try {
	    aConnection.close();
	} catch (SQLException e) {
	    LOG.error(e.getMessage());
	}
    }
}
