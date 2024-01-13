package LinkedList;
class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}


public class LinkedLists {
    static Node head;
    public static void addFirst(String data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
        
    }

    public static void addLast(String data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }

        Node currNode = head;
        while(currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }

    public static void printList() {
        if(head == null) {
            System.out.println("List is empty");
        }
        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    public static void reverseLinkedList() {
        if(head == null || head.next == null) {
            return;
        }

        Node prevNode = head;
        Node currNode = head.next;

        while(currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        head.next = null;
        head = prevNode;
    }

    public static void delete_nth_node_from_last(int n) {
        Node currNode = head; // this node will iterate to last of the list for getting total count of nodes.
        Node newNode = head; // this will point to one node before the actual node to be deleted.
        if(head == null) return;

        int totalCount = 1; // stores total count of nodes in list.
        while(currNode.next != null) {
            currNode = currNode.next;
            totalCount++;
        }

        if(n == totalCount) { // special case when head is to be removed.
            head = head.next;
            newNode.next = null;
            System.out.println(newNode.data);
            return;
        }

        int currentCount = 1; // keeps the track of current node.
        while(currentCount < totalCount - n) { // logic to remove nth node from last.
            newNode = newNode.next;
            currentCount++;
        }
        Node nodeRemoved = newNode.next; // this node contains the deleted node.
        newNode.next = newNode.next.next;
        System.out.println(nodeRemoved.data);
    }

    // public static boolean checkPalindrome(Node n) {

    // }
    
    public static void main(String[] args) {
        // addFirst("good person");
        // addFirst("a");
        // addFirst("is");
        // addFirst("anupam");
        // printList();
        // reverseLinkedList();
        // delete_nth_node_from_last(1);

        
        printList();
    }
}