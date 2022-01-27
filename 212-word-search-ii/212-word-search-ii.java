class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        TrieNode root = new TrieNode();
        buildTrie(words, root);
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                dfs(result, new StringBuilder(), board, i, j, root, dirs);
            }
        }
        return new ArrayList<>(result);
    }
    private void dfs(Set<String> result, StringBuilder sb, char[][] board,
                    int i, int j, TrieNode cur, int[][] dirs) {
        if (cur.isWord) {
            result.add(sb.toString());
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        char ch = board[i][j];
        if (!cur.map.containsKey(ch)) {
            return;
        }
        int len = sb.length();
        board[i][j] = '#';
        sb.append(ch);
        for (int[] dir : dirs) {
            dfs(result, sb, board, i + dir[0], j + dir[1], cur.map.get(ch), dirs);
        }
        sb.setLength(len);
        board[i][j] = ch;
    }
    private void buildTrie(String[] words, TrieNode root) {
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