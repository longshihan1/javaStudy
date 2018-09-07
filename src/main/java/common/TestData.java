package common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dell on 2017/4/20.
 */
public class TestData {

    public static void main(String args[]) {
        System.out.println(" "+System.currentTimeMillis());
        Date d = new Date(Long.parseLong("1492654354000"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(" "+sdf.format(d));

        List<String> ls=new ArrayList<>();
        ls.add("1");
        ls.add("2");
        ls.add("3");
        ls.add("4");
        ls.add("5");
        System.out.println(" "+ls.toString());

        System.out.println(" "+(315&((1<<6)-1))+":"+(315%(1<<6))+":"+(1<<8));
    }
}
