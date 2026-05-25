class Solution {
    public String mergeAlternately(String word1, String word2) {
        int index = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Math.max(word1.length(), word2.length()); i ++) {
            if (index > word1.length() - 1) {
                sb.append(word2.charAt(index));
            }else if (index > word2.length() - 1){
                sb.append(word1.charAt(index));  
            }else {
                sb.append(word1.charAt(index));
                sb.append(word2.charAt(index));
            }
            index++;
        }

        return sb.toString();
    }
}