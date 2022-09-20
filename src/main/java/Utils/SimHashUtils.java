package Utils;

import com.hankcs.hanlp.HanLP;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;

public class SimHashUtils {
    /**
     * 获取字符串的SimHAsh
     *
     * @param str 要获取SimHash的字符串
     * @return String SimHash
     */
    public static String getSimHash(String str) {
        // 文本长度太短时HanLp无法取得关键字
        try {
            if (str.length() < 200) throw new ShortStringException("文本过短！");
        } catch (ShortStringException e) {
            e.printStackTrace();
            return null;
        }
        // 用数组表示特征向量,取128位,从 0 1 2 位开始表示从高位到低位
        int[] v = new int[128];
        // 1、分词（使用了外部依赖hankcs包提供的接口）
        List<String> keywordList = HanLP.extractKeyword(str, str.length());//取出所有关键词（会自动取较高频率的词）
        /**
         * 有点不懂怎么用Hanlp
         * 之前找过jieba库，但是java用结巴库不好用，如果是python就好用得多
         * JAVAjiaba库的分词没有自动摘要功能，
         */

        // hash
        int size = keywordList.size();

        int i = 0;//以i做外层循环
        for (String keyword : keywordList) {
            // 2、获取hash值
            StringBuilder keywordHash = new StringBuilder(getHash(keyword));
            if (keywordHash.length() < 128) {
                // hash值可能少于128位，在低位以0补齐
                int dif = 128 - keywordHash.length();
                for (int j = 0; j < dif; j++) {
                    keywordHash.append("0");
                }
            }
            // 3、加权、合并
            for (int j = 0; j < v.length; j++) {
                // 对keywordHash的每一位与'1'进行比较
                if (keywordHash.charAt(j) == '1') {
                    //权重分10级，由词频从高到低，取权重10~0
                    v[j] += (10 - (i / (size / 10)));
                } else {
                    v[j] -= (10 - (i / (size / 10)));
                }
            }
            i++;
        }
        // 4、降维
        StringBuilder simHash = new StringBuilder();// 储存返回的simHash值
        for (int k : v) {
            // 从高位遍历到低位
            if (k <= 0) {
                simHash.append("0");
            } else {
                simHash.append("1");
            }
        }
        return String.valueOf(simHash);
    }

    /**
     * 通过SHA算法得出字符串str的HASH
     *
     * @param str 字符串
     * @return String HASH
     */
    public static String getHash(String str) {
        try {
            // 这里使用了SHA获得hash值
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            return new BigInteger(1, messageDigest.digest(str.getBytes(StandardCharsets.UTF_8))).toString(2);
            //str.getBytes(String charsetName)使用指定的字符集将字符串编码为 byte 序列，并将结果存储到一个新的 byte 数组中
            //messageDigest.digest() 接收任意大小的数据，输出固定长度的哈希值
            //BigInteger.toString()返回此 BigInteger 的给定基数的字符串表示形式。
            //BigInteger(int signum,byte[] magnitude)将 BigInteger 的符号-数量表示形式转换为 BigInteger。
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }
}
