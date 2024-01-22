class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedLists {
    static Node head;

    static void addNodeToLast(int data) {
        Node currNode = new Node(data);
        if(head == null) {
            head = currNode;
            return;
        }

        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = currNode;
        currNode.prev = temp;
    }

    static void addNodeToFirst(int data) {
        Node temp = new Node(data);
        temp.next = head;
        head.prev = temp;
        head = temp;
    }

    static void addNodeToIndex(Node node, int index) { // considering 1 based indexing
        if(index > getLengthOfDLL() || index <= 0) return;
        else if(index == 1) {
            addNodeToFirst(node.data);
            return;
        }

        Node currNode = head;
        while(index > 2) {
            currNode = currNode.next;
            index--;
        }
        node.prev = currNode;
        node.next = currNode.next;
        currNode.next.prev = node;
        currNode.next = node;
    }

    static Node deleteHead() {
        Node prevNode = head;
        if(prevNode == null || prevNode.next == null) {
            return prevNode;
        }
        head = head.next;
        head.prev = null;
        prevNode.next = null;
        return prevNode;
    }

    static Node deleteTail() {
        Node prevNode = head;
        Node currNode = prevNode.next;
        while(currNode.next != null) {
            prevNode = currNode;
            currNode = currNode.next;
        }

        currNode.prev = null;
        prevNode.next = null;
        return currNode;
    }

    static Node deleteAtIndex(int index) {
        Node currNode = head;
        if(index == 1) return deleteHead();

        while(index > 1) {
            currNode = currNode.next;
            index--;
        }
        currNode.next.prev = currNode.prev;
        currNode.prev.next = currNode.next;
        currNode.next = null;
        currNode.prev = null;
        return currNode;
    }

    static void printDLL() {
        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data+" ≓ ");
            currNode = currNode.next;
        }
        System.out.print("null");
        System.out.println();
    }

    static void printReverseDLL() {
        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data+" ≓ ");
            currNode = currNode.prev;
        }
        System.out.print("null");
        System.out.println();
    }

    static void arrayToDLL(int arr[]) {
        int length = arr.length;
        Node firstNode = new Node(arr[0]);
        head = firstNode;
        Node currNode = head;

        for(int i = 1; i < length; i++) {
            Node temp = new Node(arr[i]);
            currNode.next = temp;
            temp.prev = currNode;
            currNode = temp;
        }
    }

    static void reverseDLL() {
        while(head.next != null) {
            head = head.next;
        }
    }

    static int getLengthOfDLL() {
        Node currNode = head;
        int count = 0;
        while (currNode != null) {
            currNode = currNode.next; 
            count++;           
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {4,5,1,2,3,4,5};
        arrayToDLL(arr);
        addNodeToFirst(10);
        addNodeToLast(24);
        // System.out.println(deleteHead().data);
        // System.out.println(deleteTail().data);
        // System.out.println(deleteAtIndex(4).data);
        Node node = new Node(32);
        addNodeToIndex(node, 4);
        printDLL();
        // reverseDLL();
        // printReverseDLL();
        System.out.println(getLengthOfDLL());
    }
}
