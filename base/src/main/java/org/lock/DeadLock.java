package org.lock;

public class DeadLock {

    public static void main(String[] args) {
        Object  a = new Object();
        Object  b = new Object();
        new Thread(()->{

            synchronized (a){
                System.out.println(Thread.currentThread().getName()+" 获取了锁a");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (b){
                    System.out.println(Thread.currentThread().getName()+" 获取了锁b");
                }
            }

        },"A").start();

        new Thread(()->{

             synchronized (b){
                 System.out.println(Thread.currentThread().getName()+" 获取了锁b");
                 try {
                     Thread.sleep(1000);
                 }catch (InterruptedException e){
                     e.printStackTrace();
                 }
                 synchronized (a){
                     System.out.println(Thread.currentThread().getName()+" 获取了锁a");
                 }
             }

        },"B").start();

    }

}
