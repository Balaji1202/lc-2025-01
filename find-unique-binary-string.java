// https://leetcode.com/problems/find-unique-binary-string/

class Solution {
    int length;
    Set<String> uniqueNums = new HashSet();
    
    private String createBinaryString(String current) {
        if (current.length() == length) {
            if (!uniqueNums.contains(current)) {
                return current;
            }
            return "";
        }
        
        String zeroOption = createBinaryString(current + "0");
        if (zeroOption.length() > 0) {
            return zeroOption;
        }
        
        return createBinaryString(current + "1");
    }
    
    public String findDifferentBinaryString(String[] input) {
        length = input.length;
        for (String str : input) {
            uniqueNums.add(str);
        }
        
        return createBinaryString("");
    }
}
