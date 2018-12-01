class MyQueue {
    
    Stack<Integer> F;
    Stack<Integer> B;
    /** Initialize your data structure here. */
    public MyQueue() {
        F = new Stack<>();
        B = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        F.push(x);
    }
    
    private void reverse() {
        if (B.isEmpty()){
            while (!F.isEmpty()){
                B.push(F.pop());
            }
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        reverse();
        return B.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        reverse();
        return B.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        reverse();
        return B.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
