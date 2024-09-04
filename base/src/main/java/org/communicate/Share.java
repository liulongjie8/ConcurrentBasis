package org.communicate;

public class Share {

    private int number = 0;

    public synchronized  void incr() throws InterruptedException{

        if(number==1){
            System.out.println("增加沉睡");
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+" : " + number);
        this.notifyAll();
    }


    public synchronized void decr() throws InterruptedException{
        if(number==0){
            System.out.println("减少沉睡");
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+" : "+number);
        this.notifyAll();
    }



}
