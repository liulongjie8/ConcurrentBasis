package org.design_patterns.proxy.simpleFactory;

/**
 * 单工厂：
 *
 * 优点： 简单工厂根据外部给定的条件，决定究竟应该创建那个具体的对象。明确区分了各自的职责和权力，有利于整个软件
 * 体系结构的优化
 *
 * 缺点： 很明显工厂类集中了所有实例的创建逻辑，容易违反高内聚的责任分配原则。
 *
 */
public class CarFactory {

     public static  Car createCar(String name){
         if("Bmw".equals(name)){
             return  new Bmw();
         }else{
             return  new Aodi();
         }
     }
}
