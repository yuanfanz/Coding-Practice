class Solution {
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) return false;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < start.length(); ++i) {
            if (start.charAt(i) != 'X') {
                sb.append(start.charAt(i));
            }
        }
        String s1 = sb.toString();
        sb = new StringBuilder();
        for (int i = 0; i < end.length(); ++i) {
            if (end.charAt(i) != 'X') {
                sb.append(end.charAt(i));
            }
        }
        String e1 = sb.toString();
        if (!s1.equals(e1)) return false;
        
        int i = 0;
        int j = 0;
        while (i < start.length() && j < end.length()) {
            while (i < start.length() && start.charAt(i) != 'L') {
                i++;
            }
            while (j < end.length() && end.charAt(j) != 'L') {
                j++;
            }
            if (i < j) return false;
            i++;
            j++;
        }
        i = 0;
        j = 0;
        while (i < start.length() && j < end.length()) {
            while (i < start.length() && start.charAt(i) != 'R') {
                i++;
            }
            while (j < end.length() && end.charAt(j) != 'R') {
                j++;
            }
            if (i > j) return false;
            i++;
            j++;
        }
        return true;
    }
}






















