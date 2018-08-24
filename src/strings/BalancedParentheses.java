package strings;

import java.util.Map;
import java.util.Stack;

public class BalancedParentheses {

    private Map<Character, Character> parenthesesPairs = Map.of('(', ')', '{', '}', '[', ']');

    public boolean isBalanced(String input) {

        return Boolean.TRUE;
    }

    public boolean isBalancedUsingStack(String input) {
        Stack<Character> stack = new Stack<>();
        char[] arr = input.toCharArray();
        for(int i=0;i<arr.length;i++) {
            Character currChar = input.charAt(i);
            if(parenthesesPairs.keySet().contains(currChar)) {
                stack.push(currChar);
            }
            else if(parenthesesPairs.values().contains(currChar)) {
                if(stack.isEmpty()) {
                    return false;
                }
                else {
                    if(!parenthesesPairs.get(stack.pop()).equals(currChar)) {
                        return false;
                    }
                }
            }
        }
        return Boolean.TRUE;
    }

    public static void main(String[] args) {
        BalancedParentheses balancedParentheses = new BalancedParentheses();
        boolean isBalancedUsingStack = balancedParentheses.isBalancedUsingStack("({[]})");
        System.out.println(isBalancedUsingStack);

        char[] X = "[()]()".toCharArray();
        int n = 6;
        if (balancedParentheses.isBalanced(X, n))
            System.out.println("Yes\n");
        else
            System.out.println("No\n");

        /*char Y[] = "[[()]])";
        n = 7;
        if (isBalanced(Y, n))
            printf("Yes\n");
        else
            printf("No\n");*/
    }

    public int matchClosing(char X[], int start,
                     int end, char open, char close)
    {
        int c = 1;
        int i = start + 1;
        while (i <= end) {
            if (X[i] == open)
                c++;
            else if (X[i] == close)
                c--;
            if (c == 0)
                return i;
            i++;
        }
        return i;
    }

    // Function1 to match opening bracket
    public int matchingOpening(char X[], int start,
                        int end, char open, char close)
    {
        int c = -1;
        int i = end - 1;

        while (i >= start) {
            if (X[i] == open)
                c++;
            else if (X[i] == close)
                c--;
            if (c == 0)
                return i;
            i--;
        }
        return -1;
    }

    // Function to check balanced parantheses
    public boolean isBalanced(char[] X, int n)
    {
        // helper variables
        int i, j = 0, k, x, start, end;

        for (i = 0; i < n; i++) {
            // Handling case of opening parantheses
            if (X[i] == '(')
                j = matchClosing(X, i, n - 1, '(', ')');
            else if (X[i] == '{')
                j = matchClosing(X, i, n - 1, '{', '}');
            else if (X[i] == '[')
                j = matchClosing(X, i, n - 1, '[', ']');

                // Handling case of closing parantheses
            else {
                if (X[i] == ')')
                    j = matchingOpening(X, 0, i, '(', ')');
                else if (X[i] == '}')
                    j = matchingOpening(X, 0, i, '{', '}');
                else if (X[i] == ']')
                    j = matchingOpening(X, 0, i, '[', ']');

                // If corresponsing matching
                // opening parantheses doesn't
                // lie in given interval return 0
                if (j < 0 || j >= i)
                    return false;

                // else continue
                continue;
            }

            // If corresponding closing parantheses
            // doesn't lie in given interval
            // return 0
            if (j >= n || j < 0)
                return false;

            // if found, now check for each
            // opening and closing parantheses
            // in this interval
            start = i;
            end = j;

            for (k = start + 1; k < end; k++) {
                if (X[k] == '(') {
                    x = matchClosing(X, k, end, '(', ')');
                    if (!(k < x && x < end)) {
                        return false;
                    }
                }
                else if (X[k] == ')') {
                    x = matchingOpening(X, start, k, '(', ')');
                    if (!(start < x && x < k)) {
                        return false;
                    }
                }

                if (X[k] == '{') {
                    x = matchClosing(X, k, end, '{', '}');
                    if (!(k < x && x < end)) {
                        return false;
                    }
                }

                else if (X[k] == '}') {
                    x = matchingOpening(X, start, k, '{', '}');
                    if (!(start < x && x < k)) {
                        return false;
                    }
                }
                if (X[k] == '[') {
                    x = matchClosing(X, k, end, '[', ']');
                    if (!(k < x && x < end)) {
                        return false;
                    }
                }
                else if (X[k] == ']') {
                    x = matchingOpening(X, start, k, '[', ']');
                    if (!(start < x && x < k)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
