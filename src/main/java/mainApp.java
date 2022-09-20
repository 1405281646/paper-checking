import Utils.HammingUtils;
import Utils.SimHashUtils;
import Utils.TxtUtils;

import java.io.IOException;

public class mainApp {
    public static void main(String[] args) throws IOException {
//        接受txt文件路径
        String sourceTxtPath = args[0];
        String compareTxtPath = args[1];
        String resultTxtPath = args[2];
//        把文件读出为String
        String sourceTxt = TxtUtils.readTxt(sourceTxtPath);
        String compareTxt = TxtUtils.readTxt(compareTxtPath);
//对String进行处理、
        sourceTxt = TxtUtils.replaceCharAndElse(sourceTxt);
        compareTxt = TxtUtils.replaceCharAndElse(compareTxt);


//       由字符串得出对应 的 simHash值

        String sourceSimHash = SimHashUtils.getSimHash(sourceTxt);
        String compareTxtSimHash = SimHashUtils.getSimHash(compareTxt);
        // 由 simHash值求出相似度
        double similarity = HammingUtils.getSimilarity(sourceSimHash, compareTxtSimHash);
        // 把相似度写入最后的结果文件中
        String s = "sourceTxtPath:" + sourceTxtPath + "\ncompareTxtPath:" + compareTxtPath + "\nresultTxtPath:" + resultTxtPath
                + "\nsimilarity:" + similarity;
        TxtUtils.WriteTxt(s, resultTxtPath);
        // 退出程序

        System.exit(0);
    }
}
