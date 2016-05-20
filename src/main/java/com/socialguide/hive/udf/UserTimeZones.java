package com.socialguide.hive.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.HashMap;

public final class UserTimeZones extends UDF {
    private HashMap<Integer, String> symbols;

    public UserTimeZones() {
        symbols = new HashMap<Integer, String>();
        symbols.put(1, "Eastern Time (US & Canada)");
        symbols.put(2, "Central Time (US & Canada)");
        symbols.put(3, "Mountain Time (US & Canada)");
        symbols.put(4, "Pacific Time (US & Canada)");
        symbols.put(5, "Europe/Rome");
        symbols.put(6, "Australia/Sydney");
        symbols.put(7, "Australia/Brisbane");
        symbols.put(8, "Australia/Adelaide");
        symbols.put(9, "Australia/Darwin");
        symbols.put(10, "Australia/Perth");
        symbols.put(11, "America/Mexico_City");
    }

    public String evaluate(final Integer timezoneId) {
        if (timezoneId > 0)
            return symbols.get(timezoneId);
        else
            return "NULL";
    }
}
