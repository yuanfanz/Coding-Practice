class Solution {
    private TrieNode root;
    public int[][] indexPairs(String text, String[] words) {
        root = new TrieNode();
        buildTrie(words);
        
        int i = 0;
        List<List<Integer>> result = new ArrayList<>();
        while (i < text.length()) {
            if (root.map.containsKey(text.charAt(i))) {
                List<Integer> list = search(text, root, i);
                for (int end : list) {
                    result.add(new ArrayList<>(Arrays.asList(i, end)));
                }
            }
            i++;
        }
        int[][] res = new int[result.size()][2];
        int index = 0;
        for (List<Integer> list : result) {
            res[index][0] = list.get(0);
            res[index++][1] = list.get(1);
        }
        return res;
    }
    
    private List<Integer> search(String text, TrieNode cur, int index) {
        List<Integer> list = new ArrayList<>();
        for (int i = index; i < text.length(); ++i) {
            char ch = text.charAt(i);
            if (!cur.map.containsKey(ch)) {
                break;
            }
            cur = cur.map.get(ch);
            if (cur.isWord) {
                list.add(i);
            }
        }
        return list;
    }
    
    private void buildTrie(String[] words) {
        for (String word : words) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                if (!cur.map.containsKey(ch)) {
                    cur.map.put(ch, new TrieNode(ch));
                }
                cur = cur.map.get(ch);
                if (i == word.length() - 1) {
                    cur.isWord = true;
                }
            }
        }
    }
    
    class TrieNode{
        char ch;
        Map<Character, TrieNode> map;
        boolean isWord;
        public TrieNode() {
            map = new HashMap<>();
            isWord = false;
        }
        public TrieNode(char ch) {
            this.ch = ch;
            map = new HashMap<>();
            isWord = false;
        }
    }

    
}