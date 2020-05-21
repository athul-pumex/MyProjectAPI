package com.sample.MyProjectAPI.auth.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.MyProjectAPI.config.Mailer;
import com.sample.MyProjectAPI.models.Users;
import com.sample.MyProjectAPI.repository.UserRepository;
import com.sample.MyProjectAPI.util.ApiResponse;

@Service("authService")
//@Transactional(rollbackFor = Exception.class)
public class AuthServiceImpl implements AuthServiceInterface {
	@Autowired
	UserRepository userRepo;

	@Override
	public	ApiResponse
			getUserByEmailAndPassword(	String email,
										String password)
					throws Exception {
		ApiResponse resp = null;
		Users user;
		user = userRepo.findByEmailAndPassword(email, password);
		if (email.isEmpty()) {
			return resp = new ApiResponse(false, "Please provide an Email");
		} else if (password.isEmpty()) {
			return resp = new ApiResponse(false, "Please provide a Password");
		} else {
			if (null != user) {
				resp = new ApiResponse(true, "Success");
			} else {
				return resp = new ApiResponse(false, "Invalid Credentials");
			}
		}
		return resp;
	}

	public	ApiResponse
			saveUserDetails(String fname,
							String lname,
							String email,
							String password) {
		ApiResponse resp = null;
		Users user = new Users();
		Users userByEmail = new Users();
		userByEmail = userRepo.findByEmail(email);
		if (null != userByEmail) {
			return resp = new ApiResponse(true, "User already exists");
		} else {
			String id = UUID.randomUUID().toString();
			System.out.println(id.length());
			user.setId(id);
			user.setEmail(email);
			user.setFirstName(fname);
			user.setLastName(lname);
			user.setEmail(email);
			user.setPassword(password);
			Users IsSave = userRepo.save(user);
			if (null != IsSave) {
				resp = new ApiResponse(true, "User saved successfully");
			} else {
				resp = new ApiResponse(false, "Failed to save User details");
			}
		}

		return resp;
	}

	@Override
	public	ApiResponse
			forgotPassword(String email) {
		ApiResponse resp = null;

		Users userByEmail = new Users();
		userByEmail = userRepo.findByEmail(email);
		if (null != userByEmail) {
			String baseUrl = "http://localhost:8080/api/resetPassword?email=";
			String url = baseUrl + userByEmail.getEmail();

			String link = "<a href=\"" + url + "\" >Reset password</a> ";
			String message = "Hello " + userByEmail.getFirstName()
					+ ", <br> Please click on the link below to reset your password.<br> " + link;
			String status = Mailer.sendMail(userByEmail.getEmail(), "Password Reset", message);
			if (status.equals("success"))
				resp = new ApiResponse(true, "A password reset link has been sent to this mail.");
			else
				resp = new ApiResponse(false, "Failed to send email.");
		} else {
			resp = new ApiResponse(false, "User does not exist with this email address.");
		}
		return resp;
	}

	@Override
	public	ApiResponse
			updatePassword(	String email,
							String password) {
		ApiResponse resp = null;
		Users userByEmail = new Users();
		userByEmail = userRepo.findByEmail(email);
		if (null != userByEmail) {
			userByEmail.setId(userByEmail.getId());
			userByEmail.setPassword(password);
			Users IsSave = userRepo.save(userByEmail);
			if (null != IsSave) {
				resp = new ApiResponse(true, "Password updated successfully.");
			} else {
				resp = new ApiResponse(false, "Failed to update password.");
			}

		} else {
			resp = new ApiResponse(false, "Email does not exist");
		}
		return resp;
	}

}
