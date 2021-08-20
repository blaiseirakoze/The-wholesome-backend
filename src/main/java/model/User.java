package model;

import enumerator.EROLE;
import enumerator.ESEX;

import java.util.UUID;

/**
 * blaise irakoze
 */
public class User {
	private String id = UUID.randomUUID().toString();
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private int age;
	private ESEX sex;
	private String phoneNumber;
	private EROLE role;
	private String type;

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public User() {
		super();
	}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(String id, String username, String password, String firstName, String lastName, int age, ESEX sex, String phoneNumber, EROLE role, String type) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.type = type;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public ESEX getSex() {
		return sex;
	}

	public void setSex(ESEX sex) {
		this.sex = sex;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public EROLE getRole() {
		return role;
	}

	public void setRole(EROLE role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", age=" + age + ", sex=" + sex + ", phoneNumber=" + phoneNumber
				+ ", role=" + role + "]";
	}
	
}
