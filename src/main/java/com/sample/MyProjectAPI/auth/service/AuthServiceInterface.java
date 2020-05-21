package com.sample.MyProjectAPI.auth.service;

import com.sample.MyProjectAPI.util.ApiResponse;

public interface AuthServiceInterface {
	/**
	 * Function for fetch all Users By Email.
	 * 
	 * @return
	 * @throws Exception
	 */
	ApiResponse getUserByEmailAndPassword(	String email,
											String password)
			throws Exception;

	ApiResponse saveUserDetails(String fname,
								String lname,
								String email,
								String password);

	ApiResponse forgotPassword(String email);

	ApiResponse updatePassword(	String email,
								String password);
}
