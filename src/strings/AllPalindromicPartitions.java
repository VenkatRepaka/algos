package strings;

public class AllPalindromicPartitions {

    public static void main(String[] args) {
        AllPalindromicPartitions allPalindromicPartitions = new AllPalindromicPartitions();
        String input = "abcb";
        System.out.println(input.substring(0 , 0));
        // allPalindromicPartitions.printPartitions(input, "", 0, input.length());
    }

    public void printPartitions(String input, String output, int begin, int end) {
        if(begin == end) {
            System.out.println(output);
            return;
        }
        String delimiter = "-";
        for (int i=begin;i<input.length();i++){
            if(isPalindrome(input, begin, i)) {
                if(i+1 == input.length()) {
                    delimiter = "";
                }
                printPartitions(input, output + input.substring(begin, i+1)+ delimiter, i+1, end);
            }
        }
    }

    public boolean isPalindrome(String input, int begin, int end) {
        while(begin < end) {
            if(input.charAt(begin) != input.charAt(end)) {
                return Boolean.FALSE;
            }
            begin++;
            end--;
        }
        return Boolean.TRUE;
    }

}
