class Solution {
    public String nearestPalindromic(String n) {
        long selfNumber = Long.valueOf(n);
        long res = -1;
        
        List<Long> list = getNums(n);
        for (long num : list) {
            if (num != selfNumber) {
                if (res == -1 || 
                    Math.abs(num - selfNumber) < Math.abs(res - selfNumber) ||
                   Math.abs(num - selfNumber) == Math.abs(res - selfNumber) && num < res) {
                    res = num;
                }
            }
        }
        return String.valueOf(res);
    }
    
    private List<Long> getNums(String n) {
        int len = n.length();
        List<Long> list = new ArrayList<>();
        list.add((long) Math.pow(10, len - 1) - 1);
        list.add((long) Math.pow(10, len) + 1);
        
        long prefix = Long.valueOf(n.substring(0, (len + 1) / 2));
        for (long i = prefix - 1; i <= prefix + 1; ++i) {
            StringBuilder sb = new StringBuilder();
            String pre = String.valueOf(i);
            sb.append(pre);
            StringBuilder suffix = new StringBuilder(pre).reverse();
            sb.append(suffix.substring(len & 1));
            String num = sb.toString();
            list.add(Long.valueOf(num));
        }
        return list;
    }
}