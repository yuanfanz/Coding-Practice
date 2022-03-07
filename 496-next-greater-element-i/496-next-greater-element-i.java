class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; ++i) {
            if (stack.isEmpty()) {
                stack.push(nums2[i]);
            } else {
                while (stack.size() > 0 && nums2[i] > stack.peek()) {
                    int cur = stack.pop();
                    map.put(cur, nums2[i]);
                }
                stack.push(nums2[i]);
            }
        }
        int[] result = new int[nums1.length];
        int index = 0;
        for (int i : nums1) {
            result[index++] = map.getOrDefault(i, -1);
        }
        return result;
    }
}