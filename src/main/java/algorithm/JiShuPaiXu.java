package algorithm;


/**
 * Created by dell on 2017/2/7.
 */
public class JiShuPaiXu {
    public static void main(String args[]) {
        System.out.println("Hello World!");
        try {
            byte[] bytes1 = FileUtils.toByteArray("src/a.txt");
            byte[] bytes2 = FileUtils.toByteArray2("src/a.txt");
            byte[] bytes3 = FileUtils.toByteArray3("src/a.txt");
            System.out.println(""+new String(bytes1) + "\n" +new String(bytes2) + "\n" + new String(bytes3));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
