package strings;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AllPermutationsString {

    public void getAllPermutations(char[] input, char[] output, int[] counts, int depth) {
        if(depth >= output.length) {
            System.out.println(new String(output));
            return;
        }
        for(int i=0;i<counts.length;i++) {
            if(counts[i] == 0) {
                continue;
            }
            counts[i] = counts[i] - 1;
            output[depth] = input[i];
            getAllPermutations(input, output, counts, depth+1);
            counts[i] = counts[i] + 1;
        }
    }

    public Set<String> getAllPermutations(String input) {
        Map<String, Long> counts =  Arrays.stream(input.split("")).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        char[] distinctChars = new char[counts.size()];
        int[] distinctCharCounts = new int[counts.size()];
        Integer index = 0;
        for(Map.Entry<String, Long> entry: counts.entrySet()) {
            distinctChars[index] = entry.getKey().charAt(0);
            distinctCharCounts[index] = entry.getValue().intValue();
            index++;
        }
        getAllPermutations(distinctChars, new char[input.length()], distinctCharCounts, 0);
        return null;
    }

    public static void main(String[] args) {
        AllPermutationsString allPermutationsString = new AllPermutationsString();
        Set<String> permutations = allPermutationsString.getAllPermutations("aabc");
    }

}
