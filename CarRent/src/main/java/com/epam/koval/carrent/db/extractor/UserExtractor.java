package com.epam.koval.carrent.db.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.koval.carrent.db.constants.Constants;
import com.epam.koval.carrent.db.entity.User;

/**
 * User extractor.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public class UserExtractor implements Extractor<User> {

    @Override
    public final User extract(final ResultSet rs) throws SQLException {
	User user = new User();
	user.setId(rs.getLong(Constants.USER_ID));
	user.setEmail(rs.getString(Constants.USER_EMAIL));
	user.setPassword(rs.getString(Constants.USER_PASSWORD));
	user.setName(rs.getString(Constants.USER_NAME));
	user.setSurname(rs.getString(Constants.USER_SURNAME));
	user.setBlocked(rs.getBoolean(Constants.USER_BLOCKED));
	user.setRole(rs.getString(Constants.USER_ROLE));
	return user;
    }
}
