package com.socialguide.hive.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.HashMap;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.text.ParseException;

class DateForTimeZone extends UDF {

    public String evaluate(final String dateTime, final String timezone) {
        DateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat outputDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        TimeZone inputTimeZone = TimeZone.getTimeZone("GMT");
        TimeZone outputTimeZone = TimeZone.getTimeZone(timezone);
        inputDateFormat.setTimeZone(inputTimeZone);
        outputDateFormat.setTimeZone(outputTimeZone);

        Date dt = null;
        try {
            dt = inputDateFormat.parse(dateTime);
        } catch (ParseException e) {
            return "";
        }
        return outputDateFormat.format(dt);
    }

}
