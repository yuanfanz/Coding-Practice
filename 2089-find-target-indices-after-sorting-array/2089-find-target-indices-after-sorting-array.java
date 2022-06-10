class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] >= target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        int left = i;
        if (i >= nums.length) {
            return new ArrayList<>();
        }
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        int right = j;
        if (j < 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        for (int k = left; k <= right; ++k) {
            result.add(k);
        }
        return result;
    }
}










