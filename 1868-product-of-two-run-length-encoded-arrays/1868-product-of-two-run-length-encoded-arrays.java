class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        int len1 = encoded1.length;
        int len2 = encoded2.length;
        while (i < len1 || j < len2) {
            // System.out.print(i + " ");
            // System.out.println(j);
            int freq1 = encoded1[i][1];
            int freq2 = encoded2[j][1];
            int minFreq = Math.min(freq1, freq2);
            int product = encoded1[i][0] * encoded2[j][0];
            List<Integer> list = new ArrayList<>(Arrays.asList(product, minFreq));
            result.add(list);
            if (freq1 == freq2) {
                i++;
                j++;
            } else if (freq1 > freq2) {
                freq1 -= freq2;
                encoded1[i][1] = freq1;
                j++;
            } else {
                freq2 -= freq1;
                encoded2[j][1] = freq2;
                i++;
            }
        }
        i = 0;
        List<List<Integer>> total = new ArrayList<>();
        while (i < result.size()) {
            List<Integer> list = result.get(i);
            int cur = list.get(0);
            int freq = list.get(1);
            while (i + 1 < result.size() && result.get(i + 1).get(0) == cur) {
                freq += result.get(i + 1).get(1);
                i++;
            }
            List<Integer> newList = new ArrayList<>();
            newList.add(cur);
            newList.add(freq);
            total.add(newList);
            i++;
        }
        return total;
    }
}