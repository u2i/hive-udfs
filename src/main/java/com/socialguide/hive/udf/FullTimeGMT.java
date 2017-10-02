package com.socialguide.hive.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.text.ParseException;

public final class FullTimeGMT extends UDF {
    public String evaluate(final String dateTime) {
        DateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        inputDateFormat.setTimeZone(timeZone);
        outputDateFormat.setTimeZone(timeZone);

        Date dt = null;
        try {
            dt = inputDateFormat.parse(dateTime);
        } catch (ParseException e) {
            return "";
        }
        return outputDateFormat.format(dt);
    }
}
