// Simple array implementation of a stack.
public class ArrayStack {

    // store elements of stack
    private int stack[];

    // represent top of stack
    private int top;

    // total capacity of the stack
    private int capacity;

    // Creating a stack
    ArrayStack(int size) {
        // initialize the array
        // initialize the stack variables
        stack = new int[size];
        capacity = size;
        top = -1;
    }

    // push elements to the top of stack
    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack overflow");
            return;
        } else {
            stack[++top] = x;
        }
    }

    // pop elements from top of stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return 0;
        } else {
            return stack[top--];
        }
    }

    // return size of the stack
    public int getSize() {
        // This doesnt work; it just returns a capacity and not the size of the stack.
        // return stack.length;
        // +1 because top is tracking the array index which starts at zero
        return top + 1;
    }

    // check if the stack is empty
    public Boolean isEmpty() {
        // -1 because the an element will be at the zero position
        return top == -1;
    }

    // check if the stack is full
    public Boolean isFull() {
        // Capacity -1 because top starts at zero instead of one
        return top == capacity - 1;
    }

    // display elements of stack
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            for (int i = 0; i <= top; i++) {
                System.out.println(stack[i]);
            }
        }
    }

    public static void main(String[] args) {
        ArrayStack arrStack = new ArrayStack(10);
        arrStack.push(5);
        System.out.print(arrStack.isEmpty() + "\n");
        System.out.println(arrStack.getSize());
        arrStack.printStack();
        System.out.print(arrStack.pop() + " was removed from the stack \n");
        System.out.print(arrStack.isEmpty() + "\n");
    }
}