package src.com.exe.string;

import org.junit.Test;

/**
 * @Description:
 * @Author RileyShen
 * @Create 2021-07-17
 */
public class StringBufferBuilder {
    @Test
    public void test1() {
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0, 'm');
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer("abc");

        // Q1, sout(sb2.length());

        System.out.println(sb2.length());

        // Q2, 扩容：超过16，需要扩容
    }
}
