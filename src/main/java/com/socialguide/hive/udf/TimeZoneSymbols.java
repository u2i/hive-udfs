package com.socialguide.hive.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.HashMap;
import java.util.ArrayList;

public final class TimeZoneSymbols extends UDF {
    private HashMap<Integer, String> symbols;

    //1 ET > 4 PT > 2 CT > 3 MT > 0 default(PT)
    private int[] priorities = {5, 1, 2, 3, 4, 1, 1, 5, 3, 2, 4};

    public TimeZoneSymbols() {
        symbols = new HashMap<Integer, String>();
        symbols.put(0, "PST8PDT");
        symbols.put(1, "EST5EDT");
        symbols.put(2, "CST6CDT");
        symbols.put(3, "MST7MDT");
        symbols.put(4, "PST8PDT");
        symbols.put(5, "Europe/Rome");
        symbols.put(6, "Australia/Sydney");
        symbols.put(7, "Australia/Brisbane");
        symbols.put(8, "Australia/Adelaide");
        symbols.put(9, "Australia/Melbourne");
        symbols.put(10, "Australia/Perth");
        symbols.put(11, "America/Mexico_City");
    }

    public String evaluate(final ArrayList<Integer> timezoneIds) {
        int selectedTimezoneId = timezoneIds.remove(0);

        for (int timezoneId : timezoneIds) {
            if (priorities[timezoneId] < priorities[selectedTimezoneId]) {
                selectedTimezoneId = timezoneId;
            }
        }

        return symbols.get(selectedTimezoneId);
    }
}
