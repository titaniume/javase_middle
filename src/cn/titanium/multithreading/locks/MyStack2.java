package cn.titanium.multithreading.locks;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import cn.titanium.multithreading.synchronization.Hero;

/**
 * 借助Lock，把MyStack修改为线程安全的类
 * 
 * @author Administrator 2017年10月20日下午7:05:25
 */
public class MyStack2<T> {

    LinkedList<T> values = new LinkedList<T>();
 
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
 
    public void push(T t) {
        try {
            lock.lock();
            while (values.size() >= 200) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            condition.signalAll();
            values.addLast(t);
        } finally {
            lock.unlock();
        }
 
    }
 
    public T pull() {
        T t=null;
        try {
            lock.lock();
            while (values.isEmpty()) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            condition.signalAll();
            t= values.removeLast();
        } finally {
            lock.unlock();
        }
        return t;
    }
 
    public T peek() {
        return values.getLast();
    }
}