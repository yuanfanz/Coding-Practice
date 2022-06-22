class BrowserHistory {
    Stack<String> s1;
    Stack<String> s2;
    public BrowserHistory(String homepage) {
        s1 = new Stack<>();
        s2 = new Stack<>();
        s1.push(homepage);
    }
    
    public void visit(String url) {
        // clears forward history
        s2 = new Stack<>();
        s1.push(url);
    }
    
    public String back(int steps) {
        while (s1.size() > 1 && steps > 0) {
            s2.push(s1.pop());
            steps--;
        }
        return s1.peek();
    }
    
    public String forward(int steps) {
        while (s2.size() > 0 && steps > 0) {
            s1.push(s2.pop());
            steps--;
        }
        return s1.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */