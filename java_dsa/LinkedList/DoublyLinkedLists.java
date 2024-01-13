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

    static void addNode(int data) {
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

    static void printNode() {
        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data+" ≓ ");
            currNode = currNode.next;
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

    public static void main(String[] args) {
        int arr[] = {4,5,1,2,3,4,5};
        arrayToDLL(arr);
        addNodeToFirst(10);
        System.out.println(deleteHead().data);
        printNode();
    }
}
