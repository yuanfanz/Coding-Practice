class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < arr.length; ++i) {
            if (map.containsKey(arr[i] - difference)) {
                map.put(arr[i], map.get(arr[i] - difference) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        int max = 1;
        for (int key : map.keySet()) {
            int val = map.get(key);
            max = Math.max(max, val);
        }
        return max;
    }
}