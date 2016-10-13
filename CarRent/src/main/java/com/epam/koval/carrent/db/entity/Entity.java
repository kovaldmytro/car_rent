package com.epam.koval.carrent.db.entity;

import java.io.Serializable;

/**
 * Abstract entity.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public abstract class Entity implements Serializable {
    /** ID. */
    private static final long serialVersionUID = -7697222865497884931L;

    /** id. */
    private Long id;

    /**
     * Gets the value of {@linkplain Entity#id}.
     * 
     * @return value of {@linkplain Entity#id}
     */
    public final Long getId() {
	return id;
    }

    /**
     * Sets {@linkplain Entity#id} with new value.
     * 
     * @param aId new value for {@linkplain Entity#id}
     */
    public final void setId(final Long aId) {
	this.id = aId;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Entity [id=");
	builder.append(id);
	builder.append("]");
	return builder.toString();
    }

}
