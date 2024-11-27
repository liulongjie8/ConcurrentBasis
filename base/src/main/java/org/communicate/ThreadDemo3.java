package org.communicate;

public class ThreadDemo3 {


    public static void main(String[] args) {

        Share3 share3 = new Share3();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share3.printAA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"打印AA").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share3.printBB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"打印BB").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share3.printCC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"打印CC").start();

    }


}
