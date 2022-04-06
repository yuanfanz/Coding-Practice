class Solution {
    public boolean isStrobogrammatic(String num) {
        int i = 0;
        int j = num.length() - 1;
        while (i <= j) {
            if (num.charAt(i) == num.charAt(j)) {
                int cur = num.charAt(i) - '0';
                if (cur != 0 && cur != 1 && cur != 8) {
                    return false;
                }
            } else {
                int first = num.charAt(i) - '0';
                int second = num.charAt(j) - '0';
                if (first + second != 15) return false;
            }
            i++;
            j--;
        }
        return true;
    }
}