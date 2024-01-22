// import StackUsingLinkedList.Stack;

import java.util.Stack;

public class StackDemo {

    // to push an element at the bottom of stack.
    static void pushToBotton(int data, Stack<Integer> stack) {
        if(stack.empty()) {
            stack.push(data);
            return;
        }

        int res = stack.pop();
        pushToBotton(data, stack);
        stack.push(res);
    }

    static void reverseStack(Stack<Integer> stack) {
        if(stack.empty()) {
            return;
        }
        int res = stack.pop();
        reverseStack(stack);
        pushToBotton(res, stack);
    }

    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(23);
        stk.push(12);
        stk.push(11);
        stk.push(110);
        pushToBotton(5, stk);
        System.out.println(stk.size());
        System.out.println(stk.peek());
        reverseStack(stk);
        while(!stk.empty()) {
            System.out.print(stk.pop()+" ");
        }
        System.out.println();
    }
}
