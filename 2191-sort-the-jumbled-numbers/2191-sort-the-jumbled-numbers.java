class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>
            ((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        
        for (int i = 0; i < nums.length; ++i) {
            String s = String.valueOf(nums[i]);
            int num = 0;
            // System.out.println(nums[i]);
            for (int j = 0; j < s.length(); ++j) {
                // if (s.charAt(j) == '0') continue;
                num = num * 10 + (mapping[s.charAt(j) - '0']);
            }
            // System.out.println(num);
            pq.offer(new int[]{nums[i], num, i});
        }
        int[] result = new int[nums.length];
        int index = 0;
        while (pq.size() > 0) {
            result[index++] = pq.poll()[0];
        }
        return result;
    }
}