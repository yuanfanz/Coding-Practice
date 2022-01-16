class Solution {
    public long mostPoints(int[][] questions) {
        Map<String, Long> map = new HashMap<>();
        return helper(questions, 0, questions.length - 1, map);
    }
    private long helper(int[][] questions, int start, int end, Map<String, Long> map) {
        if (start > end) {
            return 0;
        }
        String key = String.valueOf(start + "," + end);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        long cur = questions[start][0] + helper(questions, start + questions[start][1] + 1, end, map);
        long next = helper(questions, start + 1, end, map);
        long res = Math.max(cur, next);
        map.put(key, res);
        return res;
    }
}