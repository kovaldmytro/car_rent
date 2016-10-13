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
import com.epam.koval.carrent.db.dao.UserDao;
import com.epam.koval.carrent.db.entity.User;
import com.epam.koval.carrent.db.extractor.UserExtractor;
import com.epam.koval.carrent.db.transaction.TransactionUtil;

/**
 * User Dao implementation for MySQL DB.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public class MysqlUserDao implements UserDao {
    /** Logger. */
    private static final Logger LOG = Logger.getLogger(MysqlUserDao.class);

    /** Database manager. */
    private DbManager dbManager = null;

    /** DB connection. */
    private Connection connection = null;

    /** User extractor. */
    private UserExtractor extractor = null;

    /**
     * Constructor.
     */
    public MysqlUserDao() {
	dbManager = DbManager.getInstance();
	extractor = new UserExtractor();
    }

    @Override
    public final User insertUser(final User aUser) {
	LOG.debug("Started with info: " + aUser);
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	long id = -1L;
	try {
	    connection = dbManager.getConnection();
	    pstmt = connection.prepareStatement(Constants.USER_INSERT,
		    Statement.RETURN_GENERATED_KEYS);
	    setInsertPreparedStatement(pstmt, aUser).executeUpdate();
	    rs = pstmt.getGeneratedKeys();
	    if (rs.next()) {
		id = rs.getLong(1);
	    }
	    aUser.setId(id);
	    rs.close();
	    pstmt.close();
	    TransactionUtil.commit(connection);
	} catch (SQLException e) {
	    LOG.error(e.getMessage());
	    throw new RuntimeException();
	}
	LOG.debug("Done.");
	LOG.info(aUser);
	return aUser;
    }

    @Override
    public final boolean updateUser(final User user) {
	LOG.debug("Started with info: " + user);
	PreparedStatement pstmt = null;
	try {
	    connection = dbManager.getConnection();
	    pstmt = connection.prepareStatement(Constants.USER_UPDATE);
	    setPreparedStatement(pstmt, user).executeUpdate();
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
    public final boolean deleteUser(final Long userId) {
	LOG.debug("Started with info: " + userId);
	PreparedStatement pstmt = null;
	try {
	    connection = dbManager.getConnection();
	    pstmt = connection.prepareStatement(Constants.USER_DELETE);
	    pstmt.setLong(1, userId);
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
    public final List<User> getAllUsers() {
	LOG.debug("Started.");
	List<User> users = new ArrayList<User>();
	Statement stmt = null;
	ResultSet rs = null;

	try {
	    connection = dbManager.getConnection();
	    stmt = connection.createStatement();
	    rs = stmt.executeQuery(Constants.USER_SELECT_ALL);
	    while (rs.next()) {
		users.add(extractor.extract(rs));
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
	LOG.info(users);
	return users;
    }

    @Override
    public final User getUserById(final Long userId) {
	LOG.debug("Started with id: " + userId);
	User user = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
	    connection = dbManager.getConnection();
	    pstmt = connection.prepareStatement(Constants.USER_SELECT_ID);
	    pstmt.setLong(1, userId);
	    rs = pstmt.executeQuery();
	    if (rs.next()) {
		user = extractor.extract(rs);
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
	LOG.info(user);
	return user;
    }

    @Override
    public final User getUserByEmail(final String email) {
	LOG.debug("Started with email: " + email);
	User user = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
	    connection = dbManager.getConnection();
	    pstmt = connection.prepareStatement(Constants.USER_SELECT_EMAIL);
	    pstmt.setString(1, email);
	    rs = pstmt.executeQuery();
	    if (rs.next()) {
		user = extractor.extract(rs);
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
	    LOG.debug("Done.");
	}
	LOG.info("User:" + user);
	return user;
    }

    /**
     * Fills prepared statement.
     * 
     * @param pstmt {@link PreparedStatement}
     * @param aUser {@link User}
     * @return {@link PreparedStatement}
     * @throws SQLException {@link SQLException}
     */
    private PreparedStatement setInsertPreparedStatement(
	    final PreparedStatement pstmt, final User aUser)
	    throws SQLException {
	int i = 1;
	pstmt.setString(i++, aUser.getEmail());
	pstmt.setString(i++, aUser.getPassword());
	pstmt.setString(i++, aUser.getName());
	pstmt.setString(i++, aUser.getSurname());
	pstmt.setBoolean(i++, aUser.isBlocked());
	pstmt.setString(i++, aUser.getRoleName());
	return pstmt;
    }

    /**
     * Fills prepared statement.
     * 
     * @param pstmt {@link PreparedStatement}
     * @param aUser {@link User}
     * @return {@link PreparedStatement}
     * @throws SQLException {@link SQLException}
     */
    private PreparedStatement setPreparedStatement(
	    final PreparedStatement pstmt, final User aUser)
	    throws SQLException {
	int i = 1;
	pstmt.setString(i++, aUser.getEmail());
	pstmt.setString(i++, aUser.getPassword());
	pstmt.setString(i++, aUser.getName());
	pstmt.setString(i++, aUser.getSurname());
	pstmt.setBoolean(i++, aUser.isBlocked());
	pstmt.setString(i++, aUser.getRoleName());
	pstmt.setLong(i++, aUser.getId());
	return pstmt;
    }
}
