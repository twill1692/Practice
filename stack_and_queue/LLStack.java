//A linked list implementation of stack D.S.
public class LLStack {

    // This referance points to the top of the stack. It will always be what was
    // most recently added to the stack.
    static Node top;

    LLStack() {
        top = null;
    }

    // Push new data onto the stack with a new node.
    private void push(int num) {
        // Instantiate the new node and set the given data field with the method
        // argument given.
        Node n = new Node(num);
        // Check to see if the stack is empty (This should be its own method to be
        // called.)
        if (top == null) {
            top = n;
        } else {
            // Build the relationship chain between the nodes along the stack pattern.
            // Drawing out the logic below makes it clear.
            top.next = n;
            n.previous = top;
            top = top.next;
        }
    }

    // Push items off the stack; last in first out.
    private int pop() {
        if (isEmpty()) {
            return 0;
        }
        int popped = top.data;
        top = top.previous;
        top.next = null;
        System.out.print("Pop! " + popped + " was removed from the stack. \n");
        return popped;
    }

    // Print the stack using a node runner method, ie; a temp node that runs down
    // the list until it hits a null referance for the previous field.
    private void printStack() {
        Node tempNode = top;
        if (isEmpty()) {
            return;
        }
        while (tempNode != null) {
            System.out.println(tempNode.data);
            tempNode = tempNode.previous;
        }
    }

    private boolean isEmpty() {
        if (top == null) {
            System.out.println("The stack is empty");
        }
        return top == null;
    }

    private class Node {
        int data;
        Node next;
        Node previous;

        Node(int num) {
            this.data = num;
            next = null;
            previous = null;
        }
    }

    public static void main(String[] args) {
        LLStack stack = new LLStack();
        stack.push(3);
        stack.push(7);
        stack.push(9);
        stack.pop();
        stack.printStack();
    }
}
