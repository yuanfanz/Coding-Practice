class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] newArr = new int[n + 1][2];
        int index = 0;
        for (int[] cur : intervals) {
            newArr[index++] = cur;
        }
        newArr[newArr.length - 1] = newInterval;
        Arrays.sort(newArr, (a, b) -> a[0] - b[0]);
        
        List<int[]> list = new ArrayList<>();
        int[] prev = newArr[0];
        list.add(prev);
        for (int i = 1; i < newArr.length; ++i) {
            int[] cur = newArr[i];
            if (prev[1] >= cur[0]){
                int end = Math.max(cur[1], prev[1]);
                prev[1] = end;
            } else {
                list.add(cur);
                prev = cur;
            }
        }
        int[][] result = new int[list.size()][2];
        index = 0;
        for (int[] cur : list) {
            result[index++] = cur;
        }
        return result;
    }
}