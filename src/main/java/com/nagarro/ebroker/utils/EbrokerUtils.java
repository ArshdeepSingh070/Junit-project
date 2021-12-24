package com.nagarro.ebroker.utils;

import java.time.LocalTime;
import java.util.Calendar;

public class EbrokerUtils {

    public static String getSoldResponse() {
        return "sold successfully";
    }

    public static String getEquityBoughhtResponse(){
        return "Equity bought succesfully";
    }

    public static String getInsufficientFundResponse() {
        return "Insufficient Funds";
    }

    public static String getNoEquityHoldingResponse(){
        return "Equity to be sold is not in trader's holding";
    }

    public static String getNoSellingTimeResponse(){
        return "can not sell at this time";
    }

    public static String getNoBuyingTimeResponse(){
        return "can not buy at this time";
    }

    public static boolean checkForWeekDay(){
        Calendar currentDate = Calendar.getInstance();
        int dayOfWeek = currentDate.get (Calendar.DAY_OF_WEEK);
        boolean isWeekday = ((dayOfWeek >= Calendar.MONDAY) && (dayOfWeek <= Calendar.FRIDAY));
        if(!isWeekday){
            return false;
        }
        return true;
    }

    public static boolean checkForTime() {

        LocalTime morning = LocalTime.of(9, 0, 0);
        LocalTime evening = LocalTime.of(18, 0, 0);

        LocalTime nowTime = LocalTime.now();

        if (nowTime.isAfter(morning) && nowTime.isBefore(evening)) {
            return true;
        } else {
            return false;
        }
    }
}
