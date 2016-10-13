package com.epam.koval.carrent.db.entity;

import java.io.Serializable;
import com.epam.koval.carrent.web.bean.UserBean;

/**
 * User entity.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public final class User extends Entity implements Serializable {

    /** User ID. */
    private static final long serialVersionUID = 3725525124170633683L;

    /** User email. */
    private String email;

    /** User password. */
    private String password;

    /** User name. */
    private String name;

    /** User Surname. */
    private String surname;

    /** true - blocked user or false - unblocked user. */
    private boolean blocked;

    /** User role. */
    private Role role;

    /**
     * Constructor.
     */
    public User() {

    }

    /**
     * Constructor.
     * 
     * @param userBean user bean
     * @param aPassword password
     * @param aRole role
     */
    public User(UserBean userBean, final String aPassword, final Role aRole) {
	this.email = userBean.getEmail();
	this.password = aPassword;
	this.name = userBean.getName();
	this.surname = userBean.getSurname();
	this.role = aRole;
    }

    /**
     * Constructor.
     * 
     * @param email email
     * @param password password
     * @param name name
     * @param surname surname
     * @param blocked block
     * @param role role
     */
    public User(String email, String password, String name, String surname,
	    boolean blocked, Role role) {
	this.email = email;
	this.password = password;
	this.name = name;
	this.surname = surname;
	this.blocked = blocked;
	this.role = role;
    }

    /**
     * Gets the value of {@linkplain User#email}.
     * 
     * @return value of {@linkplain User#email}
     */
    public String getEmail() {
	return email;
    }

    /**
     * Sets {@linkplain User#email} with new value.
     * 
     * @param aEmail new value for {@linkplain User#email}
     */
    public void setEmail(final String aEmail) {
	this.email = aEmail;
    }

    /**
     * Gets the value of {@linkplain User#password}.
     * 
     * @return value of {@linkplain User#password}
     */
    public String getPassword() {
	return password;
    }

    /**
     * Sets {@linkplain User#password} with new value.
     * 
     * @param aPassword new value for {@linkplain User#password}
     */
    public void setPassword(final String aPassword) {
	this.password = aPassword;
    }

    /**
     * Gets the value of {@linkplain User#name}.
     * 
     * @return value of {@linkplain User#name}
     */
    public String getName() {
	return name;
    }

    /**
     * Sets {@linkplain User#name} with new value.
     * 
     * @param aName new value for {@linkplain User#name}
     */
    public void setName(final String aName) {
	this.name = aName;
    }

    /**
     * Gets the value of {@linkplain User#surname}.
     * 
     * @return value of {@linkplain User#surname}
     */
    public String getSurname() {
	return surname;
    }

    /**
     * Sets {@linkplain User#surname} with new value.
     * 
     * @param aSurname new value for {@linkplain User#surname}
     */
    public void setSurname(final String aSurname) {
	this.surname = aSurname;
    }

    /**
     * Gets the value of {@linkplain User#blocked}.
     * 
     * @return value of {@linkplain User#blocked}
     */
    public boolean isBlocked() {
	return blocked;
    }

    /**
     * Sets {@linkplain User#blocked} with new value.
     * 
     * @param aBlocked new value for {@linkplain User#blocked}
     */
    public void setBlocked(final boolean aBlocked) {
	this.blocked = aBlocked;
    }

    /**
     * Gets the value of {@linkplain User#role}.
     * 
     * @return value of {@linkplain User#role}
     */
    public Role getRole() {
	return role;
    }

    public String getRoleName() {
	return role.name();
    }

    /**
     * Sets {@linkplain User#role} with new value.
     * 
     * @param aRole new value for {@linkplain User#role}
     */
    public void setRole(final Role aRole) {
	this.role = aRole;
    }

    /**
     * Sets {@linkplain User#role} with new value.
     * 
     * @param aRole new value for {@linkplain User#role}
     */
    public void setRole(final String aRole) {
	this.role = Role.valueOf(aRole);
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("User [email=");
	builder.append(email);
	builder.append(", password=");
	builder.append(password);
	builder.append(", name=");
	builder.append(name);
	builder.append(", surname=");
	builder.append(surname);
	builder.append(", blocked=");
	builder.append(blocked);
	builder.append(", role=");
	builder.append(role);
	builder.append("]");
	return builder.toString();
    }
}
