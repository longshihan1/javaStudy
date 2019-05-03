package mmap;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * mmap模式入口
 */
public class MMapMain {
    private static int length = 10240*1024;

    private abstract static class Tester {
        private String name;

        public Tester(String name) {
            this.name = name;
        }

        public void runTest() {
            System.out.print(name + ": ");
            long start = System.currentTimeMillis();
            test();
            System.out.println(System.currentTimeMillis() - start + " ms");
        }

        public abstract void test();
    }

    private static Tester[] testers = {
            new Tester("Stream RW") {
                public void test() {
                    try (FileInputStream fis = new FileInputStream(
                            "src/a.txt");
                         DataInputStream dis = new DataInputStream(fis);
                         FileOutputStream fos = new FileOutputStream(
                                 "src/a.txt");
                         DataOutputStream dos = new DataOutputStream(fos);) {

                        byte b = (byte) 0;
                        for (int i = 0; i < length; i++) {
                            dos.writeByte(b);
                            dos.flush();
                        }
                        while (dis.read() != -1) {
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            },
            new Tester("Mapped RW") {
                public void test() {
                    try (FileChannel channel = FileChannel.open(Paths.get("src/b.txt"),
                            StandardOpenOption.READ, StandardOpenOption.WRITE);) {
                        MappedByteBuffer mapBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, length);
                        for (int i = 0; i < length; i++) {
                            mapBuffer.put((byte) 0);
                        }
                        mapBuffer.flip();
                        while (mapBuffer.hasRemaining()) {
                            mapBuffer.get();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            },
            new Tester("Mapped PRIVATE") {
                public void test() {
                    try (FileChannel channel = FileChannel.open(Paths.get("src/c.txt"),
                            StandardOpenOption.READ, StandardOpenOption.WRITE);) {
                        MappedByteBuffer mapBuffer = channel.map(FileChannel.MapMode.PRIVATE, 0, length);
                        for (int i = 0; i < length; i++) {
                            mapBuffer.put((byte) 0);
                        }
                        mapBuffer.flip();
                        while (mapBuffer.hasRemaining()) {
                            mapBuffer.get();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
    };


    private static void putSomeThing(){
        try (FileChannel channel = FileChannel.open(Paths.get("src/c.txt"),
                StandardOpenOption.READ, StandardOpenOption.WRITE);) {
            String str="CSAC三大城市的吃的撒吃的撒吃的撒成都三";
            Charset charset=Charset.forName("GBK");
            charset.encode(str);
            byte[] bytes = str.getBytes();
            MappedByteBuffer mapBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, bytes.length);
            mapBuffer.put(charset.encode(str));
            mapBuffer.flip();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile1() throws IOException
    {

        FileChannel channel = FileChannel.open(Paths.get("src/c.txt"),
                StandardOpenOption.READ, StandardOpenOption.WRITE);
        MappedByteBuffer mbb = channel.map(FileChannel.MapMode.READ_WRITE, 0, channel.size());
        byte dst[] = new byte[(int) channel.size()];
        while(mbb.hasRemaining()) {
            mbb.get(dst,0,mbb.remaining());
        }
        System.out.println(new String(dst));
    }

    public static void main(String[] args) {
        File aFile = new File("src/a.txt");
        File bFile = new File("src/b.txt");
        File cFile = new File("src/c.txt");
        try {
            if (!aFile.exists()) {
                aFile.createNewFile();
            }
            if (!bFile.exists()) {
                bFile.createNewFile();
            }
            if (!cFile.exists()) {
                cFile.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        putSomeThing();
//        try {
//            readFile1();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        for (Tester tester : testers) {
//            tester.runTest();
//        }
    }
}
