class Solution {
    public String nextPalindrome(String num) {
        int len = num.length();
        if (len < 2) return "";
        
        int[] arr = new int[len / 2];
        for (int i = 0; i < len / 2; ++i) {
            arr[i] = num.charAt(i) - '0';
        }
        if (!nextPermutation(arr)) return "";
        
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
        }
        if (len % 2 == 0) return sb.toString() + sb.reverse().toString();
        return sb.toString() + num.substring(len / 2, len / 2 + 1) + sb.reverse().toString();
    }
    
    public boolean nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
            i--;
        }
        
        // System.out.println(i);
        if (i == -1) return false;
        
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
        return true;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    private void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}