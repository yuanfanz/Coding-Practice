class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        
        int[] pos = new int[m + n];
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                int res = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                res += pos[i + j + 1];
                pos[i + j] += res / 10;
                pos[i + j + 1] = res % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (p == 0 && sb.length() == 0) {
                continue;
            }
            sb.append(p);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}