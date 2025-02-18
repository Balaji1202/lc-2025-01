// https://leetcode.com/problems/construct-smallest-number-from-di-string/

class Solution {

    private boolean isValidPattern(String seq, String pat) {
        for (int i = 0; i < pat.length(); i++) {
            if (pat.charAt(i) == 'I') {
                if (seq.charAt(i) > seq.charAt(i + 1)) {
                    return false;
                }
            } else {
                if (seq.charAt(i) < seq.charAt(i + 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public String smallestNumber(String pat) {
        int len = pat.length();
        char[] arr = new char[len + 1];

        for (int i = 0; i <= len; i++) {
            arr[i] = (char) ('1' + i);
        }

        while (!isValidPattern(new String(arr), pat)) {
            if (!generateNextPermutation(arr)) {
                break;
            }
        }

        return new String(arr);
    }

    private boolean generateNextPermutation(char[] arr) {
        int idx = arr.length - 2;

        while (idx >= 0 && arr[idx] >= arr[idx + 1]) {
            idx--;
        }
        if (idx == -1) return false;

        int swapIdx = arr.length - 1;
        while (arr[swapIdx] <= arr[idx]) {
            swapIdx--;
        }
        swap(arr, idx, swapIdx);

        reverse(arr, idx + 1, arr.length - 1);
        return true;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
