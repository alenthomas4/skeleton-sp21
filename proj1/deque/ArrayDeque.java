package deque;

import java.util.ArrayList;

public class ArrayDeque<T> {

    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;


    /*
    Suppose we start each as a ptr to index 3,
    then first = 4, and last = 5
     */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    public T get(int i) {
        return(items[i]);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }



    private void updateNextLast() {
        if (nextLast == items.length - 1) {
            nextLast = 0;
            return;
        }
        nextLast++;
    }

    private void updateNextFirst() {
        if (nextFirst == 0) {
            nextFirst = items.length - 1;
            return;
        }
        nextFirst--;

    }

    public void addFirst(T item) {
        items[nextFirst] = item;
        updateNextFirst();
        size++;

    }

    public void addLast(T item) {
        items[nextLast] = item;
        updateNextLast();
        size++;
    }

    public T removeFirst() {
        T i = get(nextFirst);
        items[nextFirst+1] = null;
        nextFirst++;
        size--;
        return i;

    }

    public T removeLast() {
        T i = get(nextLast);
        items[nextLast-1] = null;
        nextLast--;
        size--;
        return i;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> m = new ArrayDeque<>();
        m.addFirst(1);
        m.addFirst(2);
        m.removeFirst();
        m.addFirst(3);
        m.addFirst(4);
        m.addFirst(45);



    }



}
