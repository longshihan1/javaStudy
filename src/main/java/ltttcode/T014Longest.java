package ltttcode;

public class T014Longest {
    public static void main(String[] args) {

        System.out.println(""+longestCommonPrefix(new String[]{"","b"}));
    }


    public static String longestCommonPrefix(String[] strs) {
        if (strs.length>1) {
            int length = strs[0].length();
            for (int i = 1; i < strs.length; i++) {
                if (length > strs[i].length()) {
                    length = strs[i].length();
                }
            }
            if (length>0) {
                String xxxxxx="";
                for (int i = 0; i < length; i++) {
                    char xx = strs[0].charAt(i);
                    boolean isOk = true;
                    for (int j = 1; j < strs.length; j++) {
                        if (xx != strs[j].charAt(i)) {
                            isOk = false;
                            break;
                        }
                    }
                    if (isOk) {
                        xxxxxx+=String.valueOf(xx);
                    }else {
                        break;
                    }
                }
               return xxxxxx;
            }else {
                return "";
            }

        }else if (strs.length==1){
            return strs[0];
        }else {
            return "";
        }


    }
}
