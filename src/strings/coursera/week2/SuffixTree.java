package strings.coursera.week2;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SuffixTree {

    public void buildSuffixTree(String text) {
        List<AbstractMap.SimpleEntry<Integer, String>> suffixes = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<text.length();i++) {
            suffixes.add(new AbstractMap.SimpleEntry(i, text.substring(i)));
        }
        suffixes.sort(Comparator.comparing(AbstractMap.SimpleEntry::getValue));
        suffixes.forEach(System.out::println);
        suffixes.forEach(item -> result.add(item.getKey()));
        result.forEach(idx -> System.out.print(idx + " "));
    }

    public static void main(String[] args) {
        SuffixTree suffixTree = new SuffixTree();
        suffixTree.buildSuffixTree("AACGATAGCGGTAGA$");
    }

}
