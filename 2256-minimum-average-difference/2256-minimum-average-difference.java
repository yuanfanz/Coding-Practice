class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        
        double[] presum = new double[n + 1];
        for (int i = 0; i < n; ++i) {
            presum[i + 1] = presum[i] + nums[i];
        }
        int[] average = new int[n];
        for (int i = 1; i <= n; ++i) {
            double first = presum[i];
            double second = presum[n] - presum[i];
            
            int firstNum = i;
            int secondNum = n - i;
            
            if (secondNum == 0) {
                average[i - 1] = Math.abs((int) Math.floor(first/firstNum));
                // continue;
            } else {
                // System.out.print(first/firstNum + " ");
                // System.out.println(second/secondNum + " ");
                int diff = Math.abs((int) Math.floor(first/firstNum) - (int) Math.floor(second/secondNum));
                average[i - 1] = diff;
            }
        }
        // print(presum);
        // print(average);
        int min = average[0];
        int res = 0;
        for (int i = 1; i < n; ++i) {
            // if (i == 29403) {
            //         System.out.println("29403: " + average[i]);
            //     }
            //     if (i == 49988) {
            //         System.out.println("49988: " + average[i]);
            //     }
            if (average[i] < min) {
                
                min = average[i];
                res = i;
            }
        }
        return res;
    }
    private void print(int[] grid) {
        for (int i = 0; i < grid.length; ++i) {
            System.out.print(grid[i] + " ");
        }
        System.out.println();
    }
}