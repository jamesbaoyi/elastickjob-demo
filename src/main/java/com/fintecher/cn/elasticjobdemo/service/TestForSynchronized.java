package com.fintecher.cn.elasticjobdemo.service;

/**
 * @Author: qijigui
 * @CreateDate: 2019/4/19 17:31
 * @Description:
 */
public class TestForSynchronized {

    static int ID = 0;

    //测试方法01-synchronized块(对象级)
    public String setID_01() {
        synchronized (this) {
            ID++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "setID_01() ID No.:" + ID;
        }
    }

    //测试方法02-synchronized块(类级别)
    public String setID_02() {
        synchronized (TestForSynchronized.class) {
            ID++;
            return "setID_02() ID No.:" + ID;
        }
    }

    //测试方法03-synchronized 方法
    public synchronized String setID_03() {
        ID++;
        return "setID_03() ID No.:" + ID;
    }

    //普通方法
    public String commonMethod() {
        return "commonMethod ID No." + ID;
    }

}
