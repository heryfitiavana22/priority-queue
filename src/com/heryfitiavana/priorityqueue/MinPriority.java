package com.heryfitiavana.priorityqueue;

public class MinPriority extends PriorityQueue {

    @Override
    protected boolean comparePriority(int compare, int comparing) {
        return compare < comparing;
    }

}
