package strings;

import java.util.Stack;

public class InfixToPostFix {

    /**
     * https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
     */

    public int precedence(char ch) {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public String infixToPostfix(String input) {
        Stack<Character> stack = new Stack<>();
        char currChar;
        for(int i=0;i<input.length();i++) {
            currChar = input.charAt();
            if(Character.isLetterOrDigit()) {

            }
        }
        return null;
    }

    public static void main(String[] args) {
        InfixToPostFix infixToPostFix = new InfixToPostFix();
        infixToPostFix.infixToPostfix("a+b*c+d"); // abc*+d+
        // infixToPostFix.infixToPostfix("a+b*(c^d-e)^(f+g*h)-i");
    }


}
