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
        int index = (nextFirst + 1) + i;
        if (items[index] == null) {
            return null;
        }
        return(items[index]);
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
        int removeIndex = nextFirst+1;
        if (isEmpty() || items[removeIndex] == null) {
            return(null);
        }
        T i = get(nextFirst);
        items[removeIndex] = null;
        nextFirst++;
        size--;
        return i;

    }

    public T removeLast() {
        int removeIndex = nextLast-1;
        if (isEmpty() || items[removeIndex] == null) {
            return(null);
        }
        T i = get(nextLast);
        items[nextLast-1] = null;
        nextLast--;
        size--;
        return i;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> m = new ArrayDeque<>();
        m.removeFirst();
        m.removeLast();
        m.removeFirst();
        m.addFirst(1);
        m.addFirst(2);
        m.removeFirst();
        m.addFirst(3);
        m.addFirst(4);
        m.addFirst(45);
        System.out.println(m.get(2));



    }



}
