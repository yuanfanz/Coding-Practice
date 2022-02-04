class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        int step = 2;
        while (beginSet.size() != 0) {
            Set<String> next = new HashSet<>();
            for (String word : beginSet) {
                for (int i = 0; i < word.length(); ++i) {
                char[] arr = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        arr[i] = ch;
                        String newWord = String.valueOf(arr);
                        if (endSet.contains(newWord)) {
                            return step;
                        }
                        if (wordSet.contains(newWord)) {
                            wordSet.remove(newWord);
                            next.add(newWord);
                        }
                    }
                    arr = word.toCharArray();
                }
            }
            step++;
            if (endSet.size() < next.size()) {
                beginSet = endSet;
                endSet = next;
            } else {
                beginSet = next;
            }
        }
        return 0;
    }
}