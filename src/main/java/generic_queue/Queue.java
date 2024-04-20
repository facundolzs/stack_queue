package generic_queue;

import exceptions.*;

public final class Queue<T> {

    private T[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public Queue(int capacity) {
        this.front = this.size = 0;
        this.rear = -1;
        setCapacity(capacity);
        queue = (T[]) new Object[capacity];
    }

    public void setCapacity(int capacity) {
        this.capacity = (capacity < 1) ? 10 : capacity;
    }

    /**
     * Check whether the queue has reached its maximum limit of insertion of data or not
     *
     * @return 'true' if the queue is full. Otherwise, it returns 'false'.
     */
    public boolean isFull() {
        return size == capacity;
    }

    /**
     * Check whether the queue is empty or not
     *
     * @return 'true' if the queue is empty. Otherwise, it returns 'false'.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Extract the item present at the queue's front (without removing it)
     *
     * @return Item at the queue's front or 'null' if the queue is empty
     */
    public T peekFront() {
        return (!isEmpty() ? queue[front] : null);
    }

    /**
     * Insert data at the queue's rear
     *
     * @param item New item to be added
     * @throws FullStructureException if trying to add items to a full queue
     */
    public void enqueue(T item) throws FullStructureException {
        if (!isFull()) {
            rear = (rear + 1) % capacity;
            queue[rear] = item;
            size++;
        } else {
            throw new FullStructureException();
        }
    }

    /**
     * Remove data from the queue's front
     *
     * @throws FullStructureException if trying to remove items to a empty queue
     */
    public void dequeue() throws FullStructureException {
        if (!isEmpty()) {
            front = (front + 1) % capacity;
            size--;
        } else {
            throw new EmptyStructureException();
        }
    }

}
