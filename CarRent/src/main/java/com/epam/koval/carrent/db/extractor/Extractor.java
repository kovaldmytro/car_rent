package com.epam.koval.carrent.db.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Extractor interface.
 * 
 * @author Koval Dmitry
 * @version 1.0
 * @param <T> param
 */
public interface Extractor<T> {
    /**
     * Extracts bean from result set.
     * 
     * @param rs result set to extract from
     * @return bean object
     * @throws SQLException {@linkplain SQLException}
     */
    T extract(ResultSet rs) throws SQLException;
}
