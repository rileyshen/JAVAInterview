package src.com.exe.string;

import org.junit.Test;

/**
 * @Description:获取一个字符串在另一个字符串中出现的次数
 * "ab" 在"abkkcadkabkebfkabkskab"中出现的次数
  * @Author RileyShen
 * @Create 2021-07-18
 */
public class StringDemo1 {
    /**
     * 获取subStr在mainStr中出现的次数
     * @param mainStr
     * @param subStr
     * @return
     */
    public int getCount(String mainStr, String subStr) {

        int mainLength = mainStr.length();
        int subLength = subStr.length();

        int count = 0;
        int index;

        if (mainLength >= subLength) {

            while ((index = mainStr.indexOf(subStr)) != -1) {
                count++;
                mainStr = mainStr.substring(index + subLength);

            }
            return count;
        } else {
            return 0;
        }

    }

    public int getCount2(String mainStr, String subStr) {

        int mainLength = mainStr.length();
        int subLength = subStr.length();

        int count = 0;
        int index = 0;

        if (mainLength >= subLength) {

            while ((index = mainStr.indexOf(subStr, index)) != -1) {
                count++;
                index += subLength;


            }
            return count;
        } else {
            return 0;
        }

    }

    @Test
    public void testGetCount() {
        String mainStr = "abkkcadkabkebfkabkskab";
        String subStr = "ab";
        int count = getCount2(mainStr, subStr);
        System.out.println(count);
    }


}
