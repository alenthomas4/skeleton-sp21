package deque;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T> {

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

    private int getFirstIndex() {
        if (nextFirst == items.length-1) {
            return 0;
        }
        return(nextFirst+1);
    }

    private int getLastIndex() {
        if (nextLast == 0) {
            return(size()-1);
        }
        return(nextLast-1);
    }

    public T get(int i) {
        int firstIndex = getFirstIndex();
        int index = ((firstIndex) + i ) % items.length;
        if (items[index] == null) {
            return null;
        }
        return(items[index]);
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
        int removeIndex = getFirstIndex();
        if (isEmpty() || items[removeIndex] == null) {
            return(null);
        }
        T i = get(removeIndex);
        items[removeIndex] = null;
        nextFirst++;
        size--;
        return i;

    }

    public T removeLast() {
        int removeIndex = getLastIndex();
        if (isEmpty() || items[removeIndex] == null) {
            return(null);
        }
        T i = get(removeIndex);
        items[removeIndex] = null;
        nextLast--;
        size--;
        return i;
    }



    public void printDeque() {
        int startIndex = getFirstIndex();   // logical front of the deque
        int numElements = size();           // how many elements to print

        for (int i = 0; i < numElements; i++) {
            int index = (startIndex + i) % items.length;
            System.out.print(items[index] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ArrayDeque<Dog> m = new ArrayDeque<>();
        Dog d1 = new Dog();
        Dog d2 = new Dog();

        m.addFirst(d1);
        m.addFirst(d2);

        System.out.println(m.get(1));




    }
}
