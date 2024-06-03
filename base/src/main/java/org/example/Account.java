package org.example;

/**
 * 银行账户信息
 */
public class Account {

    private int balance;

    public Account(){

    }

    /**
     * 转账操作  想目标账户target 转入 amt 金额
     * 问题： 存在并发问题
     *
     * @param target
     * @param amt
     */
    public void transfer(Account target, int amt){
          if(balance>amt){
              this.balance -= amt;
              target.balance +=amt;
          }
    }


    /**
     * 问题： synchronized 锁住的是 当前this对象，并没有对target对象进行上锁，存在并发问题。
     * 例：  A 为当前对象 B 为目标对象  C为其他对象    A/C同时向B转装100 B的账户不一定正常。
     * @param target
     * @param amt
     */
    public synchronized void transferLock (Account target, int amt){
        if(balance>amt){
            this.balance -= amt;
            target.balance +=amt;
        }
    }
}
