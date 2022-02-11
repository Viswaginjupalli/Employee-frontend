package com.employeeproject.Employee.util;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
/**
 * 
 * CustomResponse to be send in responseEntity
 *
 * @param <T>
 */
public class CustomResponse<T> {
	private LocalDateTime time;
	private HttpStatus httpStatus;
	private String message;
	private T data;
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
