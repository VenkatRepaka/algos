package strings.coursera.week3;

import java.util.ArrayList;
import java.util.List;

public class Kmp {

    public int[] prefixFunction(String text) {
        int[] prefixArr = new int[text.length()];
        int border = 0;
        for(int i=1;i<text.length();i++) {
            while (border > 0 && text.charAt(i) != text.charAt(border)) {
                border = prefixArr[border-1];
            }
            if(text.charAt(i) == text.charAt(border)) {
                border += 1;
            }
            else {
                border = 0;
            }
            prefixArr[i] = border;
        }
        return prefixArr;
    }

    public List<Integer> findPatternCount(String pattern, String text) {
        String patternAndText = pattern + "$" + text;
        int[] prefixArr = prefixFunction(patternAndText);
        List<Integer> result = new ArrayList<>();
        for(int i=pattern.length()+1;i<patternAndText.length();i++) {
            if(prefixArr[i] == pattern.length()) {
                result.add(i - 2 * pattern.length());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Kmp kmp = new Kmp();
        // kmp.prefixFunction("");
        List<Integer> result = kmp.findPatternCount("ATAT", "GATATATGCATATACTT");
        result.forEach(item -> System.out.print(item + " "));
    }

}
