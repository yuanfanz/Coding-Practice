class Solution {
    public int minAreaRect(int[][] points) {
        // y is key, value is a list of x
        TreeMap<Long, List<Long>> map = new TreeMap<>();
        
        for (int[] cur : points) {
            long x = cur[0];
            long y = cur[1];
            List<Long> xlist = map.getOrDefault(y, new ArrayList<>());
            xlist.add(x);
            map.put(y, xlist);
        }
        
        long min = Long.MAX_VALUE;
        List<Long> keylist = new ArrayList<>(map.keySet());
        for (int i = 0; i < keylist.size() - 1; ++i) {
            
            List<Long> prev = map.get(keylist.get(i));
            
            for (int j = i + 1; j < keylist.size(); ++j) {
                Set<Long> cur = new HashSet<>(map.get(keylist.get(j)));
                long heightDiff = keylist.get(j) - keylist.get(i);

                Set<Long> common = new HashSet<>();
                for (long x : prev) {
                    if (cur.contains(x)) {
                        common.add(x);
                    }
                }
                
                List<Long> commonList = new ArrayList<>(common);
                Collections.sort(commonList);
                for (int k = 1; k < commonList.size(); ++k) {
                    min = Math.min(min, heightDiff * (commonList.get(k) - commonList.get(k - 1)));
                }
            }
        }
        return min == Long.MAX_VALUE ? 0 : (int)min;
    }
}

















