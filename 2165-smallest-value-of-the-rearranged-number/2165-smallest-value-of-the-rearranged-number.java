class Solution {
    public long smallestNumber(long num) {
        String str = String.valueOf(num);
        boolean neg = false;
        if (str.charAt(0) == '-') {
            neg = true;
            num = -num;
        }
        List<Long> old = new ArrayList<>();
        boolean zero = false;
        while (num != 0) {
            if (num % 10 == 0) {
                zero = true;
            }
            old.add(num % 10);
            num /= 10;
        }
        Collections.sort(old);
        if (neg) {
            Collections.sort(old, Collections.reverseOrder());
        }
        long sum = 0;
        boolean firstNonZero = false;
        List<Long> list = new ArrayList<>();
        if (zero) {
            for (long i : old) {
                if (i != 0) {
                    if (!firstNonZero) {
                        firstNonZero = true;
                        sum += i;
                        continue;
                    }
                    list.add(i);
                } else {
                    list.add(i);
                }
            }
        } else {
            list = old;
        }
        for (long i : list) {
            sum = sum * 10 + i;
        }
        return neg ? -sum : sum;
    }
}