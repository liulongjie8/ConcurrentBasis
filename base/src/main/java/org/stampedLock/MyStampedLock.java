package org.stampedLock;

import java.util.concurrent.locks.StampedLock;

/**
 * readwriteLock 是一种多读少写的并发锁 【读锁、写锁】
 * 针对 多写少读的锁 为StampedLock 【写锁、悲观读锁、乐观读】
 * 【写锁】：
 */
public class MyStampedLock {

    final StampedLock s = new StampedLock();

    public void read(){
        //加乐观锁
        long l = s.tryOptimisticRead();

        //todo  读取局部变量

        //检查是否存在写操作 如果存在返回false ，否则 返回true
        if(!s.validate(l)){
            // 锁升级  升级为悲观读锁 【只允许一个线程获取写锁】
            l = s.readLock();
        }
        try {
            //todo  读取局部变量
            //处理业务方法
        }finally {
            //释放锁
            s.unlockRead(l);
        }
    }

    public void write(){
        //加锁
        long stamp = s.writeLock();
        try {
           //处理业务逻辑
        }finally {
            //释放锁
            s.unlockRead(stamp);
        }

    }

}
