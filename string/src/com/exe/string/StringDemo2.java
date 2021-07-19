package src.com.exe.string;

import org.junit.Test;

/**
 * @Description:获取两个字符串最大相同字串
 * str1: "abcwerthelloyuiodefabcdef"
 * str2: "cvhellobnm"
 * 
 * 两个数字的最大公约数的逻辑
 * 
 * 
 * @Author RileyShen
 * @Create 2021-07-18
 */
public class StringDemo2 {
    public String getMaxSameString(String str1, String str2) {
        if (str1 != null && str2 != null) {
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() < str2.length()) ? str1 : str2;
            int length = minStr.length();

            for (int i = 0; i < length; i++) {

                for (int x = 0, y = length - i; y <= length; x++, y++) {
                    String subStr = minStr.substring(x, y);
                    if (maxStr.contains(subStr)) { // minstr的字串
                        return subStr;
                    }
                }

            }

        }
        return null;
    }

    @Test
    public void testGetMax() {
        String str1 = "abcwerthelloyuiodefabcdef";
        String str2 = "cvhellobnm";

        String max = getMaxSameString(str1, str2);
        System.out.println(max);

    }

}
