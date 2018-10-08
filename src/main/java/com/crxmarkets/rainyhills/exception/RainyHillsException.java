/**
 * 
 */
package com.crxmarkets.rainyhills.exception;

/**
 * This our Custom Exception
 * @author AhmedTaha
 *
 */
public class RainyHillsException extends Exception {
	private static final long serialVersionUID = 1L;

	private Integer code;

	public RainyHillsException(String message) {
		super(message);
	}

	public RainyHillsException(Throwable cause) {
		super(cause);
	}

	public RainyHillsException(Integer code, String message) {
		super(message);
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public RainyHillsException(String message, Throwable cause) {
		super(message, cause);
	}

}
