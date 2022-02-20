class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int max = 0;
        int count = 0;
        for (int j = 0; j < fruits.length; ++j) {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            count++;
            while (i < fruits.length && map.size() > 2) {
                int freq = map.get(fruits[i]);
                freq--;
                count--;
                if (freq == 0) {
                    map.remove(fruits[i]);
                } else {
                    map.put(fruits[i], freq);
                }
                i++;
            }
            if (map.size() <= 2) {
                max = Math.max(max, count);
            }
        }
        return max;
    }
}


// for (int i = 0; i < fruits.length; ++i) {
//             while (j < fruits.length && map.size() <= 2) {
//                 map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
//                 j++;
//                 count++;
//             }
//             // if (map.size() == 2) {
//                 max = Math.max(max, count);
//             // }
//             if (map.containsKey(fruits[i])) {
//                 int freq = map.get(fruits[i]);
//                 freq--;
//                 count--;
//                 if (freq > 0) {
//                     map.put(fruits[i], freq);
//                 }
//             }
//         }