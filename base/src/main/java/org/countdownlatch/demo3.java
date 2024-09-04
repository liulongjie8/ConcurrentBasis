/*
package org.countdownlatch;


import java.util.concurrent.*;

*/
/**
 *  基础需求： 订单与物流对账 获取差异订单 并保存差异数据
 *  问题：随着订单和物流的数据量增大，耗时越来越长
 *
 *  让订单和物流信息的获取 并行执行 ， 然后在统一比对 存储
 *
 *
 *//*

public class demo3 {

    void demo() throws ExecutionException, InterruptedException {
        boolean existsNotCheckOrders = false;
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        while(existsNotCheckOrders){
            CountDownLatch count = new CountDownLatch(2);
            final  Object porders  ;
            final  Object dorders  ;
            Callable<Object> pOrdertask  = new  Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    return getPorders();
                }
            };
            Callable<Object> dOrdertask  =new Callable() {
                @Override
                public Object call() throws Exception {
                    return getDorders();
                }
            };

            Object check = check(porders, dorders);
            save(check);
        }
    }

    private Object check(Object porders, Object dorders){
        return  new Object();
    }

    */
/**
     *  获取未对账的订单
     * @return
     *//*

    private Object getPorders() {
        return  new Object();
    }

    */
/**
     *  获取未对账的物流
     * @return
     *//*

    private Object getDorders(){
        return  new Object();
    }

    */
/**
     * 保存
     * @param obj
     *//*

    private void save(Object obj){
    }
}
*/
