package com.jamieflood.springboot.service;

import com.jamieflood.springboot.model.User;

public interface UserService {

	void save(User user);

	User findByUsername(String username);
}
