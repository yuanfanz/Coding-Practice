
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (List<Interval> list : schedule) {
            for (Interval cur : list) {
                map.put(cur.start, map.getOrDefault(cur.start, 0) + 1);
                map.put(cur.end, map.getOrDefault(cur.end, 0) - 1);
            }
        }
        int start = -1;
        int sum = 0;
        for (int key : map.keySet()) {
            sum += map.get(key);
            if (sum == 0) {
                if (start == -1) {
                    start = key;
                }
            } else {
                if (start != -1) {
                    int end = key;
                    result.add(new Interval(start, end));
                    start = -1;
                }
            }
        }
        return result;
    }
}