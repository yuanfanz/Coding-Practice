class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long ans = 0;
        if (k1 == 0 && k2 == 0) {
            for (int i = 0; i < nums1.length; i++) {
                ans += (long) (nums1[i] - nums2[i]) * (nums1[i] - nums2[i]);
            }
            return ans;
        }
        long max = 0;
        int sum = k1 + k2;  //总操作次数

        Map<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            long diff = (long) Math.abs(nums1[i] - nums2[i]);   //存计算差值
            max = Math.max(diff, max);  //维护最大值
            //存储差值
           if (map.containsKey(diff)) {     
               int num = map.get(diff);
               map.put(diff, num + 1);
           } else {
               map.put(diff, 1);
           }
        }

        while (sum > 0) {
            if (max == 0) break;    //由于最大值为0，整个差值平方和达到最小值0，直接结束即可


            int quan = map.get(max);    //获取当前最大值的个数
            //总数可以一次性减少quantity个，直接减去total，将原本的最大值删除，并将最大值减一的数量更新
            if (sum >= quan) {
                sum -= quan;
                map.remove(max);
                max--;
                map.put(max, map.getOrDefault(max, 0) + quan);
            } else {
                //总数无法一次性减少quantity个，则将最大值减少total个，将最大值减1的数量增加total个，并将total置零
                map.put(max, map.get(max) - sum);
                max--;
                map.put(max, map.getOrDefault(max, 0) + sum);
                sum = 0;
            }

        }
        //计算平方值之和
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            ans += entry.getKey()* entry.getKey() * entry.getValue();
        }
        return ans;
    }
}