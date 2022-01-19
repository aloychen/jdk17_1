package com.example.jdk17_1.test;

import com.example.jdk17_1.entity.Chopsticks;
import com.example.jdk17_1.entity.Philosopher;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @date 2022/1/18
 * @apiNote
 */
public class DeadLock {
    public static void main(String[] args) {
//        testDeadLock();
        testNum();
    }

    private static void testNum() {
        long startTime = System.currentTimeMillis();
        Long x =1000L;
        BigInteger bigInteger = getBigInteger(x);
        System.out.println(bigInteger);
        long endTime = System.currentTimeMillis();
        System.out.println("消耗时间："+(endTime-startTime));
    }

    private static BigInteger getBigInteger(Long x) {
        Map<Long,BigInteger> bigIntegerMap = new HashMap<>();
        return getBigIntegerByMap(x,bigIntegerMap);
    }

    private static BigInteger getBigIntegerByMap(Long x, Map<Long, BigInteger> bigIntegerMap) {
        BigInteger bigInteger;
        if(bigIntegerMap.containsKey(x)){
            return bigIntegerMap.get(x);
        }
        if(x==0){
            bigInteger = BigInteger.valueOf(0L);
            bigIntegerMap.put(0L,bigInteger);
            return bigInteger;
        }

        if(x==1||x==2){
            bigInteger = BigInteger.valueOf(1);
            bigIntegerMap.put(x,bigInteger);
            return bigInteger;
        }
        BigInteger v = getBigIntegerByMap(x-1,bigIntegerMap).add(getBigIntegerByMap(x-2,bigIntegerMap));
        bigIntegerMap.put(x,v);
        return v;
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
