package org.masterserver.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CustomDate {
	
	public static LocalDateTime getCurrentDate() {
		return LocalDateTime.of(LocalDate.now(), LocalTime.now());
	}

}