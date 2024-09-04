package org.communicate;

public class ThreadDemo {

    public static void main(String[] args) {
        Share1 share = new Share1();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.incr();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"增大线程A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.incr();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"增大线程B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.decr();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"减少线程C").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.decr();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"减少线程D").start();
    }

}
