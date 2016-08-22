package com.agl.au.bean;

import java.util.List;

import com.agl.au.bean.Pet;


/**
 * @author Gini
 * This is a Owner class
 */
public class Owner {
	private String name;
	private String gender;
	private long age;
	private List<Pet> petsList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public List<Pet> getPetsList() {
		return petsList;
	}

	public void setPetsList(List<Pet> petsList) {
		this.petsList = petsList;
	}

	@Override
	public String toString() {
		return "Owner [name=" + name + ", gender=" + gender + ", age=" + age
				+ ", petsList=" + petsList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (age ^ (age >>> 32));
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((petsList == null) ? 0 : petsList.hashCode());
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
		Owner other = (Owner) obj;
		if (age != other.age)
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (petsList == null) {
			if (other.petsList != null)
				return false;
		} else if (!petsList.equals(other.petsList))
			return false;
		return true;
	}
	
	
	
	

}
