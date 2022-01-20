class Solution {
    public int trap(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                leftMax = Math.max(leftMax, height[i]);
                res += leftMax - height[i];
                i++;
            } else {
                rightMax = Math.max(rightMax, height[j]);
                res += rightMax - height[j];
                j--;
            }
        }
        return res;
    }
}