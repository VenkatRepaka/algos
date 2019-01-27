package strings.coursera.week2;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class BWTMatching {

    char[] firstColumn, lastColumn;
    int[] lastToFirst;
    Map<Character, List<Integer>> lastColumnPositions = new HashMap<>();
    Map<Character, List<Integer>> firstColumnPositions = new HashMap<>();

    public BWTMatching(String text) {
        lastColumn = text.toCharArray();
        firstColumn = text.toCharArray();
        lastToFirst = new int[text.length()];
        Arrays.sort(firstColumn);
        for(int i=0;i<text.length();i++) {
            System.out.print(firstColumn[i] + " - ");
            System.out.println(lastColumn[i]);
        }

        for(int i=0;i<text.length();i++) {
            lastColumnPositions.putIfAbsent(lastColumn[i], new ArrayList<>());
            lastColumnPositions.get(lastColumn[i]).add(i);
        }
        for(int i=0;i<text.length();i++) {
            firstColumnPositions.putIfAbsent(firstColumn[i], new ArrayList<>());
            firstColumnPositions.get(firstColumn[i]).add(i);
        }
        for(Map.Entry<Character, List<Integer>> entry: lastColumnPositions.entrySet()) {
            for(int i=0;i<entry.getValue().size();i++) {
                lastToFirst[entry.getValue().get(i)] = firstColumnPositions.get(entry.getKey()).get(i);
            }
        }
    }

    public int findMatches(String pattern) {
        return bwtMatching(pattern, lastToFirst);
    }

    private int bwtMatching(String pattern, int[] lastToFirst) {
        AtomicInteger top = new AtomicInteger(0);
        AtomicInteger bottom = new AtomicInteger(lastToFirst.length-1);
        int topIndex, bottomIndex;
        char symbol;
        List<Integer> indices = null;
        while(top.get() < bottom.get()) {
            if(pattern.length() > 0) {
                symbol = pattern.charAt(pattern.length()-1);
                pattern = pattern.substring(0, pattern.length()-1);
                if(lastColumnPositions.containsKey(symbol)) {
                    indices = lastColumnPositions.get(symbol);
                    indices = indices.stream().filter(item -> item >= top.get() && item <= bottom.get()).collect(Collectors.toList());
                    if(indices.size() > 0) {
                        topIndex = indices.get(0);
                        bottomIndex = indices.get(indices.size() - 1);
                        top.set(lastToFirst[topIndex]);
                        bottom.set(lastToFirst[bottomIndex]);
                    }
                    else {
                        return 0;
                    }
                }
                else return 0;
            }
            else {
                return bottom.get() - top.get() + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        BWTMatching bwtMatching = new BWTMatching("AT$TCTATG");
        System.out.println(bwtMatching.findMatches("TATG"));
    }

}
