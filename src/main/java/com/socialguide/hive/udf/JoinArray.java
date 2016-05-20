package com.socialguide.hive.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.ArrayList;

public final class JoinArray extends UDF {
    public String evaluate(final ArrayList<String> array) {
        return evaluate(array, ",");
    }

    public String evaluate(final ArrayList<String> array, String separator) {
        String listString = "";
        for (String s : array) {
            if (listString == "")
                listString = s;
            else
                listString += separator + s;
        }
        return listString;
    }
}
