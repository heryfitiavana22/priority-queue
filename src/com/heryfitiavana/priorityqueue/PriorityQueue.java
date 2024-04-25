package com.heryfitiavana.priorityqueue;

import java.util.ArrayList;

abstract public class PriorityQueue {
    private ArrayList<Integer> data = new ArrayList<Integer>();
    private int currentLengthExtract = -1;

    public ArrayList<Integer> getData() {
        return data;
    }

    public PriorityQueue addValue(int value) {
        data.add(value);
        currentLengthExtract++;
        int i = data.size() - 1;

        while (i >= 0) {
            int parentIndex = getIndexParent(i);
            int currentValue = data.get(i);
            int parentValue = data.get(parentIndex);

            if (comparePriority(currentValue, parentValue)) {
                permute(i, parentIndex);
                i = parentIndex;
            } else {
                break;
            }
        }
        return this;
    }

    public int extract() {
        int i = 0;
        permute(i, currentLengthExtract);
        int extracted = data.get(currentLengthExtract);
        currentLengthExtract--;

        while (i < currentLengthExtract) {
            int childIndex = getIndexChildPriority(i);
            int childValue = data.get(childIndex);
            int currentValue = data.get(i);
            if (comparePriority(currentValue, childValue))
                break;
            permute(childIndex, i);
            i = childIndex;
        }

        return extracted;
    }

    public PriorityQueue sortByPriorityQueue() {
        for (int i = 0; i < data.size() - 1; i++) {
            extract();
        }
        return this;
    }

    abstract protected boolean comparePriority(int compare, int comparing);

    private int getIndexParent(int currentIndex) {
        return (currentIndex - 1) / 2;
    }

    private int getIndexChildPriority(int currentIndex) {
        int leftChildIndex = getIndexLeftChild(currentIndex);
        int rightChildIndex = getIndexRightChild(currentIndex);

        return comparePriority(data.get(leftChildIndex), data.get((rightChildIndex)))
                ? leftChildIndex
                : rightChildIndex;
    }

    private int getIndexRightChild(int currentIndex) {
        int index = (2 * currentIndex) + 2;
        return index < currentLengthExtract ? index : currentLengthExtract;
    }

    private int getIndexLeftChild(int currentIndex) {
        int index = (2 * currentIndex) + 1;
        return index < currentLengthExtract ? index : currentLengthExtract;
    }

    private void permute(int index1, int index2) {
        int temp = data.get(index1);
        data.set(index1, data.get(index2));
        data.set(index2, temp);
    }
}
