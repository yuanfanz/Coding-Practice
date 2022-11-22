class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num.charAt(0) - '0' == 0) return true;
        
        int i = 0;
        int j = num.length() - 1;
        while (i <= j) {
            if (i == j) {
                return num.charAt(i) - '0' == 1 || 
                    num.charAt(i) - '0' == 8 || num.charAt(i) - '0' == 0;
            }
            if (num.charAt(i) - '0' == 8) {
                if (num.charAt(j) - '0' != 8) return false;
            } else if (num.charAt(i) - '0' == 1) {
                if (num.charAt(j) - '0' != 1) return false;
            } else if (num.charAt(i) - '0' == 6) {
                if (num.charAt(j) - '0' != 9) return false;
            } else if (num.charAt(i) - '0' == 9) {
                if (num.charAt(j) - '0' != 6) return false;
            } else if (num.charAt(i) - '0' == 0) {
                if (num.charAt(j) - '0' != 0) return false;
            } else {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}