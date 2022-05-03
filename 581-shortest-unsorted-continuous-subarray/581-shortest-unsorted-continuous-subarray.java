class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] arr = nums.clone();
        int n = nums.length;
        Arrays.sort(arr);
        int i = 0;
        int j = n - 1;
        while (i < n && arr[i] == nums[i]) {
            i++;
        }
        while (j > i && arr[j] == nums[j]) {
            j--;
        }
        return j - i + 1;
    }
}