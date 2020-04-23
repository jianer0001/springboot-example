package com.jianer.springbootasync.bo;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author 杨兴健
 * @Date 2020/4/23 15:10
 */
public class MyDelayed implements Delayed {

    private long time;

    public MyDelayed(long time) {

        this.time = System.currentTimeMillis() + time;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(time - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {

        if (getDelay(TimeUnit.MILLISECONDS)-o.getDelay(TimeUnit.MILLISECONDS) > 0) {
            return 1;
        }else if(getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS) < 0) {
            return -1;
        }else {
            return 0;
        }

    }
}
