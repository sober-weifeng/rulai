package com.rulai.spider.util;

import java.util.Random;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/18 17:17
 */
public class CommonUtils {

    private CommonUtils() {}
    
    public static long generateRandomMillisecond() {
        int max = 9999, min = 1000;
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }
    
}
