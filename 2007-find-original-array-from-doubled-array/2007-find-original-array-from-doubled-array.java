class Solution {
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < changed.length; ++i) {
            map.put(changed[i], map.getOrDefault(changed[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < changed.length; ++i) {
            int cur = changed[i];
            
            if (!map.containsKey(cur)) continue;
            if (map.containsKey(cur * 2)) {
                if (cur == cur * 2) {
                    int val = map.get(cur);
                    val -= 2;
                    if (val > 0) {
                        map.put(cur, val);
                    } else {
                        map.remove(cur);
                    }
                } else {
                    int val1 = map.get(cur);
                    int val2 = map.get(cur * 2);
                    val1--;
                    val2--;
                    if (val1 > 0) {
                        map.put(cur, val1);
                    } else {
                        map.remove(cur);
                    }
                    if (val2 > 0) {
                        map.put(cur * 2, val2);
                    } else {
                        map.remove(cur * 2);
                    }
                }
                list.add(cur);
            } else {
                return new int[0];
            }
        }
        if (list.size() != changed.length / 2) return new int[0];
        return list.stream().mapToInt(i -> i).toArray();
    }
}