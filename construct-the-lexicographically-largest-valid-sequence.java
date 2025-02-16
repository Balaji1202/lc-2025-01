// https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/

public class Solution {

    public int[] constructDistancedSequence(int n) {
        int[] seq = new int[n * 2 - 1];
        boolean[] used = new boolean[n + 1];
        buildSequence(0, seq, used, n);
        return seq;
    }

    private boolean buildSequence(int index, int[] seq, boolean[] used, int n) {
        if (index == seq.length) {
            return true;
        }

        if (seq[index] != 0) {
            return buildSequence(index + 1, seq, used, n);
        }

        for (int i = n; i >= 1; i--) {
            if (used[i]) continue;

            used[i] = true;
            seq[index] = i;

            if (i == 1) {
                if (buildSequence(index + 1, seq, used, n)) {
                    return true;
                }
            } else if (index + i < seq.length && seq[index + i] == 0) {
                seq[index + i] = i;

                if (buildSequence(index + 1, seq, used, n)) {
                    return true;
                }

                seq[index + i] = 0;
            }

            seq[index] = 0;
            used[i] = false;
        }

        return false;
    }
}
