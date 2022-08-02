class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        
        for (String word : dictionary) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                if (!cur.map.containsKey(ch)) {
                    cur.map.put(ch, new TrieNode(ch));
                }
                cur = cur.map.get(ch);
                if (i == word.length() - 1) {
                    cur.isWord = true;
                    cur.word = word;
                }
            }
        }
        String[] strs = sentence.split(" ");
        for (int i = 0; i < strs.length; ++i) {
            String word = strs[i];
            TrieNode cur = root;
            for (int j = 0; j < word.length(); ++j) {
                char ch = word.charAt(j);
                if (!cur.map.containsKey(ch)) {
                    break;
                }
                cur = cur.map.get(ch);
                if (cur.isWord) {
                    strs[i] = cur.word;
                    break;
                }
            }
        }
        return String.join(" ", strs);
    }
    class TrieNode{
        char ch;
        Map<Character, TrieNode> map;
        boolean isWord;
        String word;
        public TrieNode() {
            map = new HashMap<>();
            isWord = false;
        }
        public TrieNode(char ch) {
            this.ch = ch;
            map = new HashMap<>();
            isWord = false;
            word = "";
        }
    }
}