package com.example.jdk17_1.test;

import com.example.jdk17_1.entity.Chopsticks;
import com.example.jdk17_1.entity.Philosopher;

/**
 * @author
 * @date 2022/1/18
 * @apiNote
 */
public class DeadLock {
    public static void main(String[] args) {
        testDeadLock();
    }

    private static void testDeadLock() {
        Chopsticks c0 =new Chopsticks();
        Chopsticks c1 =new Chopsticks();
        Chopsticks c2 =new Chopsticks();
        Chopsticks c3 =new Chopsticks();
        Chopsticks c4 =new Chopsticks();
        Philosopher p0 = new Philosopher(c0,c1,0,"哲学家0");
        Philosopher p1 = new Philosopher(c1,c2,1,"哲学家1");
        Philosopher p2 = new Philosopher(c2,c3,2,"哲学家2");
        Philosopher p3 = new Philosopher(c3,c4,3,"哲学家3");
        Philosopher p4 = new Philosopher(c4,c0,4,"哲学家4");
        new Thread(p0,"p0").start();
        new Thread(p1,"p1").start();
        new Thread(p2,"p2").start();
        new Thread(p3,"p3").start();
        new Thread(p4,"p4").start();
    }
}
