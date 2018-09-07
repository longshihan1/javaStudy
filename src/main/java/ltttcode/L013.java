package ltttcode;

/**
 * Created by dell on 2017/4/27.
 */
public class L013 {
    public static void strStr(String source, String target) {
        // write your code here
        String[] sources=source.split("");
        String[] targets=target.split("");
        int length=0;
        for (int i = 0; i < sources.length; i++) {
            length=i;
            if (sources[length].equals(targets[0])){
                for (int j = 0; j <targets.length; j++) {
                    if (sources[length].equals(targets[j])){
                        length++;
                        continue;
                    }else {
                        continue;
                    }

                }
                System.out.println(" "+length);
            }
        }

    }

    public static void main(String args[]) {
        strStr("123456789","789");
    }
}
