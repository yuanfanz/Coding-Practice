class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums1.length; ++i) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; ++i) {
            if (map.containsKey(nums2[i])) {
                int val = map.get(nums2[i]);
                if (val > 0) {
                list.add(nums2[i]);
                }
                val--;
                map.put(nums2[i], val);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}