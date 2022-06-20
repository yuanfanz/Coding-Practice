class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>();
        for (String s : words) {
            set.add(s);
        }
        int total = 0;
        int count = 0;
        for (String s : set) {
            total += s.length();
            count++;
        }
        // System.out.println(total);
        // System.out.println(count);
        List<String> list = new ArrayList<>(set);
        Set<String> used = new HashSet<>();
        for (int i = 0; i < list.size(); ++i) {
            for (int j = 0; j < list.size(); ++j) {
                if (i == j) continue;
                String first = list.get(i);
                String second = list.get(j);
                // System.out.println(first);
                // System.out.println(second);
                if (first.endsWith(second) && !used.contains(second)) {
                    // System.out.println("******");
                    used.add(second);
                    total -= second.length();
                    count--;
                }
            }
        }
        // System.out.println(total);
        // System.out.println(count);
        return total + count;
    }
}