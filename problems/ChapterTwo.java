package problems;

import java.util.HashSet;

public class ChapterTwo {

    private class LinkedList {
        private Node head;
        private Node tail;

        // Runner method for removing dupes starts with a pointer to the head and
        // another to the next ahead
        // of the head, called the runner. The head is compared to the runner as it runs
        // through the nodes.
        // Once the end is reached, the head increments and the process continues as
        // before until all dupes
        // are removed.
        void removeDupesWithRunner() {
            Node n = head;
            while (n != null) {
                Node runner = n;
                while (runner.next != null) {
                    if (n.data == runner.next.data) {
                        if (runner.next == null) {
                            runner.previous.next = null;
                            runner = runner.next;
                        } else {
                            runner.next.previous = runner.previous;
                            runner.previous.next = runner.next;
                            runner = runner.next;
                        }
                    } else {
                        runner = runner.next;
                    }
                }
                n = n.next;
            }
        }

        // This method is brocken and not adjusting the tail pointer.
        // Using a HashSet object to store the contents of the data in the nodes.
        // HashSet cannot contain dupes as compared to a list which can. We could
        // probably the alter the
        // logic in this method to take advantage of the fact that intset cant contain
        // dupes as the way its
        // currently written, any sort of collection object would work just as
        // effectively.
        void removeDupesWithSet() {
            HashSet<Integer> intSet = new HashSet<Integer>();
            Node n = head;
            while (n != null) {
                if (intSet.contains(n.data)) {
                    if (n.next == null) {
                        n.previous.next = null;
                        n = n.next;
                    } else {
                        n.next.previous = n.previous;
                        n.previous.next = n.next;
                        n = n.next;
                    }
                } else {
                    intSet.add(n.data);
                    n = n.next;
                }
            }
        }

        // Prints the contents of the nodes as well as the head/head.next and
        // tail/tail.previous.
        void printNodeData() {
            Node n = head;
            if (n == null) {
                System.out.println("There is no data");
            } else {
                while (n != null) {
                    System.out.println(n.data);
                    n = n.next;
                }
                System.out.println("The head is " + head.data + " the tail is " + tail.data);
                System.out.println("The head next is " + head.next.data + " tail previous is " + tail.previous.data);
            }
        }

        void printBackwards() {
            Node t = tail;
            while (t != null) {
                System.out.println(t.data);
                t = t.previous;
            }
        }

        // Start with a pointer to head and iterate through the nodes until the end.
        // end.next gets the
        // newly created node appended and becomes the new tail with its previous field
        // being the former
        // tail.
        void appendToEnd(int data) {
            Node end = new Node(data);
            if (head == null) {
                head = end;
            } else {
                Node n = head;
                while (n.next != null) {
                    n = n.next;
                }
                n.next = end;
                end.previous = n;
                tail = end;
            }
        }

        // Reasigns the head to a newly created node, the former head is placed next.
        // Will this break the previous if I wanted to print out going in reverse?
        void addToBegining(int data) {
            Node begining = new Node(data);
            if (head == null) {
                head = begining;
            } else {
                Node n = head;
                head = begining;
                head.next = n;
                n.previous = head;
            }
        }

        // Given a target where to insert the new node, goes through the nodes until it
        // findes the target
        // it and inserts it prior to the target, see problem in comment below. Might be
        // better to insert
        // after?
        void insert(int target, int data) {
            Node n = head;
            while (n != null) {
                if (n.data == target) {
                    Node newNode = new Node(data);
                    Node nextNode = n.next;
                    newNode.next = nextNode;
                    newNode.previous = n;
                    nextNode.previous = newNode;
                    n.next = newNode;
                    // Quick fix for infinite loop where target of insert = data causing a constant
                    // insert state. This method needs improvement.
                    if (target == data) {
                        n = newNode.next;
                    } else
                        n = newNode;
                } else {
                    n = n.next;
                }
            }
        }

        // Creates ten nodes with date = 1-10
        void populateNodes() {
            Node n = head;
            for (int i = 1; i < 11; i++) {
                if (n == null) {
                    n = new Node(i);
                    head = n;
                    tail = n;
                } else {
                    LinkedList.Node newNode = new Node(i);
                    n.next = newNode;
                    newNode.previous = n;
                    n = newNode;
                    tail = n;
                }
            }
        }

        // kthTTL = k'th To The Last.
        // Printing using an overloaded method and a mimic'd pass be reference using an
        // array in order
        // to keep a running counter that wont be reset as the stack regresses through
        // the method calls.
        Node kthTTL(Node head, int target) {
            int[] counter = { 0 };
            return kthTTL(head, target, counter);
        }

        Node kthTTL(Node head, int target, int[] counter) {
            if (head == null) {
                return null;
            }
            Node node = kthTTL(head.next, target, counter);
            counter[0] = counter[0] + 1;
            if (target == counter[0]) {
                node = head;
            }
            return node;
        }

        // Nodes with data less than the value of the pivot nodes data goes to the left
        // and larger to the right.
        Node partitionNodes(Node head, int pivot) {
            Node dummyHead = head;
            Node dummyTail = head;
            while (head != null) {
                Node next = head.next;
                // Insert node at head if its less than pivot
                if (head.data < pivot) {
                    head.next = dummyHead;
                    dummyHead = head;
                } else {
                    dummyTail.next = head;
                    dummyTail = head;
                }
                head = next;
            }
            dummyTail.next = null;
            return dummyHead;
        }

        private class Node {
            int data;
            Node next;
            Node previous;

            private Node() {
            }

            private Node(int data) {
                this.data = data;
            }
        }
    }

    // Main method
    public static void main(final String[] args) {
        ChapterTwo myClass = new ChapterTwo();
        LinkedList list = myClass.new LinkedList();
        list.populateNodes();
        list.appendToEnd(11);
        list.appendToEnd(11);
        list.addToBegining(0);
        list.insert(8, 8);
        // This method is not correcting the tail previous pointer.
        // list.removeDupesWithSet();
        list.removeDupesWithRunner();
        LinkedList.Node muhNode = list.kthTTL(list.head, 4);
        System.out.println("oooOwhee I'm 4th from the last " + muhNode.data);
        list.head = list.partitionNodes(list.head, 5);
        list.printNodeData();
    }
}