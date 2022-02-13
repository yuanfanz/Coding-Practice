class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        Map<Integer, Integer> map = new TreeMap<>();
        
        for (List<Interval> list : schedule) {
            for (Interval cur : list) {
                int start = cur.start;
                int end = cur.end;
                map.put(start, map.getOrDefault(start, 0) + 1);
                map.put(end, map.getOrDefault(end, 0) - 1);
            }
        }
        List<Interval> result = new ArrayList<>();
        int start = -1;
        int people = 0;
        for (int key : map.keySet()) {
            int val = map.get(key);
            people += val;
            if (people == 0 && start == -1) {
                start = key;
            } else if (start != -1 && people != 0) {
                // when people is not 0, means someone starts to 
                result.add(new Interval(start, key));
                start = -1;
            }
        }
        return result;
    }
}

/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/