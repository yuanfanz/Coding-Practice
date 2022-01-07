class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null) return 0;
        if (beginWord.length() != endWord.length()) return 0;
        if (!wordList.contains(endWord)) return 0;
        
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        
        startSet.add(beginWord);
        endSet.add(endWord);
        
        Set<String> wordDict = new HashSet<>(wordList);
        
        int step = 2;
        while (startSet.size() != 0) {
            Set<String> next = new HashSet<>();
            for (String s : startSet) {
                char[] arr = s.toCharArray();
                for (int i = 0; i < arr.length; ++i) {
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        arr[i] = ch;
                        String newWord = new String(arr);
                        if (endSet.contains(newWord)) {
                            return step;
                        }
                        if (wordDict.contains(newWord)) {
                            next.add(newWord);
                            wordDict.remove(newWord);
                        }
                    }
                    arr = s.toCharArray();
                }
            }
            step++;
            if (next.size() < endSet.size()) {
                startSet = next;
            } else {
                startSet = endSet;
                endSet = next;
            }
        }
        return 0;
    }
}