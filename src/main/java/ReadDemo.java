import algorithm.FileUtils;

import java.io.*;

/**
 * Created by longshihan on 2016/12/26.
 */
public class ReadDemo {
    static String a = "E:\\a.docx";
    static String b = "E:\\b.docx";

    public static void main(String args[]) {

        //readFile();
        //readFile1();
        readFile2();
    }

    private static void readFile2() {
        try {
            byte[] bb = FileUtils.toByteArray3(a);
            FileOutputStream out = new FileOutputStream(new File(b));
            out.write(bb);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile1() {
        FileInputStream in = null;// 指定要读取的图片
        try {
            in = new FileInputStream(new File(a));
            FileOutputStream out = new FileOutputStream(new File(b));
            int n = 0;// 每次读取的字节长度
            byte[] bb = new byte[1024];// 存储每次读取的内容
            while ((n = in.read(bb)) != -1) {
                out.write(bb, 0, n);// 将读取的内容，写入到输出流当中
            }
            out.close();// 关闭输入输出流
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readFile() {
        DataInputStream fr = null;
        DataOutputStream fos = null;
        try {
            fr = new DataInputStream(
                    new BufferedInputStream(new FileInputStream(a)));
            fos = new DataOutputStream(new FileOutputStream(b, true));
            while (true) {
                fos.writeInt(fr.readInt());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
