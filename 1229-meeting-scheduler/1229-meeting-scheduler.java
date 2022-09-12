class Solution {
    public List<Integer> minAvailableDuration(int[][] first, int[][] second, int duration) {
        Arrays.sort(first, (a, b) -> a[0] - b[0]);
        Arrays.sort(second, (a, b) -> a[0] - b[0]);
        
        int i = 0;
        int j = 0;
        
        List<int[]> list = new ArrayList<>();
        while (i < first.length && j < second.length) {
            int start = Math.max(first[i][0], second[j][0]);
            int end = Math.min(first[i][1], second[j][1]);
            if (end - start >= duration) {
                return Arrays.asList(start, start + duration);
            }
            if (first[i][1] > second[j][1]) {
                j++;
            } else {
                i++;
            }
        }
        return new ArrayList<>();
    }
}