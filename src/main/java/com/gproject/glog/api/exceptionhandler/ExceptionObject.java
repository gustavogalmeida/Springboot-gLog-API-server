package com.gproject.glog.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionObject {
	
	private String title;
	private LocalDateTime dateTime;
	private Integer status;
	private List<Field> fields;
	
	@Getter
	@AllArgsConstructor
	public static class Field{
		private String name;
		private String description;
	}
}
