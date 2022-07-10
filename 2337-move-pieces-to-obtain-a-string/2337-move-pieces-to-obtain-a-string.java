class Solution {
    public boolean canChange(String start, String target) {
        if (start.length() != target.length()) return false;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < start.length(); ++i) {
            if (start.charAt(i) != '_') {
                sb.append(start.charAt(i));
            }
        }
        String s1 = sb.toString();
        sb = new StringBuilder();
        for (int i = 0; i < target.length(); ++i) {
            if (target.charAt(i) != '_') {
                sb.append(target.charAt(i));
            }
        }
        String e1 = sb.toString();
        if (!s1.equals(e1)) return false;
        
        int i = 0;
        int j = 0;
        while (i < start.length() && j < target.length()) {
            while (i < start.length() && start.charAt(i) != 'L') {
                i++;
            }
            while (j < target.length() && target.charAt(j) != 'L') {
                j++;
            }
            if (i < j) return false;
            i++;
            j++;
        }
        i = 0;
        j = 0;
        while (i < start.length() && j < target.length()) {
            while (i < start.length() && start.charAt(i) != 'R') {
                i++;
            }
            while (j < target.length() && target.charAt(j) != 'R') {
                j++;
            }
            if (i > j) return false;
            i++;
            j++;
        }
        return true;
    }
}