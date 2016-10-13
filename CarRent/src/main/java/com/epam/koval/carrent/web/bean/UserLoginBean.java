package com.epam.koval.carrent.web.bean;

import java.io.Serializable;

/**
 * User login bean.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public class UserLoginBean implements Serializable {

    /** ID. */
    private static final long serialVersionUID = 9192248475206156121L;

    /** Email. */
    private String email;

    /** Password. */
    private String password;

    /**
     * Constructor.
     * 
     * @param aEmail email
     * @param aPassword password
     */
    public UserLoginBean(final String aEmail, final String aPassword) {
	this.email = aEmail;
	this.password = aPassword;
    }

    @Override
    public final String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("UserLoginBean [email=");
	builder.append(email);
	builder.append(", password=");
	builder.append(password);
	builder.append("]");
	return builder.toString();
    }

    /**
     * Gets the value of {@linkplain UserLoginBean#email}.
     * 
     * @return value of {@linkplain UserLoginBean#email}
     */
    public final String getEmail() {
	return email;
    }

    /**
     * Sets {@linkplain UserLoginBean#email} with new value.
     * 
     * @param aEmail new value for {@linkplain UserLoginBean#email}
     */
    public final void setEmail(final String aEmail) {
	this.email = aEmail;
    }

    /**
     * Gets the value of {@linkplain UserLoginBean#password}.
     * 
     * @return value of {@linkplain UserLoginBean#password}
     */
    public final String getPassword() {
	return password;
    }

    /**
     * Sets {@linkplain UserLoginBean#password} with new value.
     * 
     * @param aPassword new value for {@linkplain UserLoginBean#password}
     */
    public final void setPassword(final String aPassword) {
	this.password = aPassword;
    }

}
