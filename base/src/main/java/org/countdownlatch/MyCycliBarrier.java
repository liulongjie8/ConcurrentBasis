package org.countdownlatch;

import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 下面我们就来实现上面提到的方案。这个方案的难点有两个：一个是线程 T1 和 T2 要做到步调一致，另一个是要能够通知到线程 T3。
 *
 * 你依然可以利用一个计数器来解决这两个难点，计数器初始化为 2，线程 T1 和 T2 生产完一条数据都将计数器减 1
 * ，如果计数器大于 0 则线程 T1 或者 T2 等待。如果计数器等于 0，则通知线程 T3，并唤醒等待的线程 T1 或者 T2，
 * 与此同时，将计数器重置为 2，这样线程 T1 和线程 T2 生产下一条数据的时候就可以继续使用这个计数器了。
 *
 * 同样，还是建议你不要在实际项目中这么做，因为 Java 并发包里也已经提供了相关的工具类：CyclicBarrier。
 * 在下面的代码中，我们首先创建了一个计数器初始值为 2 的 CyclicBarrier，你需要注意的是创建 CyclicBarrier 的时候，
 * 我们还传入了一个回调函数，当计数器减到 0 的时候，会调用这个回调函数。
 *
 * 线程T1 负责查询订单，当查出一条时，调用 barrier.await() 来将计数器减 1，同时等待计数器变成 0；线程 T2 负责查询派送单，
 * 当查出一条时，也调用 barrier.await() 来将计数器减 1，同时等待计数器变成 0；当 T1 和 T2 都调用 barrier.await() 的时候，
 * 计数器会减到 0，此时 T1 和 T2 就可以执行下一条语句了，同时会调用 barrier 的回调函数来执行对账操作。
 *
 * 非常值得一提的是，CyclicBarrier 的计数器有自动重置的功能，当减到 0 的时候，会自动重置你设置的初始值。这个功能用起来实在是太方便了。
 */
public class MyCycliBarrier {

    /**
     * 订单队列
     */
    Vector<Object> pos;

    /**
     * 派送队列
     */
    Vector<Object> dos;

    /**
     *  执行回调的线程池
     */
    Executor executor =  Executors.newFixedThreadPool(1);


    final CyclicBarrier barrier = new CyclicBarrier(2,()->{
         executor.execute(()->check());
    });

    void check(){
          Object porders = pos.remove(0);
          Object oorders = dos.remove(0);
          Object diff = check(porders, oorders);
          save(diff);
    }

    Object check(Object p , Object d){
        return  new Object();
    }

    void save(Object obj){

    }

   void checkAll(){
       Thread t1 = new Thread(()->{

           while(true){
               pos.add(getPorders());
               try {
                   barrier.await();
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               } catch (BrokenBarrierException e) {
                   throw new RuntimeException(e);
               }
           }
       });

       t1.start();

       Thread t2 = new Thread(()->{

           while(true){
               dos.add(getDorders());
               try {
                   barrier.await();
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               } catch (BrokenBarrierException e) {
                   throw new RuntimeException(e);
               }
           }
       });
       t2.start();
   }


    Object getPorders(){
        return  new Object();
    }

    Object getDorders(){
        return  new Object();
    }

}

/**
 *
 *CountDownLatch 主要用于解决一个线程等待多个线程的场景，可以类比旅游团长要等待所有的游客到齐才能去下一个景点
 * 而CyclicBarrier 是一组线程之间互相等待，更像是几个驴友之前的不离不弃。
 *
 * 需要主义的是： CountDownLatch的计数器是不能循环利用的，也就是技术器减到0的时候，再有线程调用await()，该线程也会直接通过
 *
 * CyclicBarrier的计数器是可以循环利用的，而且具备自动重置功能，一旦计数器减到0会自动重置到你设置的初始值。除此之外，CyclicBarrier还可以设置回调函数。
 *
 */
