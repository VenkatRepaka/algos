package strings.coursera.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BurrowsWheelerTransformation {

    private List<String> sortedRotations(String text) {
        String textRep = text + text;
        List<String> allRotations = new ArrayList<>();
        for(int i=0;i<text.length();i++) {
            allRotations.add(textRep.substring(i, i+text.length()));
        }
        return allRotations.stream().sorted().collect(Collectors.toList());
    }

    public String bwtTransformation(String text) {
        List<String> allSortedRotations = sortedRotations(text);
        List<Integer> lastCharacters = allSortedRotations.stream().map(item -> item.chars().reduce((first, second) -> second).orElse(-1)).collect(Collectors.toList());
        Optional<String> bwtTransformed = lastCharacters.stream().map(item -> Character.toString((char)item.intValue())).reduce((str1, str2) -> str1+str2);
        return bwtTransformed.get();

    }

    public static void main(String[] args) {
        BurrowsWheelerTransformation bwt = new BurrowsWheelerTransformation();
        System.out.println(bwt.bwtTransformation("AGACATA$"));
    }

}
