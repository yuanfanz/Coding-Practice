class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int i = 0;
        int j = removable.length;
        while (i < j) {
            int mid = i + (j - i + 1) / 2;
            String after = remove(s, Arrays.copyOfRange(removable, 0, mid));
            if (isSubsequence(p, after)) {
                i = mid;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
    
    private String remove(String s, int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (!set.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}