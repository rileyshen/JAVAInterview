package src.com.exe.string;

import org.junit.Test;

/**
 * @Description:reverse partly of a String, "abcdefg" -> "abfedctg"
 * @Author RileyShen
 * @Create 2021-07-18
 */
public class StringDemo {

    public String reverse(String str, int startIndex, int endIndex) {

        if (str == null || str.length() == 0) {
            return str;
        }

        char[] arr = str.toCharArray();

        for (int i = startIndex, j = endIndex; i < j; i++, j--) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        return new String(arr);
    }


    // method 2: subString

    public String reverse1(String str, int startIndex, int endIndex) {

        if (str == null || str.length() == 0) {
            return str;
        }

        String reverseStr = str.substring(0, startIndex);

        for (int i = endIndex; i >= startIndex ; i--) {
            reverseStr += str.charAt(i);
        }

        reverseStr += str.substring(endIndex + 1);

        return reverseStr;

    }

    // method 3: stringbuilder

    public String reverse3(String str, int startIndex, int endIndex) {
        if (str == null || str.length() == 0) {
            return str;
        }

        StringBuilder sb = new StringBuilder(str.length());
        sb.append(str.substring(0, startIndex));
        for (int i = endIndex; i >= startIndex; i--) {
            sb.append(str.charAt(i));
        }
        sb.append(str.substring(endIndex + 1));
        return sb.toString();
    }

    @Test

    public void testReverse() {
        String str = "abcdefg";
        String reverse = reverse3(str, 2, 5);
        System.out.println(reverse);
    }



}
