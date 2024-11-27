package org.communicate;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Share3 {

    private int flag = 1;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();


    public void printAA() throws  InterruptedException{
        lock.lock();
        try {
            while(flag!=1){
                 condition.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("AA");
            }
            flag=2;
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }

    public void printBB() throws InterruptedException{
          lock.lock();
          try {
              while(flag!=2){
                  condition.await();
              }
              for (int i = 0; i < 10; i++) {
                  System.out.println("BB");
              }
              flag=3;
              condition.signalAll();
          }finally {
              lock.unlock();
          }
    }

    public void printCC() throws InterruptedException{
        lock.lock();
        try {
            while(flag!=3){
                condition.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println("CC");
            }
            flag=1;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

}
