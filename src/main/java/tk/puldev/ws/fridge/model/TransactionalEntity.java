package tk.puldev.ws.fridge.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class TransactionalEntity implements Serializable {

	private static final long serialVersionUID = -4375332056374080529L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String referenceId = UUID.randomUUID().toString();
	
	@Version
	private Integer version;
	
	@NotNull
	private String createdBy;
	
	@NotNull
	private Date createdAt;
	
	private String updatedBy;
	
	private Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpodatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date upodatedAt) {
		this.updatedAt = upodatedAt;
	}

	@Override
	public int hashCode() {
		if (this.id == null) {
			return -1;
		}
		return this.getId().hashCode();
	}

	@Override
	public boolean equals(Object that) {
		if(that == null) {
			return false;
		}
		if (this.getClass() == that.getClass()) {
			TransactionalEntity thatTE = (TransactionalEntity) that;
			if(this.getId() == null || thatTE.getId() == null) {
				return false;
			}
			if(this.getId().equals(thatTE.getId())) {
				return true;
			}
			
		}
		return false;
	}
	
	@PrePersist
	public void beforePersist() {
		setCreatedAt(new Date());
	}
	
	@PreUpdate
	public void beforeUpdate() {
		setUpdatedAt(new Date());
	}
}

