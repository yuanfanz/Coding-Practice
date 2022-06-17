class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        int m = slots1.length;
        int n = slots2.length;
        int[][] total = new int[m + n][2];
        int index = 0;
        for (int[] cur : slots1) {
            total[index++] = cur;
        }
        for (int[] cur : slots2) {
            total[index++] = cur;
        }
        List<int[]> list = overlap(total);
        list = merge(list.stream().toArray(int[][]::new));
        
        for (int[] cur : list) {
            if (cur[1] - cur[0] >= duration) {
                return new ArrayList<>(Arrays.asList(cur[0], cur[0] + duration));
            }
        }
        return new ArrayList<>();
    }
    
    public List<int[]> overlap(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int[] prev = intervals[0];
        List<int[]> result = new ArrayList<>();
        int i = 1;
        while (i < intervals.length) {
            if (prev[1] >= intervals[i][0]) {
                int start = intervals[i][0];
                int end = Math.min(prev[1], intervals[i][1]);
                result.add(new int[]{start, end});
            }
            if (prev[1] <= intervals[i][1]) {
                prev = intervals[i++];
            } else {
                i++;
            }
        }
        return result;
    }
    
    public List<int[]> merge(int[][] intervals) {
        // Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int[] prev = intervals[0];
        List<int[]> list = new ArrayList<>();
        list.add(prev);
        int i = 1;
        while (i < intervals.length) {
            if (prev[1] >= intervals[i][0]) {
                prev[1] = Math.max(prev[1], intervals[i][1]);
            } else {
                prev = intervals[i];
                list.add(intervals[i]);
            }
            i++;
        }
        return list;
    }
}