package leetcode.util;

import java.util.LinkedList;

/**
 * Created by wzx on 2017/7/26.
 */
public class Stack<T> {
    private LinkedList<T> mElements = new LinkedList<T>();

    public boolean isEmpty() {
        return mElements.isEmpty();
    }

    public void push(T e) {
        mElements.addFirst(e);
    }

    public T peek() {
        return mElements.getFirst();
    }

    public T pop() {
        return mElements.removeFirst();
    }
}
