package com.epam.koval.carrent.db.entity;

/**
 * Constants role user.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public enum Role {
    /** Role admin. */
    admin,
    /** Role manager. */
    manager,
    /** Role client. */
    client;

    /**
     * Get`s name role.
     * 
     * @return string
     */
    public String getName() {
	return name().toLowerCase();
    }
}
