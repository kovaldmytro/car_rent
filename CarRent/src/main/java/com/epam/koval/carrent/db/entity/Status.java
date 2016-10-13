package com.epam.koval.carrent.db.entity;

/**
 * Status order.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public enum Status {
    /** Open order. */
    open,
    /** Confirm order. */
    confirm,
    /** Cancel oder. */
    cancel,
    /** Paid order. */
    paid,
    /** Close order. */
    close;

    /**
     * Get`s name role.
     * 
     * @return string
     */
    public String getName() {
	return name().toLowerCase();
    }
}
