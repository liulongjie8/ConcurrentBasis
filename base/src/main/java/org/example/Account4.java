package org.example;

public class Account4 {

    private Allocator allocator = Allocator.getInstance();

    private int balance;

    public void transfer(Account4 target, int amt ){
        while(allocator.apply(this,target));
        try {
             //锁定转出账户
             synchronized (this){
                 //锁定转入账户
                 synchronized (target){
                     if (this.balance > amt) {
                         this.balance -= amt;
                         target.balance += amt;
                     }
                 }
             }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            allocator.free(this,target);
        }
    }

}
