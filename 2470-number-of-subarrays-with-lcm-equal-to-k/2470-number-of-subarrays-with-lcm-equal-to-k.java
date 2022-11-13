class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int res = 0;
        
        int lcm = nums[0];
        for (int i = 0; i < nums.length; ++i) {
            int curlcm = nums[i];
            
            if (curlcm == k) res++;
            
            for (int j = i + 1; j < nums.length; ++j) {
                // if (nums[j] < k) {
                //     break;
                // }
                curlcm = getlcm(nums[j], curlcm);
                if (curlcm == k) res++;
            }
        }
        return res;
    }
    
    public int getlcm(int a, int b) {
       if (b==0) return 0;
       return a * b / gcd(b,a%b);
    }
    
    public int gcd(int a, int b) {
       if (b==0) return a;
       return gcd(b,a%b);
    }
}