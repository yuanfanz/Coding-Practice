
public class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        addAll(nestedList);
    }

    @Override
    public Integer next() {
        return hasNext() ? stack.pop().getInteger() : null;
    }

    @Override
    public boolean hasNext() {
        while (stack.size() > 0) {
            if (stack.peek().isInteger()) {
                return true;
            } else {
                addAll(stack.pop().getList());
            }
        }
        return false;
    }
    
    private void addAll(List<NestedInteger> list) {
        for (int i = list.size() - 1; i >= 0; --i) {
            stack.push(list.get(i));
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */