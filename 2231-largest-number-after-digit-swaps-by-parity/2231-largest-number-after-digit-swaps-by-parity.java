class Solution {
    public int largestInteger(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        
        int n = arr.length;
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        
        for (int i = 0; i < arr.length; ++i) {
            if ((arr[i] - '0') % 2 == 0) {
                even.add(arr[i] - '0');
            } else {
                odd.add(arr[i] - '0');
            }
        }
        Collections.sort(odd);
        Collections.sort(even);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; ++i) {
            if ((arr[i] - '0') % 2 == 0) {
                sb.append(even.get(even.size() - 1) + "");
                even.remove(even.size() - 1);
            } else {
                sb.append(odd.get(odd.size() - 1) + "");
                odd.remove(odd.size() - 1);
            }
        }
        return Integer.valueOf(sb.toString());
    }
}