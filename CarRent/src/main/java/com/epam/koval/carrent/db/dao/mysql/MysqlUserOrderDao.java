package com.epam.koval.carrent.db.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.epam.koval.carrent.db.DbManager;
import com.epam.koval.carrent.db.constants.Constants;
import com.epam.koval.carrent.db.dao.UserOrderDao;
import com.epam.koval.carrent.db.entity.UserOrder;
import com.epam.koval.carrent.db.extractor.UserOrderExtractor;
import com.epam.koval.carrent.db.transaction.TransactionUtil;

/**
 * User order Dao implementation for MySQL DB.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public class MysqlUserOrderDao implements UserOrderDao {

    /** Logger. */
    private static final Logger LOG = Logger.getLogger(MysqlUserDao.class);

    /** Database manager. */
    private DbManager dbManager = null;

    /** DB connection. */
    private Connection connection = null;

    /** User extractor. */
    private UserOrderExtractor extractor = null;

    /**
     * Constructor.
     */
    public MysqlUserOrderDao() {
	dbManager = DbManager.getInstance();
	extractor = new UserOrderExtractor();
    }

    @Override
    public final UserOrder insert(final UserOrder aUserOrder) {
	LOG.debug("Started with info: " + aUserOrder);
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	long id = -1L;
	try {
	    connection = dbManager.getConnection();
	    pstmt = connection.prepareStatement(Constants.USER_ORDER_INSERT,
		    Statement.RETURN_GENERATED_KEYS);
	    setInsertPreparedStatement(pstmt, aUserOrder).executeUpdate();
	    rs = pstmt.getGeneratedKeys();
	    if (rs.next()) {
		id = rs.getLong(1);
	    }
	    aUserOrder.setId(id);
	    rs.close();
	    pstmt.close();
	    TransactionUtil.commit(connection);
	} catch (SQLException e) {
	    LOG.error(e.getMessage());
	    throw new RuntimeException();
	}
	LOG.debug("Done.");
	LOG.info(aUserOrder);
	return aUserOrder;
    }

    @Override
    public final boolean updateUserOrder(final UserOrder aUserOrder) {
	LOG.debug("Started with info: " + aUserOrder);
	PreparedStatement pstmt = null;
	try {
	    connection = dbManager.getConnection();
	    pstmt = connection.prepareStatement(Constants.USER_ORDER_UPDATE);
	    setPreparedStatement(pstmt, aUserOrder).executeUpdate();
	    pstmt.close();
	    TransactionUtil.commit(connection);
	} catch (SQLException e) {
	    TransactionUtil.rollback(connection);
	    LOG.error(e.getMessage());
	    throw new RuntimeException(e);
	} finally {
	    TransactionUtil.close(connection);
	}
	LOG.debug("Done.");
	return true;
    }

    @Override
    public final boolean deleteUserOrder(final Long userOrderId) {
	LOG.debug("Started with info: " + userOrderId);
	PreparedStatement pstmt = null;
	try {
	    connection = dbManager.getConnection();
	    pstmt = connection.prepareStatement(Constants.USER_ORDER_DELETE);
	    pstmt.setLong(1, userOrderId);
	    pstmt.executeQuery();
	    pstmt.close();
	    TransactionUtil.commit(connection);
	} catch (SQLException e) {
	    TransactionUtil.rollback(connection);
	    LOG.error(e.getMessage());
	    throw new RuntimeException(e);
	} finally {
	    TransactionUtil.close(connection);
	}
	LOG.debug("Done.");
	return true;
    }

    @Override
    public final List<UserOrder> getAllUserOrder() {
	LOG.debug("Started.");
	List<UserOrder> userOrders = new ArrayList<UserOrder>();
	Statement stmt = null;
	ResultSet rs = null;

	try {
	    connection = dbManager.getConnection();
	    stmt = connection.createStatement();
	    rs = stmt.executeQuery(Constants.USER_ORDER_SELECT_ALL);
	    while (rs.next()) {
		userOrders.add(extractor.extract(rs));
	    }
	    rs.close();
	    stmt.close();
	    TransactionUtil.commit(connection);
	} catch (SQLException e) {
	    TransactionUtil.rollback(connection);
	    LOG.error(e.getMessage());
	    throw new RuntimeException(e);
	} finally {
	    TransactionUtil.close(connection);
	}
	LOG.debug("Done.");
	LOG.info(userOrders);
	return userOrders;
    }

    @Override
    public final List<UserOrder> getAllClientUserOrder(final Long clientId) {
	LOG.debug("Started.");
	List<UserOrder> userOrders = new ArrayList<UserOrder>();
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
	    connection = dbManager.getConnection();
	    pstmt = connection
		    .prepareStatement(Constants.USER_ORDER_SELECT_ALL_CLIENT);
	    pstmt.setLong(1, clientId);
	    rs = pstmt.executeQuery();
	    while (rs.next()) {
		userOrders.add(extractor.extract(rs));
	    }
	    rs.close();
	    pstmt.close();
	    TransactionUtil.commit(connection);
	} catch (SQLException e) {
	    TransactionUtil.rollback(connection);
	    LOG.error(e.getMessage());
	    throw new RuntimeException(e);
	} finally {
	    TransactionUtil.close(connection);
	}
	LOG.debug("Done.");
	LOG.info(userOrders);
	return userOrders;
    }

    @Override
    public final UserOrder getUserOrderById(final Long aUserOrder) {
	LOG.debug("Started with id: " + aUserOrder);
	UserOrder userOrder = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
	    connection = dbManager.getConnection();
	    pstmt = connection.prepareStatement(Constants.USER_ORDER_SELECT_ID);
	    pstmt.setLong(1, aUserOrder);
	    rs = pstmt.executeQuery();
	    if (rs.next()) {
		userOrder = extractor.extract(rs);
	    }
	    rs.close();
	    pstmt.close();
	    TransactionUtil.commit(connection);
	} catch (SQLException e) {
	    TransactionUtil.rollback(connection);
	    LOG.error(e.getMessage());
	    throw new RuntimeException(e);
	} finally {
	    TransactionUtil.close(connection);
	}
	LOG.debug("Done.");
	LOG.info(userOrder);
	return userOrder;
    }

    /**
     * Fills prepared statement.
     * 
     * @param pstmt {@link PreparedStatement}
     * @param aUserOrder {@link UserOrder}
     * @return {@link PreparedStatement}
     * @throws SQLException {@link SQLException}
     */
    private PreparedStatement setInsertPreparedStatement(
	    final PreparedStatement pstmt, final UserOrder aUserOrder)
	    throws SQLException {
	int i = 1;
	pstmt.setLong(i++, aUserOrder.getClientId());
	pstmt.setLong(i++, aUserOrder.getCarId());
	pstmt.setString(i++, aUserOrder.getPassportData());
	pstmt.setBoolean(i++, aUserOrder.isWithDriver());
	pstmt.setDate(i++, aUserOrder.getRentStart());
	pstmt.setDate(i++, aUserOrder.getRentEnd());
	return pstmt;
    }

    /**
     * Fills prepared statement.
     * 
     * @param pstmt {@link PreparedStatement}
     * @param aUserOrder {@link UserOrder}
     * @return {@link PreparedStatement}
     * @throws SQLException {@link SQLException}
     */
    private PreparedStatement setPreparedStatement(
	    final PreparedStatement pstmt, final UserOrder aUserOrder)
	    throws SQLException {
	int i = 1;
	pstmt.setLong(i++, aUserOrder.getClientId());
	pstmt.setLong(i++, aUserOrder.getCarId());
	pstmt.setString(i++, aUserOrder.getPassportData());
	pstmt.setBoolean(i++, aUserOrder.isWithDriver());
	pstmt.setDate(i++, aUserOrder.getRentStart());
	pstmt.setDate(i++, aUserOrder.getRentEnd());
	pstmt.setString(i++, aUserOrder.getStatusName());
	pstmt.setLong(i++, aUserOrder.getId());
	return pstmt;
    }

}
