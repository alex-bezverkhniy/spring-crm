package org.alexbezverkhniy.springcrm.core.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.AbstractPersistable;

public abstract class BaseEntity<PK extends Serializable> extends AbstractPersistable<PK> {

	private static final long serialVersionUID = -962446085427189481L;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date created;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastModified;
	
	public BaseEntity() {
		this(new Date(), new Date());		
	}

	public BaseEntity(Date created, Date lastModified) {
		this.created = created;
		this.lastModified = lastModified;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}	
}
