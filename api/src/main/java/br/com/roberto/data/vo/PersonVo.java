package br.com.roberto.data.vo;

import java.io.Serializable;






public class PersonVo implements Serializable{

	


	private static final long serialVersionUID = 1L;
	
	private long id;
	
	
	private String first_name;
	
	private String lastName;
	
	private String address;
	
	private String gender;
	
	private boolean enabled;
	
	
	public PersonVo() {
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFistName() {
		return first_name;
	}


	public void setFistName(String fistName) {
		this.first_name = fistName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonVo other = (PersonVo) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (enabled != other.enabled)
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "PersonVo [id=" + id + ", fistName=" + first_name + ", lastName=" + lastName + ", address=" + address
				+ ", gender=" + gender + ", enabled=" + enabled + "]";
	}


	
	

}
