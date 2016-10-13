package com.epam.koval.carrent.db.entity;

/**
 * Constants car class.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public enum CarClass {
    /** Econom class. */
    econom,
    /** Middle class. */
    middle,
    /** Business class. */
    business;

    /**
     * Get`s name enum CarClass.
     * 
     * @return string
     */
    public String getName() {
	return name().toLowerCase();
    }
}
