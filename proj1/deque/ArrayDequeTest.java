package deque;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayDequeTest {

    @Test
    public void isEmptyAddTest() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        assertTrue("Newly initialized deque is empty", deque.isEmpty());

        deque.addFirst(1);
        assertEquals(1, deque.size());

        deque.addLast(3);
        assertEquals(2, deque.size());
    }

    @Test
    public void addRemoveTest() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
       assertTrue("Newly initialized deque is empty", deque.isEmpty());

       deque.addFirst(1);
       assertFalse("Should not be empty as it has one item", deque.isEmpty());

       deque.removeLast();
       assertTrue("Is empty again", deque.isEmpty());

    }
}