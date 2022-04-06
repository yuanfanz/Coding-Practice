class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int mod = 1000000007;
        int count = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < arr.length; ++i) {
            count = (count + map.getOrDefault(target - arr[i], 0)) % mod;
            for (int j = 0; j < i; ++j) {
                int sum = arr[i] + arr[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        return count;
    }
}