package com.boletoflex.userservice.util;

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
}
