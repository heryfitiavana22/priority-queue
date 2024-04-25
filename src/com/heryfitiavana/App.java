package com.heryfitiavana;

import com.heryfitiavana.priorityqueue.MaxPriority;
import com.heryfitiavana.priorityqueue.MinPriority;
import com.heryfitiavana.priorityqueue.PriorityQueue;

public class App {
    public static void main(String[] args) {
        PriorityQueue priorityqueue = new MinPriority();
        priorityqueue
                .addValue(10)
                .addValue(2)
                .addValue(4)
                .addValue(8)
                .addValue(3)
                .addValue(1);

        System.out.println("before sort");
        System.out.println(priorityqueue.getData());
        System.out.println("after sort");
        priorityqueue.sortByPriorityQueue();
        System.out.println(priorityqueue.getData());

    }
}