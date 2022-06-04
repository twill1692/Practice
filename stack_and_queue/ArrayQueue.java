//Circular array implementation of a queue.
public class ArrayQueue {
	int arrQueue[];
	int capacity;
	int elements;
	int head;
	int tail;

	ArrayQueue(int size) {
		capacity = size;
		elements = 0;
		arrQueue = new int[capacity];
		//Circular queue
		tail = head = -1;
		populate();
	}

	private boolean isEmpty() {
		return (head == -1);
	}

	private void dequeue() {
		if (isEmpty()) {
			System.out.println("Stack underflow!");
		} else if (head + 1 != capacity && head != tail) {
			System.out.println(arrQueue[head] + " was popped from the queue");
			elements--;
			head++;
		} else {
			if (head == tail) {
				System.out.println(arrQueue[head] + " was popped from the queue");
				elements--;
				head = tail = -1;
			} else if (head + 1 == capacity) {
				System.out.println(arrQueue[head] + " was popped from the queue");
				elements--;
				head = 0;
			}
		}
	}

	private void enqueue(int num) {
		if (isEmpty()) {
			head = 0;
			arrQueue[head] = num;
			elements++;
			tail = head;
		} else if (tail + 1 != capacity && tail + 1 != head) {
			tail = tail + 1;
			arrQueue[tail] = num;
			elements++;
		} else {
			if (tail + 1 == head) {
				System.out.println("Stack overflow! ");
			} else if (tail + 1 == capacity) {
				if (head != 0) {
					tail = 0;
					arrQueue[tail] = num;
					elements++;
				} else {
					System.out.println("Stack overflow! ");
				}
			}
		}
	}

	private void populate() {
		int freeSpace = capacity - elements;
		for (int i = 0; i < freeSpace; i++) {
			enqueue((int) (Math.random() * 100));
		}
	}

	private void printQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
		} else {
			for (int i = head; i < elements; i++) {
				System.out.println(arrQueue[i]);
			}
		}
	}

	public static void main(String[] args) {
		ArrayQueue arrayQueue = new ArrayQueue(10);
		System.out.println("There are " + arrayQueue.elements + " numbers in the queue");
		arrayQueue.printQueue();
		System.out.println("head is " + arrayQueue.head + " tail is " + arrayQueue.tail);
		for (int i : arrayQueue.arrQueue) {
			arrayQueue.dequeue();
			System.out.println("There are " + arrayQueue.elements + " numbers in the queue");
		}
		System.out.println("head is " + arrayQueue.head + " tail is " + arrayQueue.tail);
		arrayQueue.dequeue();
		arrayQueue.dequeue();
		arrayQueue.enqueue(99);
		arrayQueue.enqueue(45);
		arrayQueue.printQueue();
		System.out.println("There are " + arrayQueue.elements + " numbers in the queue");
		arrayQueue.dequeue();
		arrayQueue.printQueue();
		System.out.println("There are " + arrayQueue.elements + " numbers in the queue");
		System.out.println("head is " + arrayQueue.head + " tail is " + arrayQueue.tail);
		System.out.println(arrayQueue.arrQueue[1]);
		arrayQueue.populate();
		System.out.println("There are " + arrayQueue.elements + " numbers in the queue");
		arrayQueue.printQueue();
		System.out.println("head is " + arrayQueue.head + " tail is " + arrayQueue.tail);
	}
}