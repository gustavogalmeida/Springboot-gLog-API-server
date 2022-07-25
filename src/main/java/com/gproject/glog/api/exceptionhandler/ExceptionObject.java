package com.gproject.glog.api.exceptionhandler;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionObject {
	private String title;
	private LocalDateTime dateTime;
	private Integer status;
}
