class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        
        if (arr1.length > arr2.length) {
            return -compareVersion(version2, version1);
        }
        for (int i = 0; i < arr1.length; ++i) {
            if (compare(arr1[i], arr2[i]) == 0) {
                continue; 
            }
            return compare(arr1[i], arr2[i]);
        }
        if (arr2.length > arr1.length) {
            for (int i = arr1.length; i < arr2.length; ++i) {
                if (Integer.valueOf(arr2[i]) == 0) {
                    continue;
                }
                return -1;
            }
        }
        return 0;
    }
    private int compare(String s1, String s2) {
        if (Integer.valueOf(s1) < Integer.valueOf(s2)) {
            return -1;
        } else if (Integer.valueOf(s1) > Integer.valueOf(s2)) {
            return 1;
        } else {
            return 0;
        }
    }
}