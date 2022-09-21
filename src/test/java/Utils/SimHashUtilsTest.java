package Utils;

import org.junit.Test;

public class SimHashUtilsTest {

    @Test
    public void getHashTest() {
        String[] strings = {"祝康龙", "是", "一位", "很好", "的", "学生"};
        for (String string : strings) {
            String stringHash = SimHashUtils.getHash(string);
            System.out.println(stringHash.length());
            System.out.println(stringHash);
        }
    }

    @Test
    public void getSimHashTest() {
        String str0 = TxtUtils.readTxt("src/test/java/Txt/orig.txt");
        String str1 = TxtUtils.readTxt("src/test/java/Txt/orig_0.8_add.txt");
        System.out.println(SimHashUtils.getSimHash(str0));
        System.out.println(SimHashUtils.getSimHash(str1));
    }

}
