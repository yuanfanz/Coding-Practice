class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int[][] res = new int[n][2];
        for (int i = 0; i < n; ++i) {
            res[i] = new int[]{getBit(arr[i]), arr[i]};
        }
        
        Arrays.sort(res, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] result = new int[n];
        int index = 0;
        for (int[] cur : res) {
            result[index++] = cur[1];
        }
        return result;
    }
    private int getBit(int a) {
        int count = 0;
        while (a > 0) {
            count += a & 1;
            a >>>= 1;
        }
        return count;
    }
}