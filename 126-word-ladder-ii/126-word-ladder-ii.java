class Solution {
    private boolean isConnected = false;
    private Set<String> visitedDuringDFS = new HashSet<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        
        if (beginWord == null || endWord == null) return result;
        if (beginWord.length() != endWord.length()) return result;
        if (!wordList.contains(endWord)) return result;
        
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);
        
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        Map<String, List<String>> map = new HashMap<>();
        bfs(beginSet, endSet, wordSet, map, false);
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        dfs(beginWord, endWord, map, result, list, wordSet);
        return result;
    }
    private void dfs(String start, String end, Map<String, List<String>> map,
                    List<List<String>> result, List<String> list, Set<String> wordSet) {
        if (visitedDuringDFS.contains(start)) {
            return;
        }
        if (start.equals(end)) {
            result.add(new ArrayList<>(list));
            visitedDuringDFS = new HashSet<>();
            return;
        }
        if (!map.containsKey(start)) return;
        visitedDuringDFS.add(start);
        for (String next : map.get(start)) {
            list.add(next);
            dfs(next, end, map, result, list, wordSet);
            list.remove(list.size() - 1);
        }
    }
    private void bfs(Set<String> startSet, Set<String> endSet, Set<String> wordSet,
                    Map<String, List<String>> map, boolean swap) {
        wordSet.removeAll(startSet);
        wordSet.removeAll(endSet);
        while (startSet.size() != 0) {
            Set<String> next = new HashSet<>();
            for (String word : startSet) {
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; ++i) {
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        arr[i] = ch;
                        String newWord = String.valueOf(arr);
                        
                        String key = swap ? newWord : word;
                        String value = swap ? word : newWord;
                        
                        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
                        
                        if (endSet.contains(newWord)) {
                            map.get(key).add(value);
                            isConnected = true;
                        }
                        if (wordSet.contains(newWord)) {
                            map.get(key).add(value);
                            next.add(newWord);
                        }
                    }
                    arr = word.toCharArray();
                }
            }
            if (isConnected || next.size() == 0) return;
            if (endSet.size() < next.size()) {
                bfs(endSet, next, wordSet, map, !swap);
            } else {
                bfs(next, endSet, wordSet, map, swap);
            }
        }
    }
}