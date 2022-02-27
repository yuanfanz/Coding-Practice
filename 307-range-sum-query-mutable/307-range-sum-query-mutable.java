class NumArray {
    int[] fenwickTree;
    int len;
    int[] arr;
    public NumArray(int[] nums) {
        len = nums.length;
        arr = new int[len];
        fenwickTree = new int[len + 1];
        
        for (int i = 0; i < len; ++i) {
            update(i, nums[i]);
        }
    }
    
    public void update(int index, int val) {
        int diff = val - arr[index];
        arr[index] = val;
        for (int i = index + 1; i <= len; i += (i & -i)) {
            fenwickTree[i] += diff;
        }
    }
    
    public int sumRange(int left, int right) {
        return getSum(right + 1) - getSum(left);
    }
    
    private int getSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += fenwickTree[i];
            i -= (i & -i);
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */