package com.qifeixianapp.qfxdemo.tool;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class GetTImeDay {
    public    String getWeek() {
        Calendar cal = Calendar.getInstance();
        int i = cal.get(Calendar.DAY_OF_WEEK);
        switch (i) {
            case 1:
                return "星期日";
            case 2:
                return "星期一";
            case 3:
                return "星期二";
            case 4:
                return "星期三";
            case 5:
                return "星期四";
            case 6:
                return "星期五";
            case 7:
                return "星期六";
            default:
                return "";
        }
    }
    public List<Integer> getListWeek(List<String> ListStr)  {

        List<Integer> ListWeek=new ArrayList<>();
        for (int i = 0; i <ListStr.size() ; i++) {
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date myDate2 = null;
            try {
                myDate2 = dateFormat2.parse(ListStr.get(i));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar calendar=Calendar.getInstance();
            calendar.setTime(myDate2);
            int j = calendar.get(Calendar.DAY_OF_WEEK);
            int day;
            switch (j) {
                case 1:
                    day= 6;
                    break;
                case 2:
                    day= 0; break;
                case 3:
                    day=  1; break;
                case 4:
                     day= 2; break;
                case 5:
                    day= 3; break;
                case 6:
                    day=  4; break;
                case 7:
                    day=5; break;
                default:
                    day=6; break;
            }
            ListWeek.add(day);
            day=7;
        }
        return ListWeek;


    }
}
