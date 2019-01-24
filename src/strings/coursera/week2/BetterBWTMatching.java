package strings.coursera.week2;

import java.util.*;

public class BetterBWTMatching {

    private String bwtText;

    public BetterBWTMatching(String text) {
        this.bwtText = text;
    }

    public int bwtMatching(String pattern, Map<Character, Integer> starts, Map<Character, List<Integer>> occCountBefore) {
        int top = 0;
        int bottom = bwtText.length()-1;
        char character;
        int firstOccurence = 0;
        while(top <= bottom) {
            if(pattern.length() > 0) {
                character = pattern.charAt(pattern.length()-1);
                pattern = pattern.substring(0, pattern.length()-1);
                if(bwtText.substring(top, bottom+1).indexOf(character) != -1) {
                    firstOccurence = starts.get(character);
                    top = firstOccurence + occCountBefore.get(character).get(top);
                    bottom = firstOccurence + occCountBefore.get(character).get(bottom+1) - 1;
                }
                else {
                    return 0;
                }
            }
            else {
                return bottom - top + 1;
            }
        }
        return 0;
    }

    public AbstractMap.SimpleEntry<Map<Character, Integer>, Map<Character, List<Integer>>> mapFirstToLast() {
        Map<Character, Integer> starts = new HashMap<>();
        char[] bwtTextChars = this.bwtText.toCharArray();
        Arrays.sort(bwtTextChars);
        for(int i=0;i<bwtTextChars.length;i++) {
            starts.putIfAbsent(bwtTextChars[i], i);
        }
        System.out.println(starts);
        Map<Character, List<Integer>> occCountBefore = new HashMap<>();
        int counter = 0;
        List<Integer> list = null;
        for(char ch: bwtText.toCharArray()) {
            list = new ArrayList<>();
            list.add(0);
            counter = 0;
            for(int i=0;i<bwtText.length();i++) {
                if(bwtText.charAt(i) == ch){
                    counter += 1;
                }
                list.add(counter);
            }
            occCountBefore.putIfAbsent(ch, list);
        }
        System.out.println(occCountBefore);
        return new AbstractMap.SimpleEntry(starts, occCountBefore);
    }

    public int findMatches(String pattern) {
        char[] lastColumn = this.bwtText.toCharArray();
        char[] firstColumn = this.bwtText.toCharArray();
        Arrays.sort(firstColumn);
        AbstractMap.SimpleEntry<Map<Character, Integer>, Map<Character, List<Integer>>> entry = mapFirstToLast();
        return bwtMatching(pattern, entry.getKey(), entry.getValue());
    }

    public static void main(String[] args) {
        BetterBWTMatching bwtMatching = new BetterBWTMatching("AGGGAA$");
        System.out.println(bwtMatching.findMatches("GA"));
    }

}
