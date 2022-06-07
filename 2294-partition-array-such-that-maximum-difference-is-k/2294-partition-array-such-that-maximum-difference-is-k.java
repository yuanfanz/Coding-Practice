class Solution {
    public int partitionArray(int[] nums, int k) {
        int i = 0;
        int j = nums.length;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (isValid(nums, mid, k)) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return j;
    }
    
    private boolean isValid(int[] nums, int mid, int k) {
        int count = 0;
        
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length) {
            int min = nums[i];
            int max = nums[i];
            int j = i;
            while (max - min <= k && j < nums.length) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                if (max - min > k) break;
                j++;
            }
            i = j;
            if (i < nums.length) {
                count++;
            }
        }
        return count + 1 <= mid;
    }
}
