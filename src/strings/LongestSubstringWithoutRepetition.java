package strings;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestSubstringWithoutRepetition {

    public String findLongestSubstringWithoutRepetitionNaive(String input) {
        String longestStr = "";
        for(int i=0;i<input.length();i++) {
            for(int j=i;j<input.length();j++) {
                if(!isCharRepeated(input, i, j)) {
                    String tempLongestString = input.substring(i, j+1);
                    if(tempLongestString.length() > longestStr.length()) {
                        longestStr = tempLongestString;
                    }
                }
                else {
                    i = j;
                }
            }
        }
        return longestStr;
    }

    public boolean isCharRepeated(String input, int start, int end) {
        boolean[] flag = new boolean[256];
        while(start <= end) {
            if(!flag[input.charAt(start)]) {
                flag[input.charAt(start)] = true;
            }
            else {
                return true;
            }
            start++;
        }
        return false;
    }

    public String findLongestSubstringWithoutRepetition(String input) {
        List<Integer> charPos = IntStream.iterate(0, i -> i+1).limit(255).map(i -> -1).boxed().collect(Collectors.toList());
        int currLength = 0;
        int maxLength = 1;
        int startIndex = 0;
        int prevIndex = 0;
        String longestString = "";
        for(int i=0;i<input.length();i++) {
            prevIndex = charPos.get(input.charAt(i));
            if(prevIndex == -1 || prevIndex < startIndex) {
                currLength++;
            }
            else {
                if(currLength > maxLength) {
                    maxLength = currLength;
                    currLength = 1;
                    longestString = input.substring(startIndex, startIndex + maxLength);
                }
                startIndex = i;
            }
            charPos.set(input.charAt(i), i);
        }
        return longestString;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepetition longestSubstringWithoutRepetition = new LongestSubstringWithoutRepetition();
        // String longest = longestSubstringWithoutRepetition.findLongestSubstringWithoutRepetitionNaive("ABCDABDEFGCABD");
        String longest = longestSubstringWithoutRepetition.findLongestSubstringWithoutRepetition("ABCDABDEFGCABD");
        System.out.println(longest);
    }

}
