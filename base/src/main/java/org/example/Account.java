package org.example;

/**
 * 银行账户信息
 */
public class Account {

    /**
     * 账户ID
     */
    private String id;
    /**
     * 余额
     */
    private int balance;
    /**
     * 余额锁
     */
    private final Object balanceLock = new Object();
    /**
     * 密码
     */
    private String password;

    /**
     * 密码锁
     */
    private final Object pwdLock = new Object();


}
