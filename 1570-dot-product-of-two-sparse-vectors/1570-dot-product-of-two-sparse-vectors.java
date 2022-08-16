class SparseVector {
    List<Integer> list;
    int[] arr;
    SparseVector(int[] nums) {
        arr = new int[nums.length];
        list = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                arr[i] = nums[i];
                list.add(i);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        if (vec.list.size() > this.list.size()) {
            return vec.dotProduct(this);
        }
        List<Integer> indexList = this.list;
        int sum = 0;
        // print(indexList);
        // print(vec.list);
        for (int i = 0; i < indexList.size(); ++i) {
            int cur = indexList.get(i);
            int index = find(vec.list, cur);
            // System.out.println("cur: " + cur);
            // System.out.println("index: " + index);
            if (index == -1) continue;
            sum += vec.arr[cur] * this.arr[cur];
        }
        return sum;
    }
    
    private int find(List<Integer> list, int target) {
        int i = 0;
        int j = list.size() - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (list.get(mid) == target) {
                return target;
            } else if (list.get(mid) < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return -1;
    }
    
    private void print(List<Integer> list) {
        for (int i = 0; i < list.size(); ++i) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);












