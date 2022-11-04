class Solution {
    int[] nums;
    int n;
    Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        n = nums.length;
        random = new Random();
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
        int[] res = nums.clone();
        for (int i = 0; i < n; ++i) {
            swap(res, i, i + random.nextInt(n - i));
        }
        return res;
    }
    
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */