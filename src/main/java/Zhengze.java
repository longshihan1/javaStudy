import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Zhengze {
    public static void main(String args[]) {
        function3();
    }

    private static void function3() {
        String string = "ss.s...8@2.2.com";
        String regex = "^[a-zA-Z0-9_-]+([A-Za-z0-9]*[-_.][A-Za-z0-9]*+)*@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.start() + "-" + matcher.end());
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    new MyThread().start();
                }
            }
        }).start();
    }

    public static class MyThread extends Thread{
        @Override
        public void run() {
           throw new NullPointerException("s");
        }
    }
}
