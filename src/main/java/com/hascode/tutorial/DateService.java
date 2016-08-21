package com.hascode.tutorial;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateService {
    public String getDate() {
        return getDate("yyyy-MM-dd");
    }

    public String getDate(String dateFormat) {
        ZonedDateTime dt = ZonedDateTime.now();
        return String.format("In %s it's %s", dt.getZone(), dt.format(DateTimeFormatter.ofPattern(dateFormat)));
    }
}
