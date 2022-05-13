class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int k = intLength;
        k--;
        k /= 2;
        int total = 9;
        while (k > 0) {
            total *= 10;
            k--;
        }
        int n = queries.length;
        long[] res = new long[n];
        for (int i = 0; i < queries.length; ++i) {
            if (queries[i] > total) {
                res[i] = -1;
                continue;
            }
            res[i] = getPalin((long)Math.pow(10, (intLength - 1) / 2) + queries[i] - 1, intLength);
        }
        return res;
    }
    
    private long getPalin(long number, int length) {
        StringBuilder sb = new StringBuilder();
        sb.append(number);
        String res = "";
        if (length % 2 == 0) {
            String first = sb.toString();
            String half = sb.reverse().toString();
            res = first + half;
        } else {
            String mid = sb.charAt(sb.length() - 1) + "";
            sb.deleteCharAt(sb.length() - 1);
            String first = sb.toString();
            String tmp = sb.reverse().toString();
            // System.out.println("sb: " + sb.toString());
            // System.out.println("mid: " + mid);
            // System.out.println("tmp: " + tmp.toString());
            // System.out.println(sb.toString());
            res = first + mid + tmp;;
        }
        return Long.valueOf(res);
    }
}