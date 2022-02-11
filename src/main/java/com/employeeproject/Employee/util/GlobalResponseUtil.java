package com.employeeproject.Employee.util;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GlobalResponseUtil {
	/**
	 * Generate custom response to return in responseEntity
	 * @param time
	 * @param status
	 * @param message
	 * @param data
	 * @return
	 */
	public static <T> ResponseEntity<?> generateResponse(LocalDateTime time,HttpStatus status,String message,T data){
		CustomResponse<T> response = new CustomResponse<>();
		response.setTime(time);
		response.setHttpStatus(status);
		response.setMessage(message);
		response.setData(data);
		return new ResponseEntity<CustomResponse<T>>(response,status);	
	}
}