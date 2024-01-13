// package LinkedList;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    LinkedList() {
        this.head = null;
    }

    public void addToLast(int data) {
        Node currNode = new Node(data);
        if(head == null) {
            head = currNode;
            return;
        }

        Node nextCurr = head;
        while(nextCurr.next != null) {
            nextCurr = nextCurr.next;
        }
        nextCurr.next = currNode;
    }

    public void addToFirst(int data) {
        Node currNode = new Node(data);
        if(head == null) {
            head = currNode;
            return;
        }

        currNode.next = head;
        head = currNode;
    }

    public void printNodes() {
        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data+" -> ");
            currNode = currNode.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public void addAtIndex(int data, int index) {
        Node currNode = new Node(data);
        if(index >= getSizeOfList() || index < 0) {
            System.out.println("Invalid index");
            return;
        }

        if(index == 0) {
            addToFirst(data);
            return;
        }

        Node nextNode = head;
        while(index > 1) {
            nextNode = nextNode.next;
            index--;
        }

        currNode.next = nextNode.next;
        nextNode.next = currNode;
    }

    public int removeFromTop() {
        Node currNode = head;
        head = head.next;
        return currNode.data;
    }

    public int removeFromIndex(int index) {
        Node currNode = head;
        if(index == 0) {
            return removeFromTop();
        }

        while(index > 1) {
            currNode = currNode.next;
            index--;
        }
        int data = currNode.next.data;
        currNode.next = currNode.next.next;
        return data;
    }

    public boolean searchAnElement(int ele) {
        Node currNode = head;
        while(currNode != null) {
            if(currNode.data == ele) return true;
            currNode = currNode.next;
        }
        return false;
    }

    public int getSizeOfList() {
        Node currNode = head;
        int count = 0;
        while(currNode != null) {
            count++;
            currNode = currNode.next;
        }
        return count;
    }

    public void reverseALinkedList() {
        Node prevNode = head;
        Node currNode = head.next;

        if(getSizeOfList() <= 1) return;

        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }

    public int deleteNthNodeFromLast(int index) {
        Node currNode = head;
        int count = getSizeOfList() - index;
        while (count > 1) {
            currNode = currNode.next;
            count--;
        }
        int data = currNode.next.data;
        currNode.next = currNode.next.next;
        return data;
    }

    public boolean palindrome() {
        String str = "";
        Node currNode = head;
        while (currNode != null) {
            str = str + currNode.data;
            currNode = currNode.next;
        }
        int size = getSizeOfList();
        for(int i = 0; i < size; i++) {
            if(str.charAt(i) != str.charAt(size - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public void convertArrayToLL(int arr[]) {
        Node arrNode = new Node(arr[0]);
        this.head = arrNode;
        Node currNode = this.head; 

        for(int i = 1; i < arr.length; i++) {
            arrNode = new Node(arr[i]);
            currNode.next = arrNode;
            currNode = arrNode;
        }
    }
}

public class Basics {
    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        int []arr = {1,2,3,4,5,6,7,8,9,10};
        ls.convertArrayToLL(arr);
        ls.addToFirst(20);
        ls.printNodes();
    }
}
