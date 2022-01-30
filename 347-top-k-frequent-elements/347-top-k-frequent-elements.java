class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        ArrayList[] bucket = new ArrayList[n + 1];
        for (int key : map.keySet()) {
            int val = map.get(key);
            if (bucket[val] == null) {
                bucket[val] = new ArrayList<>();
            }
            bucket[val].add(key);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && k > 0; --i) {
            if (bucket[i] == null) continue;
            List<Integer> list = bucket[i];
            result.addAll(list);
            k -= list.size();
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}