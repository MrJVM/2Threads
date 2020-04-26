package com.practice.question1;

public class HelloGenerator implements Runnable {

    private static String t1Message = "hello T1";
    private static String t2Message = "hello T2";

    static final Object lock = new Object();
    int threadId;
    static boolean first = true;

    public HelloGenerator(int id) {
        threadId = id;
    }

    @Override
    public void run() {
        
        synchronized (lock) {
            if (threadId != 2 && first) {
                try {
                    lock.wait();
                    first = false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                lock.notifyAll();
            }

            if(threadId == 2 && first) {
                first = false;
                System.out.println(t2Message);
            } else {
                System.out.println(t1Message);
            }
        }
    }
}
