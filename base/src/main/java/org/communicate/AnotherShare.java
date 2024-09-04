package org.communicate;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AnotherShare {

    private int number=0;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();


}
