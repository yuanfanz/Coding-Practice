/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        if (wordlist == null || wordlist.length == 0) return;
        
        List<String> list = new ArrayList<>(Arrays.asList(wordlist));
        for (int i = 0; i < 10; ++i) {
            if (list.size() == 0) break;
            Random random = new Random();
            int index = random.nextInt(list.size());
            String cur = list.get(index);
            
            int num = master.guess(cur);
            List<String> nextList = new ArrayList<>();
            for (String s : list) {
                if (s.equals(cur)) continue;
                if (isMatch(s, cur) == num) {
                    nextList.add(s);
                }
            }
            list = nextList;
        }
    }
    
    private int isMatch(String s1, String s2) {
        if (s1.length() != s2.length()) return 0;
        int res = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) == s2.charAt(i)) {
                res++;
            }
        }
        return res;
    }
}