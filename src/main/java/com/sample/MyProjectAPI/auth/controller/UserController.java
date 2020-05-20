package com.sample.MyProjectAPI.auth.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.MyProjectAPI.auth.service.AuthServiceInterface;
import com.sample.MyProjectAPI.models.Users;
import com.sample.MyProjectAPI.repository.UserRepository;
import com.sample.MyProjectAPI.util.ApiResponse;
import com.sample.MyProjectAPI.util.HttpResponseUtil;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepository userRepository;
//	@Autowired
//	AuthServiceInterface authService;
	@Autowired
	HttpResponseUtil httpResponse;
	@Autowired
	AuthServiceInterface authService;

	// Get All Notes
	@GetMapping("/getAllUsers")
	public	List<Users>
			getAllUsers() {
		System.out.println("Hello World");
		return userRepository.findAll();
	}

//	public	ResponseEntity<ApiResponse>
//			getAllUsersByEmail(	HttpSession session,
//								@RequestParam(name = "Email") String email)
//					throws Exception {
//		ApiResponse resp = authService.getAllUsersByEmail();
//		return httpResponse.getResponse(resp);
//	}
	@PostMapping("/getUserByEmailAndPassword")
	public	ResponseEntity<ApiResponse>
			getuserByEmailAndPassword(	HttpSession session,
										@RequestParam(name = "email") String email,
										@RequestParam(name = "password") String password)
					throws Exception {
		ApiResponse resp = authService.getUserByEmailAndPassword(email, password);
		return httpResponse.getResponse(resp);
	}

	// save user
	@PostMapping("/saveUserDetails")
	public	ResponseEntity<ApiResponse>
			saveUserDetails(HttpSession session,
							@RequestParam(name = "firstname") String fname,
							@RequestParam(name = "lastname") String lname,
							@RequestParam(name = "email") String email,
							@RequestParam(name = "password") String password)
					throws Exception {
		ApiResponse resp = authService.saveUserDetails(fname,lname,email,password);
		return httpResponse.getResponse(resp);
	}
	
	//Forgot password
		@PostMapping("/forgotPassword")
		public	ResponseEntity<ApiResponse>
				forgotPassword(HttpSession session,
								@RequestParam(name = "email") String email)
						throws Exception {
			ApiResponse resp = authService.forgotPassword(email);
			return httpResponse.getResponse(resp);
		}
}
