class MinStack {
    Stack<Integer> st1;
     Stack<Integer> st2;
    public MinStack() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int val) {
        st1.push(val);
        if (st2.size()>0){
            int min = Math.min(st2.peek(),val);
            st2.push(min);
        }
        else if (st2.size()==0){
            st2.push(val);
        }
    }
    
    public void pop() {
        if (st1.size()>0){
            st1.pop();
            st2.pop();
        }
    }
    
    public int top() {
        int x = 0;
        if (st1.size()>0){
            x = st1.peek();
        }
        
        return x;
    }
    
    public int getMin() {
        return st2.peek();
    }
}
