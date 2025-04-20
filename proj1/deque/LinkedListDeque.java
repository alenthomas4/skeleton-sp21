package deque;

public class LinkedListDeque<T> {

    /*
    A deque is a Double ended queue. This is the LinkedList implementation thereof.
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

    private Node sentinel;
    private int size;



    // creates an empty list
    public LinkedListDeque() {
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
        int size = size();
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * returns the size of the list. constant time
     * @return
     */
    public int size() {
        return size;
    }

    public void printDeque() {

    }

    public T removeFirst() {
        return null;
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
        return null;
    }

    public T getRecursive(int index){
    return null;
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        /** deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addLast(4);
        deque.addLast(5); **/


    }




}
