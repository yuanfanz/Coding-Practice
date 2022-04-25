class Solution {
    public int[] findRightInterval(int[][] intervals) {
        
        Map<int[], Integer> map = new HashMap<>();
        int n = intervals.length;
        for (int i = 0; i < n; ++i) {
            map.put(intervals[i], i);
        }
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            int[] cur = intervals[i];
            int first = map.get(cur);
            if (cur[0] == cur[1]) {
                res[first] = first;
                continue;
            }
            int index = search(intervals, i + 1, cur[1]);
            if (index != -1) {
                // System.out.println(index);
                int[] right = intervals[index];
                // System.out.println(right[0]);
                // System.out.println(right[1]);
                res[first] = map.get(right);
            } else {
                res[first] = -1;
            }
        }
        return res;
    }
    
    private int search(int[][] intervals, int start, int target) {
        int i = start;
        int j = intervals.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (intervals[mid][0] >= target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        if (i >= intervals.length) {
            return -1;
        }
        return i;
    }
}