class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int len = nums.length;
        
        int leftIndex = findLeft(nums, target);
        int rightIndex = findRight(nums, target);
        
        // System.out.println("leftIndex: " + leftIndex);
        // System.out.println("rightIndex: " + rightIndex);
        
        if (rightIndex - leftIndex + 1 >= len / 2 + 1) {
            return true;
        }
        return false;
    }
    
    private int findLeft(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                j = mid - 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
    
    private int findRight(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                i = mid + 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return j;
    }
}