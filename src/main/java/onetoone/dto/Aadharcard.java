package onetoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aadharcard {
	@Id
	private int id;
	@Override
	public String toString() {
		return "Aadharcard [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	private String name;
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
