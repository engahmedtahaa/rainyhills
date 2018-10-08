/**
 * 
 */
package com.crxmarkets.rainyhills.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.crxmarkets.rainyhills.util.Defect;

/**
 * This for Handling any Exceptions occurs in our APP and return code and our
 * custom Exception
 * 
 * @author AhmedTaha
 *
 */
@RestController
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RainyHillsExceptionHandler {
	@ExceptionHandler({ Throwable.class })
	public ResponseEntity<Defect> handleException(Throwable thr) {
		return new ResponseEntity<Defect>(getDefect(thr),
				(thr instanceof RainyHillsException) ? HttpStatus.valueOf(((RainyHillsException) thr).getCode())
						: HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private Defect getDefect(Throwable thr) {
		Defect defect = new Defect();
		do {
			defect.setMessage(thr.getMessage());
			thr = thr.getCause();
		} while (thr != null);

		return defect;
	}
}
