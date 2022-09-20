package Utils;

import org.junit.Test;

import java.io.IOException;

public class TxtUtilsTest {

    @Test
    public void readTxtTest() {
        // 路径存在，正常读取
        String str = TxtUtils.readTxt("D:/test/orig.txt");
        String[] strings = str.split(" ");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    public void writeTxtTest() throws IOException {
        // 路径存在，正常写入
        double[] elem = {0.11, 0.22, 0.33, 0.44, 0.55};
        for (double v : elem) {
            TxtUtils.WriteTxt(String.valueOf(v), "D:/test/ans.txt");
        }
    }

    @Test
    public void readTxtFailTest() {
        // 路径不存在，读取失败
        String str = TxtUtils.readTxt("D:/test/none.txt");
    }

    @Test
    public void writeTxtFailTest() throws IOException {
        // 路径错误，写入失败
        String s = "2e3yfchiusv";
        TxtUtils.WriteTxt(s, "D:/test/ans.txt");
    }

}
