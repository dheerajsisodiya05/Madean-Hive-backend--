package com.madeanhive.service;

import com.madeanhive.exception.UserException;
import com.madeanhive.model.User;

public interface UserService {

	public User findUserProfileByJwt(String jwt) throws UserException;
	
	public User findUserByEmail(String email) throws UserException;


}
