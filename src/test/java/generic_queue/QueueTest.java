package generic_queue;

import exceptions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

public class QueueTest {

    Queue queueForTesting = new Queue(3);

    @Test
    public void enqueue_test() {
        assertDoesNotThrow(() -> queueForTesting.enqueue(-7), "No QueueFullExc here..");

        queueForTesting.enqueue(12);
        queueForTesting.enqueue(95);

        var currentFront = queueForTesting.peekFront();
        assertTrue(currentFront.equals(-7), "The first item added should be on the front");

        assertThrows(FullStructureException.class, () -> queueForTesting.enqueue(77), "Now throw exception");
    }

    @Test
    public void dequeue_test() {
        assertThrows(EmptyStructureException.class, () -> queueForTesting.dequeue(), "EmptyQueueExc here..");

        queueForTesting.enqueue(42);
        queueForTesting.enqueue(75);
        queueForTesting.enqueue(-30);
        queueForTesting.dequeue();

        var currentFront = queueForTesting.peekFront();
        assertTrue(currentFront.equals(75), "An element was removed. Item 75 must move to the front");

        assertDoesNotThrow((Executable) () -> queueForTesting.dequeue(), "No EmptyQueueExc here");

        currentFront = queueForTesting.peekFront();
        assertTrue(currentFront.equals(-30), "An element was removed. Item -30 must move to the front");

        queueForTesting.dequeue();
        currentFront = queueForTesting.peekFront();
        assertTrue(currentFront == null, "Last item was removed. The front must be null");

        assertThrows(EmptyStructureException.class, () -> queueForTesting.dequeue(), "EmptyQueueExc again");
    }

}
