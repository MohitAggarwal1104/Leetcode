import java.util.Stack;

class MyQueue {
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }
    
    public int pop() {
        peek(); // Ensure stackOut has the current front
        return stackOut.pop();
    }
    
    public int peek() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }
    
    // Returns whether the queue is empty.
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}
