package com.hush.algotithm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 限流算法
 * @Author: huangshuai
 * @Date: 2020-07-29
 * @Version 1.0
 */
public class RateLimiter {

    private int maxCount = 1;

    private long interval = 60;

    private AtomicInteger conuter = new AtomicInteger(0);

    private long startTime = System.currentTimeMillis();


    public RateLimiter(int maxCount, int interval){
        this.maxCount = maxCount;
        this.interval = interval;
    }



    public boolean acquire() {

        conuter.addAndGet(1);

        //判断超过时间间隔后重新计数
        if (System.currentTimeMillis() - startTime > interval * 1000) {
            startTime = System.currentTimeMillis();
            conuter.set(0);
            return true;
        }

        //超过限流个数后，返回false
        if (conuter.get() > maxCount) {
            return false;
        }

        return true;
    }
}
