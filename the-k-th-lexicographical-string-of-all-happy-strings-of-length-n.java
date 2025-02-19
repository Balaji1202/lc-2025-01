// https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/

class Solution {

    List<String> generatedStrings = new ArrayList<>();

    public String getHappyString(int length, int index) {
        String str = "";
        generateStrings(length, str);

        if (generatedStrings.size() < index) return "";

        Collections.sort(generatedStrings);

        return generatedStrings.get(index - 1);
    }

    protected void generateStrings(int length, String str) {
        if (str.length() == length) {
            generatedStrings.add(str);
            return;
        }

        for (char ch = 'a'; ch <= 'c'; ch++) {
            if (str.length() > 0 && str.charAt(str.length() - 1) == ch) continue;

            generateStrings(length, str + ch);
        }
    }
}
