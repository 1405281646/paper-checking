package Utils;

import org.junit.Test;

import java.io.IOException;

public class TxtUtilsTest {

    @Test
    public void readTxtTest() {
        // 路径存在，正常读取
        String str = TxtUtils.readTxt("src/test/java/Txt/orig.txt");
        String[] strings = str.split(" ");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    public void writeTxtTest() {
        // 路径存在，正常写入
        String s = "efygjavfbyjshvsrc/test/java/Txt/Ans/Ans_write_txt_Test";
        try {
            TxtUtils.WriteTxt(s, "src/test/java/Ans/TestWriteTxtAns.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void readTxtFailTest() {
        // 路径不存在，读取失败
        String str = TxtUtils.readTxt("src/test/java/Txt/none.txt");
    }

    @Test
    public void writeTxtFailTest() throws IOException {
        // 路径错误，会在错误的地方生成文件
        String s = "2e3yfchiusv";
        TxtUtils.WriteTxt(s, "src/test/java/Ans/ans.txt");
    }

}
