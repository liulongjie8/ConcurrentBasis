package org.countdownlatch;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *  基础需求： 订单与物流对账 获取差异订单 并保存差异数据
 *  问题：随着订单和物流的数据量增大，耗时越来越长
 *
 *  让订单和物流信息的获取 并行执行 ， 然后在统一比对 存储
 *
 *
 */
public class demo2 {

    void demo() throws ExecutionException, InterruptedException {
        boolean existsNotCheckOrders = false;
        while(existsNotCheckOrders){
            Object porders  = new Object();
            Object dorders = new Object();
            FutureTask pOrdertask  = new FutureTask(new Callable() {
                @Override
                public Object call() throws Exception {
                    return getPorders();
                }
            });
            FutureTask dOrdertask  = new FutureTask(new Callable() {
                @Override
                public Object call() throws Exception {
                    return getDorders();
                }
            });
            new Thread(pOrdertask).start();
            porders = pOrdertask.get();
            new Thread(dOrdertask).start();
            dorders = dOrdertask.get();
            Object check = check(porders, dorders);
            save(check);
        }
    }

    private Object check(Object porders, Object dorders){
        return  new Object();
    }

    /**
     *  获取未对账的订单
     * @return
     */
    private Object getPorders() {
        return  new Object();
    }

    /**
     *  获取未对账的物流
     * @return
     */
    private Object getDorders(){
        return  new Object();
    }

    /**
     * 保存
     * @param obj
     */
    private void save(Object obj){
    }
}
