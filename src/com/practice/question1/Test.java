package com.practice.question1;

public class Test {



    public static void main(String args[]) {

        HelloGenerator gen1 = new HelloGenerator(1);
        HelloGenerator gen2 = new HelloGenerator(2);

        Thread t1 = new Thread(gen1);
        Thread t2 = new Thread(gen2);

        t1.start();
        t2.start();
    }

}
