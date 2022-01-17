class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int val = 0;
        
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            val += i >= 0 ? num1.charAt(i--) - '0' : 0;
            val += j >= 0 ? num2.charAt(j--) - '0' : 0;
            sb.insert(0, val % 10);
            val /= 10;
        }
        if (val != 0) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}