class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (int j = i; j < n; ++j) {
                if (nums[j] % p == 0) {
                    count++;
                }
                if (count <= k) {
                    sb.append(nums[j] + "_");
                    set.add(sb.toString());
                } else {
                    break;
                }
            }
        }
        // print(set);
        return set.size();
    }
    
    private void print(Set<String> set) {
        for (String i : set) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}