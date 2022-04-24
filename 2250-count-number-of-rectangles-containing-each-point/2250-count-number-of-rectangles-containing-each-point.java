class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        TreeMap<Integer, List<Integer>> xmap = new TreeMap<>();
        
        int maxY = Integer.MIN_VALUE;
        for (int[] cur : rectangles) {
            int x = cur[0];
            int y = cur[1];
            List<Integer> list = xmap.getOrDefault(y, new ArrayList<>());
            list.add(x);
            xmap.put(y, list);
            maxY = Math.max(maxY, y);
        }
        
        int n = points.length;
        int[] res = new int[n];
        for (int key : xmap.keySet()) {
            List<Integer> list = xmap.get(key);
            Collections.sort(list);
            xmap.put(key, list);
        }
        for (int i = 0; i < n; ++i) {
            int count = 0;
            int[] cur = points[i];
            int x = cur[0];
            int y = cur[1];
            
            if (y > maxY) {
                continue;
            }
            
            Integer recY = xmap.ceilingKey(y);
            if (recY == null) {
                res[i] = 0;
                continue;
            }
            // larger rectangles
            for (int next : xmap.subMap(recY, maxY + 1).keySet()) {
                List<Integer> list = xmap.get(next);
                int index = search(list, x);
                if (index != -1) {
                    count += list.size() - index;
                }
            }
            res[i] = count;
        }
        return res;
    }
    
    private int search(List<Integer> nums, int target) {
        int i = 0;
        int j = nums.size() - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums.get(mid) >= target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        if (i >= nums.size() || nums.get(i) < target) {
            return -1;
        }
        return i;
    }
}