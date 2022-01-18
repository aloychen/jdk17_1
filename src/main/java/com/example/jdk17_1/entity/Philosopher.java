package com.example.jdk17_1.entity;

/**
 * @author
 * @date 2022/1/18
 * @apiNote
 */
public class Philosopher implements Runnable{
    private Chopsticks left,right;
    private int no;
    private String name;

    public Chopsticks getLeft() {
        return left;
    }

    public void setLeft(Chopsticks left) {
        this.left = left;
    }

    public Chopsticks getRight() {
        return right;
    }

    public void setRight(Chopsticks right) {
        this.right = right;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Philosopher(Chopsticks left, Chopsticks right, int no, String name) {
        this.left = left;
        this.right = right;
        this.no = no;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (left){
            try {
                Thread.sleep(1000+no);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("哲学家"+name+"拿到了左手边筷子");
            synchronized (right){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("哲学家"+name+"拿到了右手边筷子");
            }
        }
    }
}
