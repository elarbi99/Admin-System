package com.example.adminsystem;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {

    // Class to handle the date and time in the top corner of logged in screens in the application.

    // A method to get the systems current date and time.
    public String getDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(formatter.format(date));

        return formatter.format(date);
    }

}
