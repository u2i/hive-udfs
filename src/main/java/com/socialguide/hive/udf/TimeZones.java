package com.socialguide.hive.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.HashMap;

public final class TimeZones extends UDF {
    private HashMap<Integer, String> symbols;

    public TimeZones() {
        symbols = new HashMap<Integer, String>();
        symbols.put(1, "EST5EDT");
        symbols.put(2, "CST6CDT");
        symbols.put(3, "MST7MDT");
        symbols.put(4, "PST8PDT");
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
