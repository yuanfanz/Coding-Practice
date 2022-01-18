class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Interval> stack = new Stack<>();
        int[] result = new int[n];
        for (String log : logs) {
            Interval cur = new Interval(log);
            if (cur.isStart) {
                stack.push(cur);
            } else {
                Interval prev = stack.pop();
                int duration = cur.time - prev.time + 1;
                result[cur.id] += duration;
                if (!stack.isEmpty()) {
                    Interval last = stack.peek();
                    result[last.id] -= duration;
                }
            }
        }
        return result;
    }
    class Interval{
        int id;
        int time;
        boolean isStart;
        public Interval(String log) {
            String[] strs = log.split(":");
            this.id = Integer.valueOf(strs[0]);
            this.time = Integer.valueOf(strs[2]);
            this.isStart = strs[1].equals("start");
        }
    }
}