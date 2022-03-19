class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        if (text.length() == 0) return 0;
        char ch1 = pattern.charAt(0);
        char ch2 = pattern.charAt(1);
        
        int count = 0;
        if (ch1 == ch2) {
            for (int i = 0; i < text.length(); ++i) {
                if (ch1 == text.charAt(i)) {
                    count++;
                }
            }
            count += 1;
            long sum = 0;
            for (int i = 2; i <= count; ++i) {
                sum += (i - 1);
            }
            return sum;
        }
        
        int first = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < text.length(); ++i) {
            char ch = text.charAt(i);
            if (ch == ch1) {
                first++;
            } else if (ch == ch2) {
                list.add(first);
            }
        }
        long sum1 = 0;
        long sum2 = 0;
        if (first == 0 && list.size() == 0) {
            return 0;
        } else if (list.size() == 0) {
            return first;
        } else if (first == 0) {
            return list.size();
        } else {
            for (int i : list) {
                sum1 += (i + 1);
                sum2 += i;
            }
            return Math.max(sum1, sum2 + first);
        }
    }
}