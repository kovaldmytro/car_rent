package com.epam.koval.carrent.bl.util;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;

/**
 * Rent cost.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public final class SumRent {
    /** Translate in day. */
    private static final int TRANSLATE = 86400000;

    /**
     * Hidden Constructor.
     */
    private SumRent() {

    }

    /**
     * Summing rent.
     * 
     * @param start start date
     * @param end end date
     * @param cost cost
     * @return amount of days
     */
    public static BigDecimal sum(final Date start, final Date end,
	    final BigDecimal cost) {
	Calendar st = Calendar.getInstance();
	st.setTimeInMillis(start.getTime());
	Calendar fin = Calendar.getInstance();
	fin.setTimeInMillis(end.getTime());
	Long res = (fin.getTimeInMillis() - st.getTimeInMillis()) / (TRANSLATE);
	if (res == 0) {
	    res = 1L;
	}
	return new BigDecimal(res).multiply(cost);
    }
}
