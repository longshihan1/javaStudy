package nio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class ZIPUtil {
    /**
     * @Title: compressByte
     * @author ZX
     * @param param
     * @return byte[]
     * @throws IOException
     */

    public static byte[] compressByte(String param) throws IOException {
        if (param == null || param.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteOut = null;
        GZIPOutputStream gzipOut = null;
        byte[] outPut = null;
        try {
            // 開啟數據輸出流,關閉無效
            byteOut = new ByteArrayOutputStream();
            // 開啟數據壓縮流
            gzipOut = new GZIPOutputStream(byteOut);
            // 將字串轉換成字節，然後按照ＵＴＦ－８的形式壓縮
            gzipOut.write(param.getBytes("UTF-8"));
            // 壓縮完畢
            gzipOut.finish();
            gzipOut.close();
            // 將壓縮好的流轉換到byte數組中去
            outPut = byteOut.toByteArray();
            byteOut.flush();
            byteOut.close();
        } finally {
            if (byteOut != null) {
                byteOut.close();
            }
        }
        return outPut;
    }

    /**
     * @Title: uncompressByte
     * @author ZX
     * @param param
     * @return byte[]
     * @throws IOException
     */
    public static String uncompressByte(byte[] param) throws IOException {
        ByteArrayOutputStream out = null;
        ByteArrayInputStream in = null;
        GZIPInputStream gzip = null;
        byte[] b = null;
        try {
            // 創建輸出流
            out = new ByteArrayOutputStream();
            // 創建輸入流,並把傳入的字串參數轉碼成ISO-8895-1
            in = new ByteArrayInputStream(param);
            // 創建壓縮輸入流，將大小默認為參數輸入流大小
            gzip = new GZIPInputStream(in);
            // 創建byte數組用於接收解壓後的流轉化成byte數組
            byte[] byteArry = new byte[256];
            int n = -1;
            while ((n = gzip.read(byteArry)) != -1) {
                out.write(byteArry, 0, n);
            }
            // 轉換數據
            b = out.toByteArray();
            out.flush();
        } finally {
            // 關閉壓縮流資源
            if(out != null)
                out.close();
            if(gzip != null)
                gzip.close();
            if(in != null)
                in.close();
        }
        return new String(b,"UTF-8");
    }


    public static String unZIPcompressByte(byte[] param) throws IOException {

        // 创建一个新的 byte 数组输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // 创建一个 ByteArrayInputStream，使用 buf 作为其缓冲区数组
        ByteArrayInputStream in = new ByteArrayInputStream(param);
        // 使用默认缓冲区大小创建新的输入流
        GZIPInputStream gzip = new GZIPInputStream(in);
        byte[] buffer = new byte[256];
        int n = 0;
        while ((n = gzip.read(buffer)) >= 0) {// 将未压缩数据读入字节数组
            // 将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此 byte数组输出流
            out.write(buffer, 0, n);
        }
        // 使用指定的 charsetName，通过解码字节将缓冲区内容转换为字符串
        return out.toString("UTF-8");
    }

    public static String stream2String(InputStream is) {
        // TODO Auto-generated method stub
        //在读取的过程中，将读取的内容存储在缓存中，然后一次性的转化成字符串返回
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //读流
        byte[] buffer =new byte[1024];
        int temp=-1;
        try {
            while((temp = is.read(buffer))!=-1){
                bos.write(buffer,0,temp);
            }
            return bos.toString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                is.close();
                bos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;

    }


}
