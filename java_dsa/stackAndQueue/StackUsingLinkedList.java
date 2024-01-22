// package stackAndQueue;

import java.util.Stack;

public class StackUsingLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        static Node head;
        public static int push(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            return head.data;
        }

        public static boolean isEmpty() {
            if(head == null) {
                return true;
            } 
            return false;
        }

        public static int peek() {
            if(isEmpty()) return -1;
            return head.data;
        }

        public static int pop() {
            if(isEmpty()) return -1;
            int top = head.data;
            head = head.next;
            return top;
        }
    }

    public static void main(String[] args) {
        Stack.push(2);
        Stack.push(10);
        System.out.println(Stack.push(27));
        System.out.println(Stack.isEmpty());
        System.out.println(Stack.peek());
        while (!Stack.isEmpty()) {
            System.out.println(Stack.pop());
        }
    }
}
