class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] total = new int[26];
        List<String> result = new ArrayList<>();
        for (String b : words2) {
            int[] cur = getHash(b);
            for (int i = 0; i < 26; ++i) {
                total[i] = Math.max(cur[i], total[i]);
            }
        }
        for (String a : words1) {
            int[] hasha = getHash(a);
            boolean flag = false;
            for (int i = 0; i < 26; ++i) {
                if (hasha[i] < total[i]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) result.add(a);
        }
        return result;
    }
    
    private int[] getHash(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            hash[s.charAt(i) - 'a']++;
        }
        return hash;
    }
}