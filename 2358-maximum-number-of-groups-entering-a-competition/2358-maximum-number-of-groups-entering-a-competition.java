class Solution {
    public int maximumGroups(int[] grades) {
        int n = grades.length;
        int cur = 2;
        int num = 0, res = 0;
        while (num < n) {
            num += cur;
            cur++;
            res++;
        }
        return res;
    }
}