package kt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class matcher {


    public static void main(String args[]) {
        System.out.println("" + strToDateType1("Date(" + System.currentTimeMillis() + ")"));
    }


    public static String strToDateType1(String dataStr) {
        String pStr = "[^0-9]";
        Pattern pattern = Pattern.compile(pStr);
        Matcher matcher = pattern.matcher(dataStr);
        String str = matcher.replaceAll("").trim();
        Long timeLong = Long.parseLong(str);
        Date date = new Date(timeLong);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strs = simpleDateFormat.format(date);
        return strs;
    }
}
