package com.sample.MyProjectAPI.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("httpResponse")
public class HttpResponseUtil {
	public	ResponseEntity<ApiResponse>
			getResponse(ApiResponse resp) {
		if (resp.isError()) {
			return new ResponseEntity<ApiResponse>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<ApiResponse>(resp, HttpStatus.OK);
		}
	}
}
