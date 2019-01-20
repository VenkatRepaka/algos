package stacks;

import java.util.Stack;

public class FindingSpans {

    public static void main(String[] args) {
        FindingSpans findingSpans = new FindingSpans();
//        findingSpans.findSpan();
        findingSpans.findSpansUsingStack();
    }

    public void findSpan() {
        int input[] = {6, 3, 4, 5,2};
        int j;
        int[] out = new int[input.length];
        for(int i=0;i<input.length;i++) {
            j = 1;
            while(j <= i && input[i] > input[i-j]) {
                j += 1;
            }
            out[i] = j;
        }
        for (int i=0;i<out.length;i++) {
            System.out.println(out[i]);
        }
    }

    public void findSpansUsingStack() {
        int input[] = {6, 3, 4, 5,2};
        int[] out = new int[input.length];
        Stack<Integer> stack = new Stack<>();
        int p;
        for (int i=0;i<input.length;i++) {
            while(!stack.isEmpty() && input[i] > stack.peek()) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                p = -1;
            }
            else {
                p = stack.peek();
            }
            out[i] = i-p;
            stack.push(i);
        }
        for (int i=0;i<out.length;i++) {
            System.out.println(out[i]);
        }
    }

}
