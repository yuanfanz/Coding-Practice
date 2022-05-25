class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        
        int n = envelopes.length;
        int index = 0;
        int[] nums = new int[n];
        for (int[] cur : envelopes) {
            nums[index++] = cur[1];
        }
        int[] dp = new int[n];
        int[] sequence = new int[n];
        int len = 0;
        sequence[len++] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > sequence[len - 1]) {
                sequence[len++] = nums[i];
            } else {
                index = search(sequence, nums[i], len - 1);
                sequence[index] = nums[i];
            }
        }
        return len;
    }
    
    private int search(int[] nums, int target, int j) {
        int i = 0;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
}





















