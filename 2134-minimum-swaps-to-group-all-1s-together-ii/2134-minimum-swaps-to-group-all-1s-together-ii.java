class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        int[] arr = new int[n * 2];
        for (int i = 0; i < n * 2; ++i) {
            arr[i] = nums[i % n];
        }
        int total = 0;
        for (int i : nums) {
            total += i;
        }
        
        int count = 0;
        int max = 0;
        // int j = 0;
        // printIndex(arr.length - 1);
        // print(arr);
        // for (int i = 0; i < arr.length; ++i) {
        //     while (j < arr.length && j - i + 1 < total) {
        //         if (arr[j++] == 1) {
        //             count++;
        //         }
        //         // System.out.print(i + " ");
        //         // System.out.print(j + "    ");
        //     }
        //     max = Math.max(max, count);
        //     if (arr[i] == 1) {
        //         count--;
        //     }
        // }
        int i = 0;
        for (int j = 0; j < arr.length; ++j) {
            if (arr[j] == 1) {
                count++;
            }
            while (i < arr.length && j - i + 1 > total) {
                if (arr[i++] == 1) {
                    count--;
                }
            }
            if (j - i + 1 == total) {
                max = Math.max(max, count);
            }
        }
        return total - max;
    }
    private void printIndex(int n) {
        for (int i = 0; i < n; ++i) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    private void print(int[] grid) {
        for (int i = 0; i < grid.length; ++i) {
            System.out.print(grid[i] + " ");
        }
        System.out.println();
    }
}