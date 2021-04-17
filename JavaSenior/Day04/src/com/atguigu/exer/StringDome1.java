package com.atguigu.exer;

import org.junit.Test;

/**
 * @author chenglongsheng
 * @create 2021-04-17 20:22
 */
public class StringDome1 {
    /*
    获取一个字符串在另一个字符串中出现的次数。比如：获取“ab”在 “cdabkkcadkabkebfkabkskab”中出现的次数
     */

    /**
     * 获取subStr在mainStr中出现的次数
     *
     * @param mainStr
     * @param subStr
     * @return
     */
    public int getCount(String mainStr, String subStr) {
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;
        if (mainLength >= subLength) {
            //方式一
//            while ((index = mainStr.indexOf(subStr)) != -1) {
//                count++;
//                mainStr = mainStr.substring(index + subStr.length());
//            }
            //方式二
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
        String mainStr = "cdabkkcadkabkebfkabkskab";
        String subStr = "ab";
        int count = getCount(mainStr, subStr);
        System.out.println(count);
    }
}
