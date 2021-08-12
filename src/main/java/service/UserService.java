package service;

import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserService {
	
	List<User> users = new ArrayList<User>();
	public List<User> getUsers() {
		 return users;
	}
	
	public List<User> addUser(User user) {
		users.add(user);
		System.out.println("resssssssssss \n"+ users);
		return users;
	}

}
