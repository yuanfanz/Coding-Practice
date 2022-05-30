class Solution {
    int max = 0;
    Set<Integer> set;
    public int maxLength(List<String> arr) {
        int n = arr.size();
        int[] values = new int[n];
        set = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            String s = arr.get(i);
            if (!isUnique(s)) {
                set.add(i);
                continue;
            }
            int num = 0;
            for (int j = 0; j < s.length(); ++j) {
                num = num | 1 << (s.charAt(j) - 'a');
            }
            values[i] = num;
        }
        
        for (int i = 0; i < arr.size(); ++i) {
            dfs(arr, values, i, "");
        }
        return max;
    }
    private void dfs(List<String> arr, int[] values, int index, String cur) {
        max = Math.max(max, cur.length());
        // if (index == arr.size()) return;
        // System.out.println(cur);
        
        int num = 0;
        for (int i = 0; i < cur.length(); ++i) {
            num = num | 1 << (cur.charAt(i) - 'a');
        }
        
        for (int i = index; i < arr.size(); ++i) {
            int nextValue = values[i];
            // System.out.println("     " + arr.get(i));
            // if (cur.equals("act") && arr.get(i).equals("ers")) {
            //     System.out.println("num: " + Integer.toBinaryString(num));
            //     System.out.println("nextValue: " + Integer.toBinaryString(nextValue));
            //     System.out.println("&: " + (nextValue & num));
            // }
            if (set.contains(i)) continue;
            if ((nextValue & num) == 0) {
                dfs(arr, values, i + 1, cur + arr.get(i));
            }
        }
    }
    
    private boolean isUnique(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            hash[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; ++i) {
            if (hash[i] > 1) return false;
        }
        return true;
    }

}







