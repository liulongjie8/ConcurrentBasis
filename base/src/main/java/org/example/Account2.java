package org.example;

/**
 *  转账并发问题-----解决
 */
public class Account2 {

    private  Object Lock = null;

    private int balance;

    private Account2(){

    }

    public Account2(Object lock){

    }

    /**
     * 要求 所有的Account2 对象，在创建的时候 都传入同一个对象。如果传递错误将导致并发问题出现，锁不住
     * @param target
     * @param amt
     */
    public void transfer(Account2 target , int amt){
        synchronized (this.Lock){
            if(this.balance>amt){
                 this.balance -= amt;
                 target.balance += amt;
            }
        }
    }


    /**
     * 所有Account2对象共享一把锁，解决并发问题，  带来的效率问题 ????
     * @param target
     * @param amt
     */
    public void transferLock(Account2 target , int amt){
        synchronized (Account2.class){

        }
    }

}
