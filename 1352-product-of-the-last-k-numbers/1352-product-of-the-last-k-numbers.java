class ProductOfNumbers {
    List<Integer> list;
    int last;
    int total;
    public ProductOfNumbers() {
        last = -1;
        list = new ArrayList<>();
        total = 0;
    }
    
    public void add(int num) {
        if (num == 0) {
            list.add(0);
            last = total;
            total++;
            return;
        }
        if (list.size() == 0) {
            list.add(num);
        } else {
            int prev = list.get(list.size() - 1);
            if (prev != 0) {
                list.add(prev * num);
            } else {
                list.add(num);
            }
        }
        total++;
    }
    
    public int getProduct(int k) {
        if (total - k - 1 > last) {
            // no zero in sub array
            return list.get(list.size() - 1) / list.get(total - k - 1);
        } else {
            if (total - k - 1 == last) return list.get(list.size() - 1);
            return 0;
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */