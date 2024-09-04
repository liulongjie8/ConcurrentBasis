package org.countdownlatch;


/**
 *  基础需求： 订单与物流对账 获取差异订单 并保存差异数据
 *  问题：随着订单和物流的数据量增大，耗时越来越长
 */
public class demo1 {

    void demo(){
      boolean existsNotCheckOrders = false;
      while(existsNotCheckOrders){
           Object porders = getPorders();
           Object dorders = getDorders();
           Object check = check(porders, dorders);
           save(check);
      }
    }

    private Object check(Object porders, Object dorders) {
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
