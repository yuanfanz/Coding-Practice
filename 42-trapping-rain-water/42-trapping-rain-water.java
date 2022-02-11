class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(height[left], leftMax);
                res += leftMax - height[left++];
            } else {
                rightMax = Math.max(height[right], rightMax);
                res += rightMax - height[right--];
            }
        }
        return res;
    }
}