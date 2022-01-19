class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        Set<String> wordSet = new HashSet<>(wordList);
        
        int step = 2;
        while (beginSet.size() != 0) {
            Set<String> next = new HashSet<>();
            for (String word : beginSet) {
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; ++i) {
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        arr[i] = ch;
                        String newWord = String.valueOf(arr);
                        if (endSet.contains(newWord)) {
                            return step;
                        }
                        if (wordSet.contains(newWord)) {
                            next.add(newWord);
                            wordSet.remove(newWord);
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