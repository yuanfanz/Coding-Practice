class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        ArrayList[] bucket = new ArrayList[n + 1];
        for (int i = 0; i < bucket.length; ++i) {
            bucket[i] = new ArrayList<>();
        }
        for (int key : map.keySet()) {
            int val = map.get(key);
            List<Integer> list = bucket[val];
            list.add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && k > 0; --i) {
            res.addAll(bucket[i]);
            k -= bucket[i].size();
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}