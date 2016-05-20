package com.socialguide.hive.udf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

public final class DayOfWeek extends UDF {
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final Calendar calendar = Calendar.getInstance();

    private IntWritable result = new IntWritable();

    public IntWritable evaluate(Text dateString) {
        if (dateString == null) {
            return null;
        }
        try {
            Date date = formatter.parse(dateString.toString());
            calendar.setTime(date);
            result.set(calendar.get(Calendar.DAY_OF_WEEK) - 1);
            return result;
        } catch (ParseException e) {
            return null;
        }
    }
}
