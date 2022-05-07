class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> result = new ArrayList<>();
        if (finalSum % 2 == 1) {
            return result;
        }
        long tmp = finalSum;
        long cur = 2L;
        while (tmp >= cur) {
            result.add(cur);
            tmp -= cur;
            cur += 2;
        }
        if (tmp > 0) {
            tmp += result.get(result.size() - 1);
            result.remove(result.size() - 1);
            result.add(tmp);
        }
        return result;
    }
}