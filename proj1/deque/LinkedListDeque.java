package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T> {

    /**
     * @return LinkedListIterator
     */
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();

    }

    /**
     * Iterator that iterates through the linked list.
     */
    private class LinkedListIterator implements Iterator<T> {
        private int cursor;


        public LinkedListIterator() {
            cursor = 0;
        }
        @Override
        public boolean hasNext() {
            return cursor < size();
        }

        @Override
        public T next() {
            int getIndex = cursor;
            T item = get(getIndex);
            cursor++;
            return item;
        }
    }

    /*
    A deque is a Double ended queue. This is the LinkedList implementation thereof.

    invariants:
        1. size = number of items in the list
            -the 'highest' index is size-1 ( counting from 0 ).
        2.
        3.
     */


    /**
     * Each node has an item, and a next and previous pointer.

     */
    private class Node {
        private T item;
        private Node prev;
        private Node next;

        public Node(T item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;

        }
    }
    /*
    A Sentinel Node - implements the circular list ideology
     */
    private Node sentinel;

    /*
    Caches the size of the Linked List.
     */
    private int size;



    // creates an empty list
    public LinkedListDeque() {
        // node that points to itself
        sentinel = new Node(null, sentinel,sentinel);
        size = 0;
    }


    /**
     * Adds an item of tpe T to the front of the deque.
     * assume item is never null.
     * @param item
     */
    public void addFirst(T item) {
        if (size == 0) {
            // If the list is empty, the new node becomes both first and last
            Node newNode = new Node(item, sentinel, sentinel);
            sentinel.next = newNode;
            sentinel.prev = newNode;
        } else {
            // If the list is not empty
            Node oldFirst = sentinel.next;
            Node newNode = new Node(item, oldFirst, sentinel);
            sentinel.next = newNode;
            oldFirst.prev = newNode;
        }
        size++;

    }

    public void addLast(T item) {
        if (size == 0) {
            Node newNode = new Node(item, sentinel, sentinel);
            sentinel.next = newNode;
            sentinel.prev = newNode;
        } else {

            Node prevNode = sentinel.prev;
            prevNode.next = new Node(item, sentinel, prevNode);
            sentinel.prev = prevNode.next;

        }

        size++;


    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * returns the size of the list. constant time
     * @return
     */
    public int size() {
        return size;
    }


    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Node first = sentinel.next;
            sentinel.next = first.next;
            first.next.prev = sentinel;
            first.prev = null;
            first.next = null;
            size--;
            return first.item;
        }


    }

    public T removeLast() {
        return null;
    }

    /**
     * gets an ith item from the deque, usuing.. iteration!
     * @param index
     * @return
     */
    public T get(int index) {

        Node current = sentinel.next;
        int i = 0;
        while (i < size) {
            if (i == index) {
                return current.item;
            }
            current = current.next;
            i++;
        }
        return null;
    }


    /**
     * recursively return the ith value
     * @param index
     * @return
     */

    public T getRecursive(int index) {
        // base case for main
        if (index > size - 1) {
            System.out.printf("Index %d is out of bounds\n", index);
            return null;
        }
        return getRecursiveHelper(0,index, sentinel.next);
    }

    private T getRecursiveHelper(int i, int index, Node current) {
        // base case, if we have reached the desired index, return the item in it
        if (i == index) {
            return current.item;
        }

        return getRecursiveHelper(i+1, index, current.next);

    }

    public void printDeque() {
       for (int i = 0; i < size; i++) {
           System.out.print(get(i) + " ");
       }
        System.out.println();
    }



    public static void main(String[] args) {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>();
        Iterator<Integer> seer = deque.iterator();

        System.out.println(deque.isEmpty());
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        System.out.println("first element: " + deque.get(0));
        Iterator<Integer> iter = deque.iterator();
       for (int i: deque) {
           System.out.print(i + " ");
       }

        /** deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addLast(4);
        deque.addLast(5); **/


    }




}
