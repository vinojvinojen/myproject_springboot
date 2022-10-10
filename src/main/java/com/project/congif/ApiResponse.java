package com.project.congif;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ApiResponse {
private final boolean success;	
private final String message;


public String getTimeStamp() {
	return LocalDateTime.now().toString();
}
}
