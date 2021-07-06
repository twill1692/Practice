//TODO figured out the enqueue, now work out the dequeue  alghorithm.
public class ArrayQueue {
    int arrQueue[];
    int capacity;
    int head;
    int tail;

    ArrayQueue(int size) {
        capacity = size;
        arrQueue = new int[capacity];
        tail = head = -1;
    }

    private boolean isEmpty() {
        return (head == -1);
    }

    private void enqueue(int num) {
        if (isEmpty()) {
            head = 0;
            arrQueue[head] = num;
            tail = head;
        } else if (tail + 1 == head) {
            System.out.println("Stack Overflow!");
        } else if (tail + 1 == capacity) {
            if (head != 0) {
                tail = 0;
                arrQueue[tail] = num;
            } else {
                System.out.println("Stack overflow!");
            }
        } else {
            tail = tail + 1;
            arrQueue[tail] = num;
        }
    }

    private void populate() {
        int seeder = 14;
        for (int i = 0; i < 10; i++) {
            enqueue(seeder);
            seeder--;
        }
    }

    private void printQueue() {
        for (int i = 0; i < capacity; i++) {
            System.out.println(arrQueue[i]);
        }
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(10);
        arrayQueue.populate();
        arrayQueue.enqueue(66);
        arrayQueue.printQueue();
    }
}
