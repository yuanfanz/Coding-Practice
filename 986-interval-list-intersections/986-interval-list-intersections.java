class Solution {
    public int[][] intervalIntersection(int[][] first, int[][] second) {
        int i = 0;
        int j = 0;
        
        List<int[]> list = new ArrayList<>();
        while (i < first.length && j < second.length) {
            int start = Math.max(first[i][0], second[j][0]);
            int end = Math.min(first[i][1], second[j][1]);
            if (start <= end) {
                list.add(new int[]{start, end});
            }
            if (first[i][1] > second[j][1]) {
                j++;
            } else {
                i++;
            }
        }
        int[][] arr = new int[list.size()][2];
        int index = 0;
        for (int[] cur : list) {
            arr[index++] = cur;
        }
        return arr;
    }
}