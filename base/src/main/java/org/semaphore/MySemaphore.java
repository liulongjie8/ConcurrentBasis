package org.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 信号量模型简单使用
 */
public class MySemaphore {


    static int count = 0;

    /**
     * 初始化信号量
     */
    static final Semaphore semaphore = new Semaphore(1);

    /**
     * 假设两个线程 T1 和 T2 同时访问 addOne() 方法，当它们同时调用 acquire() 的时候，由于 acquire()
     * 是一个原子操作，所以只能有一个线程（假设 T1）把信号量里的计数器减为 0，
     * 另外一个线程（T2）则是将计数器减为 -1。对于线程 T1，信号量里面的计数器的值是 0，大于等于 0，所以线程 T1
     * 会继续执行；对于线程 T2，信号量里面的计数器的值是 -1，小于 0，按照信号量模型里对 down() 操作的描述，线程 T2 将被阻塞。
     * 所以此时只有线程 T1 会进入临界区执行count+=1；。
     *
     * 当线程T1 执行 release() 操作，也就是 up() 操作的时候，信号量里计数器的值是 -1，加 1 之后的值是 0，
     * 小于等于 0，按照信号量模型里对 up() 操作的描述，此时等待队列中的 T2 将会被唤醒。于是 T2 在 T1
     * 执行完临界区代码之后才获得了进入临界区执行的机会，从而保证了互斥性。
     */
    static void addOne() throws InterruptedException {
        try {
            //信号量减1  原子性操作 只有一个线程执行
            semaphore.acquire();
            count+=1;
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            // 信号量加1 原子性操作
            semaphore.release();
        }

    }





}
