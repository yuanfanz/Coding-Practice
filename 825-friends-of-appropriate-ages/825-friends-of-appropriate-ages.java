class Solution {
    public int numFriendRequests(int[] nums) {
        double[] ages = new double[nums.length];
        int index = 0;
        for (int i : nums) {
            ages[index++] = (double) i;
        }
        Arrays.sort(ages);
        int count = 0;
        for (int i = 0; i < ages.length; ++i){
            double low = ages[i] * 0.5 + 7;
            double high = ages[i];
            // System.out.print("low: " + low + "  ");
            // System.out.println("high: " + high);
            
            // >low and <=high
            int left = searchRight(ages, low) + 1;
            int right = searchRight(ages, high);
            // System.out.print(left + "  ");
            // System.out.println(right);
            count += Math.max(right - left, 0);
        }
        return count;
    }
    
    private int searchRight(double[] nums, double target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return j;
    }
}