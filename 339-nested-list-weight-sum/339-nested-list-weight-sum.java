
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }
    private int dfs(List<NestedInteger> nestedList, int level) {
        int result = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                result += ni.getInteger() * level;
            } else {
                result += dfs(ni.getList(), level + 1);
            }
        }
        return result;
    }
}