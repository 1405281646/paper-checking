package Utils;

import java.io.*;

public class TxtUtils {
    /**
     * 单纯地读出文件，不对文件进行任何处理
     *
     * @param txtPath 文件路径
     * @return String 返回字符串
     */
    public static String readTxt(String txtPath) {
        String xml = "";
        try {
            StringBuilder buffer = new StringBuilder();
            BufferedReader bf = new BufferedReader(new FileReader(txtPath));
            String s;

            while ((s = bf.readLine()) != null) {//使用readLine方法，一次读一行
//                buffer.append(s);
                buffer.append(s.trim().replaceAll("[\\pP\\p{Punct}]", ""));
                //            s.trim()去掉了字符串里面的空格
                //            s.trim().replaceAll("[\\pP\\p{Punct}]", ""}去掉所有的标点符号
                //            buffer.append(s);
                //            这行能够成段落显示
            }
//            xml = buffer.substring(0);
            xml = buffer.toString();

        } catch (IOException e) {


            e.printStackTrace();
        }


        return xml;
    }

    /**
     * 单纯写入文件
     *
     * @param txt  要写入的字符串
     * @param path 要写入的的文件路径
     * @throws IOException IOException
     */
    public static void WriteTxt(String txt, String path) throws IOException {
        //将写入转化为流的形式
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        bw.write(txt);
        //关闭流
        bw.close();
        System.out.println("写入成功");
    }

}


    


   


