package com.epam.koval.carrent.web.bean;

import java.io.Serializable;

/**
 * User bean.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
/**
 * @author Koval Dmitry
 * @version 1.0
 */
public final class UserBean implements Serializable {

    /** ID. */
    private static final long serialVersionUID = 5981071081923803374L;

    /** User email. */
    private String email;

    /** Password. */
    private String password;

    /** User name. */
    private String name;

    /** User surname. */
    private String surname;

    /**
     * Constructor.
     * 
     * @param aEmail email
     * @param aPassword password
     * @param aName name
     * @param aSurname surname
     */
    public UserBean(final String aEmail, final String aPassword,
	    final String aName, final String aSurname) {
	this.email = aEmail;
	this.password = aPassword;
	this.name = aName;
	this.surname = aSurname;
    }

    /**
     * Gets the value of {@linkplain UserBean#password}.
     * 
     * @return value of {@linkplain UserBean#password}
     */
    public final String getPassword() {
	return password;
    }

    /**
     * Sets {@linkplain UserBean#password} with new value.
     * 
     * @param password new value for {@linkplain UserBean#password}
     */
    public final void setPassword(String password) {
	this.password = password;
    }

    /**
     * Gets the value of {@linkplain UserBean#email}.
     * 
     * @return value of {@linkplain UserBean#email}
     */
    public String getEmail() {
	return email;
    }

    /**
     * Sets {@linkplain UserBean#email} with new value.
     * 
     * @param aEmail new value for {@linkplain UserBean#email}
     */
    public void setEmail(final String aEmail) {
	this.email = aEmail;
    }

    /**
     * Gets the value of {@linkplain UserBean#name}.
     * 
     * @return value of {@linkplain UserBean#name}
     */
    public String getName() {
	return name;
    }

    /**
     * Sets {@linkplain UserBean#name} with new value.
     * 
     * @param aName new value for {@linkplain UserBean#name}
     */
    public void setName(final String aName) {
	this.name = aName;
    }

    /**
     * Gets the value of {@linkplain UserBean#surname}.
     * 
     * @return value of {@linkplain UserBean#surname}
     */
    public String getSurname() {
	return surname;
    }

    /**
     * Sets {@linkplain UserBean#surname} with new value.
     * 
     * @param aSurname new value for {@linkplain UserBean#surname}
     */
    public void setSurname(final String aSurname) {
	this.surname = aSurname;
    }
}
