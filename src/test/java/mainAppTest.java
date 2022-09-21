import Utils.HammingUtils;
import Utils.SimHashUtils;
import Utils.TxtUtils;
import org.junit.Test;

import java.io.IOException;

public class mainAppTest {


    @Test
    public void origAndAllTest() throws IOException {
        String[] str = new String[6];
        str[0] = TxtUtils.readTxt("src/test/java/Txt/orig.txt");
        str[1] = TxtUtils.readTxt("src/test/java/Txt/orig_0.8_add.txt");
        str[2] = TxtUtils.readTxt("src/test/java/Txt/orig_0.8_del.txt");
        str[3] = TxtUtils.readTxt("src/test/java/Txt/orig_0.8_dis_1.txt");
        str[4] = TxtUtils.readTxt("src/test/java/Txt/orig_0.8_dis_10.txt");
        str[5] = TxtUtils.readTxt("src/test/java/Txt/orig_0.8_dis_15.txt");
        String ansFileName = "src/test/java/Ans/ANSALL";
        for (int i = 0; i <= 5; i++) {
            double ans = HammingUtils.getSimilarity(SimHashUtils.getSimHash(str[0]), SimHashUtils.getSimHash(str[i]));
            TxtUtils.WriteTxt(String.valueOf(ans), ansFileName);
        }
    }

    @Test
    public void origAndOrigTest() throws IOException {
        String str0 = TxtUtils.readTxt("src/test/java/Txt/orig.txt");
        String str1 = TxtUtils.readTxt("src/test/java/Txt/orig.txt");
        String ansFileName = "src/test/java/Ans/ansOrigAndOrigTest.txt";
        double ans = HammingUtils.getSimilarity(SimHashUtils.getSimHash(str0), SimHashUtils.getSimHash(str1));
        TxtUtils.WriteTxt(String.valueOf(ans), ansFileName);
    }

    @Test
    public void origAndAddTest() throws IOException {
        String str0 = TxtUtils.readTxt("src/test/java/Txt/orig.txt");
        String str1 = TxtUtils.readTxt("src/test/java/Txt/orig_0.8_add.txt");
        String ansFileName = "src/test/java/Ans/ansOrigAndAddTest.txt";
        double ans = HammingUtils.getSimilarity(SimHashUtils.getSimHash(str0), SimHashUtils.getSimHash(str1));
        TxtUtils.WriteTxt(String.valueOf(ans), ansFileName);
    }

    @Test
    public void origAndDelTest() throws IOException {
        String str0 = TxtUtils.readTxt("D:/test/orig.txt");
        String str1 = TxtUtils.readTxt("D:/test/orig_0.8_del.txt");
        String ansFileName = "D:/test/ansOrigAndDelTest.txt";
        double ans = HammingUtils.getSimilarity(SimHashUtils.getSimHash(str0), SimHashUtils.getSimHash(str1));
        TxtUtils.WriteTxt(String.valueOf(ans), ansFileName);
    }

    @Test
    public void origAndDis1Test() throws IOException {
        String str0 = TxtUtils.readTxt("D:/test/orig.txt");
        String str1 = TxtUtils.readTxt("D:/test/orig_0.8_dis_1.txt");
        String ansFileName = "D:/test/ansOrigAndDis1Test.txt";
        double ans = HammingUtils.getSimilarity(SimHashUtils.getSimHash(str0), SimHashUtils.getSimHash(str1));
        TxtUtils.WriteTxt(String.valueOf(ans), ansFileName);
    }

    @Test
    public void origAndDis10Test() throws IOException {
        String str0 = TxtUtils.readTxt("D:/test/orig.txt");
        String str1 = TxtUtils.readTxt("D:/test/orig_0.8_dis_10.txt");
        String ansFileName = "D:/test/ansOrigAndDis10Test.txt";
        double ans = HammingUtils.getSimilarity(SimHashUtils.getSimHash(str0), SimHashUtils.getSimHash(str1));
        TxtUtils.WriteTxt(String.valueOf(ans), ansFileName);
    }

    @Test
    public void origAndDis15Test() throws IOException {
        String str0 = TxtUtils.readTxt("D:/test/orig.txt");
        String str1 = TxtUtils.readTxt("D:/test/orig_0.8_dis_15.txt");
        String ansFileName = "D:/test/ansOrigAndDis15Test.txt";
        double ans = HammingUtils.getSimilarity(SimHashUtils.getSimHash(str0), SimHashUtils.getSimHash(str1));
        TxtUtils.WriteTxt(String.valueOf(ans), ansFileName);
    }

}