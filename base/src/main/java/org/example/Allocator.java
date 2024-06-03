package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * 静态内部类方式（推荐）---> 创建单例
 * 加载一个类时，其内部类不会同时被加载。一个类被加载，当且仅当其某个静态成员（静态域、构造器、静态方法等）被调用时发生。 由于在调用 StaticSingleton.getInstance() 的时候，才会对单例进行初始化，而且通过反射，是不能从外部类获取内部类的属性的；由于静态内部类的特性，只有在其被第一次引用的时候才会被加载，所以可以保证其线程安全性。
 * 总结：
 * 优势：兼顾了懒汉模式的内存优化（使用时才初始化）以及饿汉模式的安全性（不会被反射入侵）。
 * 劣势：需要两个类去做到这一点，虽然不会创建静态内部类的对象，但是其 Class 对象还是会被创建，而且是属于永久带的对象。
 * 原文链接：https://blog.csdn.net/u011595939/article/details/79972371
 *
 *
 *
 *
 *
 * 资源管理源
 */
public class Allocator {

    /**
     * 申请出去的资源集合
     */
    private List<Object> als = new ArrayList<Object>();

    private Allocator(){
    }

    public static Allocator getInstance(){
          return  AllocatorHolder.instance;
    }

    /**
     * 内部类 【 类加载时， 内部类不会被加载， 当且仅当其某个静态成员（静态域、构造器、静态方法等）被调用时发生 加载】
     */
    private static class  AllocatorHolder{
         private static  final Allocator instance= new Allocator();
    }

    /**
     * 申请资源
     * @param from
     * @param to
     * @return
     */
    synchronized  boolean apply(Object from,Object to){
        if(als.contains(from)||als.contains(to)){
            return  false;
        }else{
            als.add(from);
            als.add(to);
        }
        return  true;
    }


    /**
     * 释放资源
     * @param from
     * @param to
     */
    synchronized void free(Object from , Object to){
        als.remove(from);
        als.remove(to);
    }


}
