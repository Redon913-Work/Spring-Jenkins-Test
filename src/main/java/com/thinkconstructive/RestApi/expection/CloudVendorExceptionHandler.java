package com.thinkconstructive.RestApi.expection;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CloudVendorExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { CloudVendorNotFoundExpection.class })
	public ResponseEntity<Object> handleCVNotFoundExpection(CloudVendorNotFoundExpection cloudVendorNotFoundExpection) {
		CloudVendorException cloudVendorException = new CloudVendorException(cloudVendorNotFoundExpection.getMessage(),
				cloudVendorNotFoundExpection.getCause(), HttpStatus.NOT_FOUND);

		return new ResponseEntity<Object>(cloudVendorException, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Object>("Please change the Request Type", HttpStatus.NOT_FOUND);
	}
}
