package org.communicate;

public class Share1 {

    private int number = 0;

    public synchronized  void incr() throws InterruptedException{

        while(number==1){
            System.out.println(Thread.currentThread().getName()+"-->增加沉睡");
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+" : " + number);
        this.notifyAll();
    }


    public synchronized void decr() throws InterruptedException{
        while(number==0){
            System.out.println(Thread.currentThread().getName()+"减少沉睡");
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+" : "+number);
        this.notifyAll();
    }



}
