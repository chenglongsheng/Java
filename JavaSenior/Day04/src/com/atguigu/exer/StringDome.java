package com.atguigu.exer;

import org.junit.Test;

/**
 * @author chenglongsheng
 * @create 2021-04-17 19:24
 */
public class StringDome {

    /*
    将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
     */

    //方式一：转换为char[]
    public String reverse(String str, int startIndex, int endIndex) {
        if (str != null) {
            char[] arr = str.toCharArray();
            for (int x = startIndex, y = endIndex; x < y; x++, y--) {
                char temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }
            return new String(arr);
        }
        return null;
    }

    //方式二,String的拼接
    public String reverse1(String str, int startIndex, int endIndex) {
        if (str != null) {
            String reverseStr = str.substring(0, startIndex);
            for (int i = endIndex; i > startIndex; i--) {
                reverseStr += str.charAt(i);
            }
            reverseStr += str.substring(endIndex + 1);
            return reverseStr;
        }
        return null;
    }

    //方式三，StringBuilder/StringBuffer
    public String reverse3(String str, int startIndex, int endIndex) {
        if (str != null) {
            StringBuilder builder = new StringBuilder(str.length());
            builder.append(str.substring(0, startIndex));
            for (int i = endIndex; i > startIndex; i--) {
                builder.append(str.charAt(i));
            }
            builder.append(str.substring(endIndex + 1));
            return builder.toString();
        }
        return null;
    }

    @Test
    public void testReverse3() {
        String str = "abcdefg";
        String reverse = reverse(str, 2, 5);
        System.out.println(reverse);
    }
}
