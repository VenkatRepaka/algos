package strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AllPermutationsString {

    private Set<String> permutations = new HashSet<>();

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
        // allPermutationsString.getAllPermutations("aabc");
        allPermutationsString.permute("aabc");
    }

    public void permute(String input) {
        permuteHelper(input, "");
        permutations.forEach(System.out::println);
    }

    public void permuteHelper(String input, String chosen) {
        if(input.isEmpty()) {
            permutations.add(chosen);
        }
        else {
            for (int i=0;i<input.length();i++) {
                // choose
                char c = input.charAt(i);

                // explore
                StringBuilder sb = new StringBuilder(input);
                permuteHelper(sb.deleteCharAt(i).toString(), chosen + c);
            }
        }
    }

}
