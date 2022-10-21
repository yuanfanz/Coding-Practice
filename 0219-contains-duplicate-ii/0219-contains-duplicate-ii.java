class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // for (int i = 0; i < nums.length; ++i) {
        //     // System.out.println("i: " + i);
        //     for (int j = i - k; j <= i + k && j < nums.length; ++j) {
        //         // System.out.println("j: " + j);
        //         if (i == j || j < 0) continue;
        //         if (nums[i] == nums[j]) return true;
        //     }
        // }
        // return false;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            List<Integer> list = map.getOrDefault(num, new ArrayList<>());
            list.add(i);
            map.put(num, list);
        }
        for (int key : map.keySet()) {
            if (map.get(key).size() < 2) continue;
            List<Integer> list = map.get(key);
            Collections.sort(list);
            for (int i = 1; i < list.size(); ++i) {
                if (list.get(i) - list.get(i - 1) <= k) return true;
            }
        }
        return false;
    }
}