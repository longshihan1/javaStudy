package algorithm;


import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by dell on 2017/2/7.
 * 查找出现次数最多的单词,少量数据
 */
public class Quicksort {

    static String a = "E:\\a.txt";

    public static void main(String args[]) {
        String content = readFile2();
        Map<String, Integer> map = new TreeMap<String, Integer>();
        Addword(content, map);
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return (o2.getValue().compareTo(o1.getValue()));//降序排序
            }
        });
        for (int j = 0; j < 10; j++) {
            System.out.println((String) list.get(j).getKey() + ":" + list.get(j).getValue());
        }
    }


    private static void Addword(String str, Map<String, Integer> map) {
        str = str.toLowerCase();
        String[] lists = str.split(" ");
        CopyOnWriteArrayList<String> userList = new CopyOnWriteArrayList<String>();
        Collections.addAll(userList, lists);
        for (int i = 0; i < userList.size(); i++) {
            String currentStr = userList.get(i);
            if (currentStr.contains("\r\n")) {
                String[] currentStrs = currentStr.split("\r\n");
                if (currentStrs.length > 1) {
                    if ("".equals(currentStrs[0])){
                        currentStr = currentStr.replace("\r\n","");
                    }else {
                        userList.add(currentStrs[1]);
                        currentStr = currentStrs[0];
                    }
                }
                if (currentStrs.length==1) {
                    currentStr = currentStr.replace("\r\n","");
                }

            }
            if (currentStr.contains(":")) {
                currentStr.replace(":", "");
            }
            if (currentStr.contains("\"")) {
                currentStr.replace("\"", "");
            }
            if (currentStr.contains("\\.")) {
                currentStr.replace("\\.", "");
            }
            Integer count = map.get(currentStr);
            if (count == null) {
                map.put(currentStr, 1);
            } else {
                map.put(currentStr, count + 1);
            }
        }
    }

    public static boolean isCharacter(int tmpchar)//判断是否是字母
    {
        if (tmpchar >= 65 && tmpchar <= 90) {
            return true;
        } else if (tmpchar >= 97 && tmpchar <= 122) {
            return true;
        }
        return false;
    }

    private static String readFile2() {

        try {
            byte[] bb = FileUtils.toByteArray3(a);
            return new String(bb, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "0";
    }
}
