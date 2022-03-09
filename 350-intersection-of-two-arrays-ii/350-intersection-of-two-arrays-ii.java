class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (map.containsKey(i)) {
                list.add(i);
                int count = map.get(i);
                map.remove(i);
                count--;
                if (count > 0) {
                    map.put(i, count);
                }
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}