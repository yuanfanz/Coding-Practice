class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                degree.put(ch, 0);
                map.put(ch, new ArrayList<>());
            }
        }
        for (int i = 1; i < words.length; ++i) {
            String first = words[i - 1];
            String second = words[i];
            if (first.length() > second.length() && first.startsWith(second)) {
                return "";
            }
            for (int j = 0; j < first.length(); ++j) {
                char ch1 = first.charAt(j);
                char ch2 = second.charAt(j);
                if (ch1 != ch2) {
                    List<Character> list = map.getOrDefault(ch1, new ArrayList<>());
                    list.add(ch2);
                    map.put(ch1, list);
                    degree.put(ch2, degree.get(ch2) + 1);
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (char key : degree.keySet()) {
            if (degree.get(key) == 0) {
                queue.offer(key);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (queue.size() != 0) {
            char ch = queue.poll();
            sb.append(ch);
            for (char next : map.get(ch)) {
                int val = degree.get(next) - 1;
                degree.put(next, val);
                if (val == 0) {
                    queue.offer(next);
                }
            }
        }
        if (sb.length() < degree.size()) {
            return "";
        }
        return sb.toString();
    }
}


















