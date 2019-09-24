package com.ki.entity;

public class Counter {
    public int count = 0;

    public Counter(int num) {
        this.count = num;
    }

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        this.count++;
    }
}
