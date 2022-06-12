class Solution {
    public int shortestWay(String source, String target) {
        Map<Character, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < source.length(); ++i) {
            char ch = source.charAt(i);
            List<Integer> list = map.getOrDefault(ch, new ArrayList<>());
            list.add(i);
            map.put(ch, list);
        }
        int res = 1;
        int cur = -1;
        for (int i = 0; i < target.length(); ++i) {
            char ch = target.charAt(i);
            // System.out.print(ch + " ");
            if (!map.containsKey(ch)) return -1;
            List<Integer> list = map.get(ch);
            int prev = cur;
            int index = search(list, cur);
            // System.out.print(index + " ");
            if (index == -1) {
                cur = list.get(0) + 1;
            } else {
                cur = list.get(index) + 1;
            }
            // System.out.print(cur + " ");
            // System.out.println(prev);
            if (prev >= cur) {
                res++;
            }
        }
        return res;
    }
    
    private int search(List<Integer> list, int target) {
        if (target == -1) return 0;
        int i = 0;
        int j = list.size() - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (list.get(mid) == target) {
                j = mid - 1;
            } else if (list.get(mid) > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        // if (j < 0) return -1;
        if (i >= list.size()) return -1;
        return i;
    }
}