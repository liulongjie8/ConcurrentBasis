package org.example;

/**
 * 转账业务 枷锁再次优化   ---> 细粒度锁
 *
 * Account2 粒度太大 性能太差
 */
public class Account3 {
    private int balance;
    // 转账
    void transfer(Account3 target, int amt){
        // 锁定转出账户
        synchronized(this) {
            // 锁定转入账户
            synchronized(target) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }
}
