class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        int val = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            val += i < 0 ? 0 : a.charAt(i--) - '0';
            val += j < 0 ? 0 : b.charAt(j--) - '0';
            
            sb.insert(0, val % 2);
            val /= 2;
        }
        if (val > 0) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}