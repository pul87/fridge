package tk.puldev.ws.fridge.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Refrigerator extends TransactionalEntity {
	
	private static final long serialVersionUID = -3176512090933941177L;

	@NotNull
	private String name;
	
	@Length(min=3, max=50)
	private String location;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
