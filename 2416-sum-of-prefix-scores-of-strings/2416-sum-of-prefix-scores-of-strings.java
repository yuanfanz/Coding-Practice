class Solution {
    public int[] sumPrefixScores(String[] words) {
        int n = words.length;
        int[] res = new int[n];

        TrieNode root = new TrieNode();
        
        for (String word : words) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                if (!cur.map.containsKey(ch)) {
                    cur.map.put(ch, new TrieNode(ch));
                }
                cur = cur.map.get(ch);
                cur.count++;
                if (i == word.length() - 1) {
                    cur.isWord = true;
                }
            }
        }
        
        int index = 0;
        for (String word : words) {
            TrieNode cur = root;
            int sum = 0;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                cur = cur.map.get(ch);
                sum += cur.count;
            }
            res[index++] = sum;
        }
        return res;
    }
    
    class TrieNode {
        Character ch;
        Map<Character, TrieNode> map;
        boolean isWord;
        int count;
        public TrieNode() {
            ch = null;
            map = new HashMap<>();
            isWord = false;
            count = 0;
        }
        public TrieNode(char ch) {
            this.ch = ch;
            map = new HashMap<>();
            isWord = false;
            count = 0;
        }
    }
}