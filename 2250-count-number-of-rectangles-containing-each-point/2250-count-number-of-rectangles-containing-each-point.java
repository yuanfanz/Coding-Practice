class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        // key is y(height), value is a list of x
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        
        int maxY = Integer.MIN_VALUE;
        for (int[] cur : rectangles) {
            int x = cur[0];
            int y = cur[1];
            List<Integer> xlist = map.getOrDefault(y, new ArrayList<>());
            xlist.add(x);
            map.put(y, xlist);
            maxY = Math.max(maxY, y);
        }
        
        for (int key : map.keySet()) {
            List<Integer> xlist = map.get(key);
            Collections.sort(xlist);
            map.put(key, xlist);
        }
        
        int[] res = new int[points.length];
        for (int i = 0; i < points.length; ++i) {
            int x = points[i][0];
            int y = points[i][1];
            
            if (y > maxY) {
                continue;
            }
            
            int count = 0;
            Integer recY = map.ceilingKey(y);
            for (int next : map.subMap(recY, maxY + 1).keySet()) {
                List<Integer> xlist = map.get(next);
                int index = searchLeftBound(xlist, x);
                if (index != -1) {
                    count += (xlist.size() - index);
                }
            }
            res[i] = count;
        }
        return res;
    }
    
    private int searchLeftBound(List<Integer> list, int target) {
        int i = 0;
        int j = list.size() - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (list.get(mid) >= target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        if (i >= list.size()) return -1;
        return i;
    }
}


















