package strings;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        FirstNonRepeatingCharacter firstNonRepeatingCharacter = new FirstNonRepeatingCharacter();
        Character firstNonRep = firstNonRepeatingCharacter.getFirstNonRepeatingCharacterLinear("ADBCGHIEFKJLADTVDERFSWVGHQWCNOPENSMSJWIERTFB");
        System.out.println(firstNonRep);
        Character firstNonRepFromOptimal = firstNonRepeatingCharacter.getFirstNonRepeatingCharacterLinearOptimal("ADBCGHIEFKJLADTVDERFSWVGHQWCNOPENSMSJWIERTFB");
        System.out.println(firstNonRepFromOptimal);
    }

    public Character getFirstNonRepeatingCharacterLinear(String input) {
        List<Integer> charFrequency = IntStream.iterate(0, i -> i++).map(i -> 0).limit(256).boxed().collect(Collectors.toList());
        for(int i=0;i<input.length();i++) {
            charFrequency.set(input.charAt(i), charFrequency.get(input.charAt(i))+1);
        }
        for(int i=0;i<input.length();i++) {
            if(charFrequency.get(input.charAt(i)) == 1) {
                return input.charAt(i);
            }
        }
        return null;
    }

    public Character getFirstNonRepeatingCharacterLinearOptimal(String input) {
        List<Integer> charFrequency = IntStream.iterate(0, i -> i++).map(i -> -1).limit(256).boxed().collect(Collectors.toList());
        for(int i=0;i<input.length();i++) {
            if(charFrequency.get(input.charAt(i)) == -1) {
                charFrequency.set(input.charAt(i), i);
            }
            else {
                charFrequency.set(input.charAt(i), -2);
            }
        }
        Optional<Integer> index = charFrequency.stream().filter(i -> i>=0).sorted().findFirst();
        if(index.isPresent()) {
            return input.charAt(index.get());
        }
        else {
            return null;
        }
    }

}
