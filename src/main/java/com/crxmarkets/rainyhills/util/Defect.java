package com.crxmarkets.rainyhills.util;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * This Defect Object which thrown by Exception Handler
 * @author AhmedTaha
 *
 */
public class Defect {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private final LocalDateTime timestamp = LocalDateTime.now();
	private final Integer status = 500;
	private final String error = "Internal Server Error";
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public Integer getStatus() {
		return status;
	}
	public String getError() {
		return error;
	}
	
}