class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List[] bucket = new ArrayList[nums.length + 1];
        for (int key : map.keySet()) {
            int val = map.get(key);
            if (bucket[val] == null) {
                bucket[val] = new ArrayList<>();
            }
            bucket[val].add(key);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length; i >= 0 && k > 0; --i){
            if (bucket[i] != null) {
                list.addAll(bucket[i]);
                k -= bucket[i].size();
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}