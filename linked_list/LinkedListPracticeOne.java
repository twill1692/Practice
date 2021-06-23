
class LinkedListPracticeOne {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    private Boolean isEmpty() {
        return head == null;
    }

    // TODO
    // Give it an index (Write a function to tell how big the bloody thing is)
    // and it goes to that location and spits out a referance to that node.
    // private Node goTo(int i) {
    // Node n = null;
    // while
    // return n;
    // }

    private void size() {
        Node n = null;
        int counter = 0;
        if (isEmpty()) {
            return;
        } else {
            n = head;
        }
        while (n.next != null) {
            counter++;
            n = n.next;
        }
        System.out.println("The list has " + counter + " nodes");
    }

    private Node populateNodes() {
        head = new Node(1);
        Node n = head;
        for (int i = 2; i < 12; i++) {
            n.next = new Node(i);
            n = n.next;
        }
        return head;
    }

    private void printList() {
        Node n = null;
        if (isEmpty()) {
            return;
        } else {
            n = head;
        }
        while (n.next != null) {
            System.out.println(n.data);
            n = n.next;
        }

    }

    public static void main(String[] args) {
        LinkedListPracticeOne ll = new LinkedListPracticeOne();
        ll.printList();
        ll.populateNodes();
        ll.printList();
        ll.size();
        // ll.goTo(3);
    }
}