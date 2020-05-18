package com.sample.MyProjectAPI.auth.service;

import com.sample.MyProjectAPI.util.ApiResponse;

public interface AuthServiceInterface {
	/**
	 * Function for fetch all Users By Email.
	 * 
	 * @return
	 * @throws Exception
	 */
	ApiResponse getAllUsersByEmail() throws Exception;
}
