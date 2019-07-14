package com.qifeixianapp.qfxdemo.tool;

public class MonthOfDayUnit {
    public static int getMonthOfDays(int year,int month){
        int day = 0;
        if(year%4==0&&year%100!=0||year%400==0){
            day = 29;
        }else{
            day = 28;
        }
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return day;

        }

        return 0;
    }
}
