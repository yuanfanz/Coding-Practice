class Solution {
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length();
        
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder mid = new StringBuilder();
        
        if (len % 2 == 1) {
            sb1.append(palindrome.substring(0, len / 2));
            sb2.append(palindrome.substring(len / 2 + 1));
            mid.append(palindrome.substring(len / 2, len / 2 + 1));
        } else {
            sb1.append(palindrome.substring(0, len / 2));
            sb2.append(palindrome.substring(len / 2));
        }
        char[] arr1 = sb1.toString().toCharArray();
        char[] arr2 = sb2.toString().toCharArray();
        char[] midarr = mid.toString().toCharArray();
        
        // System.out.println(String.valueOf(arr1));
        // System.out.println(String.valueOf(arr2));
        // System.out.println(String.valueOf(midarr));
        
        boolean flag = false;
        for (int i = 0; i < arr1.length; ++i) {
            if (arr1[i] != 'a') {
                arr1[i] = 'a';
                flag = true;
                break;
            }
        }
        if (flag) {
            return String.valueOf(arr1) + String.valueOf(midarr) + String.valueOf(arr2);
        }
        for (int i = 0; i < arr2.length; ++i) {
            if (arr2[i] != 'a') {
                arr2[i] = 'a';
                flag = true;
                break;
            }
        }
        if (flag) {
            return String.valueOf(arr1) + String.valueOf(midarr) + String.valueOf(arr2);
        }
        for (int i = arr2.length - 1; i >= 0; --i) {
            if (arr2[i] != 'z') {
                arr2[i] = (char)(arr2[i] + 1);
                flag = true;
                break;
            }
        }
        if (flag) {
            return String.valueOf(arr1) + String.valueOf(midarr) + String.valueOf(arr2);
        }
        return "";
    }
}