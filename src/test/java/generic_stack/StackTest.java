package generic_stack;

import exceptions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

public class StackTest {

    Stack stackForTesting = new Stack(3);

    @Test
    public void push_test() {
        assertDoesNotThrow(() -> stackForTesting.push(42.5), "No FullStackExc here..");

        var currentTop = stackForTesting.peek();
        assertTrue(currentTop.equals(42.5), "42.5 is the only item in the stack");

        stackForTesting.push(0.75);
        stackForTesting.push(99);

        currentTop = stackForTesting.peek();
        assertTrue(currentTop.equals(99), "The last item added must be on the top");

        assertThrows(FullStructureException.class, () -> stackForTesting.push(50), "Now throw exception");
    }

    @Test
    public void pop_test() {
        assertThrows(EmptyStructureException.class, () -> stackForTesting.pop(), "EmptyStackExc here..");

        stackForTesting.push(3.14);
        stackForTesting.push(50);
        stackForTesting.push(9.99);
        stackForTesting.pop();

        var currentTop = stackForTesting.peek();
        assertTrue(currentTop.equals(50), "An element was removed. Item 50 must move to the top");

        assertDoesNotThrow((Executable) () -> stackForTesting.pop(), "No EmptyStackExc here");

        stackForTesting.pop();
        currentTop = stackForTesting.peek();
        assertTrue(currentTop == null, "Last item was removed. The top must be null");

        assertThrows(EmptyStructureException.class, () -> stackForTesting.pop(), "EmptyStackExc again");
    }

}
