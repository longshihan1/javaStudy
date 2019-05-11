package match;

public class TestMatch {


    public static boolean matchesStr(String str) {
        String rex = "[\u4e00-\u9fa5]+|[a-zA-Z]+";// 匹配纯中文或纯英文
        if ( str.matches(rex)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean matchesStr1(String str) {
        String rex = "[\u4e00-\u9fa5]{1,6}+|[a-zA-Z]{1,50}+";// 匹配纯中文或纯英文
        if ( str.matches(rex)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean matchesStr2(String str) {
        String rex = "[0-9]{4}";// 匹配纯中文或纯英文
        if ( str.matches(rex)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String args[]){

        String str="";

        System.out.println(""+matchesStr1("asaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaa")+str.trim());
    }
}
