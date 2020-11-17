package problems.linked_list;

public class Reverse_Linked_List {
    private Node head;
    private Node tail;

    private static class Node {
        private Node(int d) {
            data = d;
        }

        int data;
        Node next;
        Node previous;
    }

    /* Function to reverse the linked list */
    private Node reverse(Node node) {

        return node;
    }

    private void printList(Node node) {
        while (node != null) {
            System.out.println(node.data + " ");
            node = node.next;
        }
    }

    private void populate() {
        Node runner = null;
        for (int i = 1; i < 11; i++) {
            if (head == null) {
                head = new Node(i);
                runner = head;
            } else {
                runner.next = new Node(i);
                runner = runner.next;
            }
        }
    }

    public static void main(String[] args) {
        Reverse_Linked_List list = new Reverse_Linked_List();
        list.populate();
        list.printList(list.head);
    }
}