package com.fintecher.cn.elasticjobdemo.controller;

import com.fintecher.cn.elasticjobdemo.service.TestForSynchronized;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: qijigui
 * @CreateDate: 2019/4/19 17:01
 * @Description:
 */
@RestController
public class SynchronizedController {

    private static Object mutex = new Object();

    @GetMapping("/getData")
    private void getData() throws InterruptedException {
//        synchronized (mutex) {
//            Thread th = Thread.currentThread();
//            for (int i = 0; i < 100; i++) {
//                Thread.sleep(1000);
//                System.out.println("第" + i + "个数,当前线程名字是" + th.getName());
//            }
//
//        }

        // 创建10个线程来调用【同一个】TestForSynchronized实例(对象)
        TestForSynchronized temp = new TestForSynchronized();
        for (int index = 0; index < 10; index++) {
            MyThread_01 thread = new MyThread_01(temp);
            thread.start();
        }
    }


    class MyThread_01 extends Thread {
        TestForSynchronized testObject;

        public MyThread_01(TestForSynchronized testObject) {
            this.testObject = testObject;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }

            System.out.println("当前线程的名字是：" + Thread.currentThread().getName() + "，调用setID_02方法返回的值是：" + testObject.setID_02());
        }
    }
}
