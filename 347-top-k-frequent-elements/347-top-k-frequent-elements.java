class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int key : map.keySet()) {
            int val = map.get(key);
            if (bucket[val] == null) {
                bucket[val] = new ArrayList<>();
            }
            bucket[val].add(key);
        }
        List<Integer> result = new ArrayList<>();
        
        for (int i = bucket.length - 1; i >= 0 && k > 0; --i) {
            List<Integer> list = bucket[i];
            if (list != null) {
                result.addAll(list);
                k -= list.size();
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}