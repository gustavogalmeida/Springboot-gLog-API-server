package com.gproject.glog.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.format.datetime.standard.DateTimeContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gproject.glog.domain.exception.BusinessException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<ExceptionObject.Field> fields = new ArrayList<>();
		
		for (ObjectError er : ex.getBindingResult().getAllErrors()) {
			String field = ((FieldError) er).getField();
			String message = messageSource.getMessage(er, LocaleContextHolder.getLocale());
			
			fields.add(new ExceptionObject.Field(field, message));
		}
		
		ExceptionObject error = new ExceptionObject();
		error.setTitle("One or more fields is invalid.");
		error.setDateTime(LocalDateTime.now());
		error.setStatus(status.value());
		
		error.setFields(fields);
		
		return handleExceptionInternal(ex, error, headers, status, request);
	}
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Object> handleBusiness(BusinessException ex, WebRequest webRequest){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		ExceptionObject error = new ExceptionObject();
		
		error.setStatus(status.value());
		error.setDateTime(LocalDateTime.now());
		error.setTitle(ex.getMessage());
		
		return handleExceptionInternal(ex, error, new HttpHeaders(), status, webRequest);
	}
	
}
