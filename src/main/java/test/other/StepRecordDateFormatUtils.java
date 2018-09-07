package test.other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 步数记录时间格式化工具类
 * Created by zhuliyuan on 2017/8/25.
 */

public class StepRecordDateFormatUtils {

    public static String formatDaily(String date) {
        String result = "";

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date currentDate = dateFormat.parse(date);

            Calendar current = Calendar.getInstance();//当前时间
            current.setTime(currentDate);

            Calendar today = Calendar.getInstance();//今天
            today.set(Calendar.HOUR_OF_DAY, 0);
            today.set(Calendar.MINUTE, 0);
            today.set(Calendar.SECOND, 0);

            Calendar yesterday = Calendar.getInstance();//昨天
            yesterday.add(Calendar.DAY_OF_YEAR, -1);
            yesterday.set(Calendar.HOUR_OF_DAY, 0);
            yesterday.set(Calendar.MINUTE, 0);
            yesterday.set(Calendar.SECOND, 0);

            if (current.compareTo(today) >= 0) {//今天
                result = "今天";
            } else if (current.compareTo(yesterday) >= 0) {//昨天
                result = "昨天";
            } else {//之前
                result = new SimpleDateFormat("M/d").format(currentDate);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String formatWeek(Date  currentDate) {
        String result = "";

        try {
            //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
           // Date currentDate = dateFormat.parse(date);

            Calendar current = Calendar.getInstance();//当前时间
            current.setTime(new Date());

            Calendar thisWeek = Calendar.getInstance();//本周
            thisWeek.add(Calendar.DAY_OF_YEAR, -thisWeek.get(Calendar.DAY_OF_WEEK) + 1);
            thisWeek.set(Calendar.HOUR_OF_DAY, 0);
            thisWeek.set(Calendar.MINUTE, 0);
            thisWeek.set(Calendar.SECOND, 0);

            Calendar lastWeek = Calendar.getInstance();//上周
            lastWeek.add(Calendar.DAY_OF_YEAR, -thisWeek.get(Calendar.DAY_OF_WEEK) + 1);
            lastWeek.add(Calendar.WEEK_OF_YEAR, -1);
            lastWeek.set(Calendar.HOUR_OF_DAY, 0);
            lastWeek.set(Calendar.MINUTE, 0);
            lastWeek.set(Calendar.SECOND, 0);

            if (current.compareTo(lastWeek) >= 0) {//本周
                result = "本周";
            } else if (current.compareTo(thisWeek) >= 0) {//上周
                result = "上周";
            } else {//之前
                result = new SimpleDateFormat("M/d当周").format(currentDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String formatMonth(String date) {
        String result = "";

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M");
            Date currentDate = dateFormat.parse(date);

            Calendar current = Calendar.getInstance();//当前时间
            current.setTime(currentDate);

            Calendar currentMonth = Calendar.getInstance();//本月
            currentMonth.add(Calendar.DAY_OF_YEAR, -currentMonth.get(Calendar.DAY_OF_MONTH) + 1);
            currentMonth.set(Calendar.HOUR_OF_DAY, 0);
            currentMonth.set(Calendar.MINUTE, 0);
            currentMonth.set(Calendar.SECOND, 0);

            Calendar lastMonth = Calendar.getInstance();//上月
            lastMonth.add(Calendar.DAY_OF_YEAR, -lastMonth.get(Calendar.DAY_OF_WEEK) + 1);
            lastMonth.add(Calendar.MONTH, -1);
            lastMonth.set(Calendar.HOUR_OF_DAY, 0);
            lastMonth.set(Calendar.MINUTE, 0);
            lastMonth.set(Calendar.SECOND, 0);

            if (current.compareTo(currentMonth) >= 0) {//本月
                result = "本月";
            } else if (current.compareTo(lastMonth) >= 0) {//上月
                result = "上月";
            } else {//之前
                result = new SimpleDateFormat("yy年M月").format(currentDate);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
