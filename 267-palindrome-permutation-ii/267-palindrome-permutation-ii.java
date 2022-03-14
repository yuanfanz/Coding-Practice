class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<>();
        
        int[] hash = new int[26];
        boolean flag = false;
        String mid = "";
        int len = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            hash[ch - 'a']++;
            if (hash[i] * 2 > s.length() + 1) {
                return result;
            }
        }
        for (int i = 0; i < 26; ++i) {
            if (hash[i] % 2 == 1) {
                if (flag) return result;
                flag = true;
                mid = (char) (i + 'a') + "";
            }
            hash[i] /= 2;
            len += hash[i];
        }
        Set<String> set = new HashSet<>();
        dfs(set, new StringBuilder(), hash, len, mid);
        return new ArrayList<>(set);
    }
    private void dfs(Set<String> result, StringBuilder sb, int[] hash, int len, String mid) {
        if (sb.length() == len) {
            // System.out.println(len);
            // System.out.println(sb.toString());
            String prefix = sb.toString();
            String suffix = new StringBuilder(prefix).reverse().toString();
            result.add(prefix + mid + suffix);
            return;
        }
            int sbLen = sb.length();
        for (int i = 0; i < hash.length; ++i) {
            if (hash[i] > 0) {
                // System.out.println((char)(i + 'a') + "  " + hash[i]);
                hash[i]--;
                sb.append((char)(i + 'a'));
                // System.out.println("CUR: "+sb.toString());
                dfs(result, sb, hash, len, mid);
                sb.setLength(sbLen);
                // System.out.println("AFT: "+sb.toString());
                hash[i]++;
            }
        }
    }
}











