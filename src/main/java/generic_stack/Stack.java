package generic_stack;

import exceptions.*;

public final class Stack<T> {

    private T[] stack;
    private int size;
    private int top;

    public Stack(int size) {
        setSize(size);
        this.stack = (T[]) new Object[size];
        this.top = -1;
    }

    public void setSize(int size) {
        this.size = (size < 1) ? 10 : size;
    }

    /**
     * Check whether the stack has reached its maximum limit of insertion of data or not
     *
     * @return 'true' if the stack is full. Otherwise, it returns 'false'.
     */
    public boolean isFull() {
        return top == size - 1;
    }

    /**
     * Check whether the stack is empty or not
     *
     * @return 'true' if the stack is empty. Otherwise, it returns 'false'.
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Extract the item present at the stack's top (without removing it)
     *
     * @return Item at the stack's top or 'null' if the stack is empty
     */
    public T peek() {
        return (!isEmpty()) ? stack[top] : null;
    }

    /**
     * Insert data at the stack's top
     *
     * @param item New item to be added
     * @throws FullStructureException if trying to add items to a full stack
     */
    public void push(T item) throws FullStructureException {
        if (!isFull()) {
            top++;
            stack[top] = item;
        } else {
            throw new FullStructureException();
        }
    }

    /**
     * Remove data from the stack's top
     *
     * @throws EmptyStructureException if trying to remove items to a empty stack
     */
    public void pop() throws EmptyStructureException {
        if (!isEmpty()) {
            top--;
        } else {
            throw new EmptyStructureException();
        }
    }

}
