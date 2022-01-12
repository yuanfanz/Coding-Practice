class Solution {
    int max = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        dfs(nestedList, 1);
        return getSum(nestedList, 1, max);
    }
    private int getSum(List<NestedInteger> nestedList, int level, int max) {
        int total = 0;
        for (NestedInteger ni : nestedList) {
            if (!ni.isInteger()) {
                total += getSum(ni.getList(), level + 1, max);
            } else {
                total += ni.getInteger() * (max - level + 1);
            }
        }
        return total;
    }
    private void dfs(List<NestedInteger> nestedList, int level) {
        if (nestedList.size() == 0) {
            return;
        }
        max = Math.max(max, level);
        for (int i = 0; i < nestedList.size(); ++i) {
            NestedInteger ni = nestedList.get(i);
            if (!ni.isInteger()) {
                dfs(ni.getList(), level + 1);
            }
        }
    }
}

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */