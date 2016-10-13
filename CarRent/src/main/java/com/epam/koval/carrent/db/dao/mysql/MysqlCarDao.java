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
import com.epam.koval.carrent.db.dao.CarDao;
import com.epam.koval.carrent.db.entity.Car;
import com.epam.koval.carrent.db.extractor.CarExtractor;
import com.epam.koval.carrent.db.transaction.TransactionUtil;

/**
 * Car DAO implementation for MySQL DB.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public class MysqlCarDao implements CarDao {

    /** Logger. */
    private static final Logger LOG = Logger.getLogger(MysqlCarDao.class);

    /** Database manager. */
    private DbManager dbManager = null;

    /** DB connection. */
    private Connection connection = null;

    /** Car extractor. */
    private CarExtractor extractor = null;

    /**
     * Constructor.
     */
    public MysqlCarDao() {
	dbManager = DbManager.getInstance();
	extractor = new CarExtractor();
    }

    @Override
    public final Car insertCar(final Car aCar) {
	LOG.debug("Started with info: " + aCar);
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	long id = -1L;
	try {
	    connection = dbManager.getConnection();
	    connection.setAutoCommit(false);
	    
	    pstmt = connection.prepareStatement(Constants.CAR_INSERT,
		    Statement.RETURN_GENERATED_KEYS);
	    setInsertPreparedStatement(pstmt, aCar).executeUpdate();
	    rs = pstmt.getGeneratedKeys();
	    if (rs.next()) {
		id = rs.getLong(1);
	    }
	    aCar.setId(id);
	    rs.close();
	    pstmt.close();
	    TransactionUtil.commit(connection);
	} catch (SQLException e) {
	    LOG.error(e.getMessage());
	    throw new RuntimeException();
	}
	LOG.debug("Done.");
	LOG.info(aCar);
	return aCar;
    }

    @Override
    public final boolean updateCar(final Car car) {
	LOG.debug("Started with info: " + car);
	PreparedStatement pstmt = null;
	try {
	    connection = dbManager.getConnection();
	    pstmt = connection.prepareStatement(Constants.CAR_UPDATE);
	    setPreparedStatement(pstmt, car).executeUpdate();
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
    public final boolean deleteCar(final Long aCarId) {
	LOG.debug("Started with info: " + aCarId);
	PreparedStatement pstmt = null;
	try {
	    connection = dbManager.getConnection();
	    pstmt = connection.prepareStatement(Constants.CAR_DELETE);
	    pstmt.setLong(1, aCarId);
	    pstmt.executeUpdate();
	    pstmt.close();
	    TransactionUtil.commit(connection);
	} catch (SQLException e) {
	    TransactionUtil.rollback(connection);
	    LOG.error(e.getMessage());
	    return false;
	} finally {
	    TransactionUtil.close(connection);
	}
	LOG.debug("Done.");
	return true;
    }

    @Override
    public final List<Car> getAllCars() {
	LOG.debug("Started.");
	List<Car> cars = new ArrayList<Car>();
	Statement stmt = null;
	ResultSet rs = null;

	try {
	    connection = dbManager.getConnection();
	    stmt = connection.createStatement();
	    rs = stmt.executeQuery(Constants.CAR_SELECT_ALL);
	    while (rs.next()) {
		cars.add(extractor.extract(rs));
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
	LOG.info(cars);
	return cars;
    }

    @Override
    public final Car getCarById(final Long carId) {
	LOG.debug("Started with id: " + carId);
	Car car = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
	    connection = dbManager.getConnection();
	    pstmt = connection.prepareStatement(Constants.CAR_SELECT_ID);
	    pstmt.setLong(1, carId);
	    rs = pstmt.executeQuery();
	    if (rs.next()) {
		car = extractor.extract(rs);
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
	LOG.info(car);
	return car;
    }

    @Override
    public final List<Car> getAllNotRentedCars() {
	LOG.debug("Started.");
	List<Car> cars = new ArrayList<Car>();
	Statement stmt = null;
	ResultSet rs = null;

	try {
	    connection = dbManager.getConnection();
	    stmt = connection.createStatement();
	    rs = stmt.executeQuery(Constants.CAR_SELECT_ALL_NOT_RENTED);
	    while (rs.next()) {
		cars.add(extractor.extract(rs));
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
	LOG.info(cars);
	return cars;
    }

    @Override
    public final List<Car> getAllCarsByClass(final String aCarClass) {
	LOG.debug("Started.");
	List<Car> car = new ArrayList<Car>();
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
	    connection = dbManager.getConnection();
	    pstmt = connection.prepareStatement(Constants.CAR_SELECT_CLASS);
	    pstmt.setString(1, aCarClass);
	    rs = pstmt.executeQuery();
	    while (rs.next()) {
		car.add(extractor.extract(rs));
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
	LOG.info(car);
	return car;
    }

    /**
     * Fills prepared statement.
     * 
     * @param pstmt {@link PreparedStatement}
     * @param car {@link Car}
     * @return {@link PreparedStatement}
     * @throws SQLException {@link SQLException}
     */
    private PreparedStatement setInsertPreparedStatement(
	    final PreparedStatement pstmt, final Car car) throws SQLException {
	int i = 1;
	pstmt.setString(i++, car.getMark());
	pstmt.setString(i++, car.getModel());
	pstmt.setString(i++, car.getCarClassName());
	pstmt.setBigDecimal(i++, car.getCost());
	pstmt.setBoolean(i++, car.isRented());
	return pstmt;
    }

    /**
     * Fills prepared statement.
     * 
     * @param pstmt {@link PreparedStatement}
     * @param car {@link Car}
     * @return {@link PreparedStatement}
     * @throws SQLException {@link SQLException}
     */
    private PreparedStatement setPreparedStatement(
	    final PreparedStatement pstmt, final Car car) throws SQLException {
	int i = 1;
	pstmt.setString(i++, car.getMark());
	pstmt.setString(i++, car.getModel());
	pstmt.setString(i++, car.getCarClassName());
	pstmt.setBigDecimal(i++, car.getCost());
	pstmt.setBoolean(i++, car.isRented());
	pstmt.setLong(i++, car.getId());
	return pstmt;
    }

}
