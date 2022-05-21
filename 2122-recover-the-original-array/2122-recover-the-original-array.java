class Solution {
    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        
        int smallest = nums[0];
        
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            int diff = Math.abs(i - smallest);
            if (diff % 2 == 0 && diff > 0) set.add(diff / 2);
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // print(map);
        for (int k : set) {
            List<Integer> res = new ArrayList<>();
            // System.out.println("k: " + k);
            Map<Integer, Integer> curMap = new HashMap<>(map);
            int index = 0;
            for (int j = 0; j < nums.length; ++j) {
                int cur = nums[j];
                if (curMap.get(cur) == 0) continue;
                int next = cur + k * 2;
                if (!curMap.containsKey(next) || curMap.get(next) == 0) continue;
                curMap.put(cur, curMap.get(cur) - 1);
                curMap.put(next, curMap.get(next) - 1);
                
                // System.out.println(cur);
                // System.out.println(next);
                
                res.add(cur + k);
                if (res.size() == nums.length / 2) {
                    return res.stream().mapToInt(i -> i).toArray();
                }
                // print(res);
            }
            // System.out.println();
        }
        return new int[0];
    }
    
    private void print(int[] grid) {
    for (int i = 0; i < grid.length; ++i) {
        System.out.print(grid[i] + " ");
    }
    System.out.println();
}
}
















