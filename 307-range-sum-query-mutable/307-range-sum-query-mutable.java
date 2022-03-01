class NumArray {
    int[] arr;
    
    int[] fenwickTree;
    
    public NumArray(int[] nums) {
        int n = nums.length;
        arr = new int[n];
        fenwickTree = new int[n + 1];
        for (int i = 0; i < nums.length; ++i) {
            update(i, nums[i]);
        }
    }
    
    public void update(int index, int val) {
        int diff = val - arr[index];
        arr[index] = val;
        for (int i = index + 1; i < fenwickTree.length; i += (i & -i)) {
            fenwickTree[i] += diff;
        }
    }
    
    public int sumRange(int left, int right) {
        return getSum(right + 1) - getSum(left);
    }
    
    private int getSum(int index) {
        int sum = 0;
        while (index > 0) {
            sum += fenwickTree[index];
            index -= (index & -index);
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