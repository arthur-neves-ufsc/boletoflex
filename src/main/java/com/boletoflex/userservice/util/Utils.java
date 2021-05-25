package com.boletoflex.userservice.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class Utils {

    private Utils() {}

    public static Locale getLocale(final String languageCode) {
        if (languageCode == null) {
            return Locale.getDefault();
        }

        final String[] lang = languageCode.split("_");
        if (lang.length == 1) {
            return new Locale(languageCode);
        } else if (lang.length == 2) {
            return new Locale(lang[0], lang[1]);
        } else {
            return Locale.getDefault();
        }
    }

	/*
	 * public static LocalDateTime toLocalDateTime(String str) { return
	 * LocalDateTime.parse(str, DateTimeFormatter.ISO_DATE_TIME); }
	 * 
	 * public static LocalDate toLocalDate(String str) { return LocalDate.parse(str,
	 * DateTimeFormatter.ISO_DATE); }
	 */
}
