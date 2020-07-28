package com.in28minutes.rest.webservices.rest.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.in28minutes.rest.webservices.rest.bean.User;

@Repository
public class UserRepository {
	
	private static List<User> users=new ArrayList<>();
	
	private static int usersCount=3;
	
	static {
		users.add(new User(1, "David", new Date()));
		users.add(new User(2, "Myfany", new Date()));
		users.add(new User(3, "Victoria", new Date()));		
	}
	
	public List<User> getAll() {
		return users;
	}
	
	
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public User getById(int id) {
		for(User user: users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}

	public User deleteById(int id) {
		Iterator<User> iterator=users.iterator();
		while(iterator.hasNext()) {
			User user=iterator.next();
			if(user.getId()==id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
	
	
	
}
