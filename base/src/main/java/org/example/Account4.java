package org.example;

public class Account4 {

    private Allocator allocator = Allocator.getInstance();

    private int balance;

    public void transfer(Account4 target, int amt ){
        while(allocator.apply(this,target));
        try {
             //锁定
             synchronized (this){

             }
        }catch (Exception e){

        }finally {
            allocator.free(this,target);
        }
    }

}
