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
        String result = "";
        char currChar;
        for(int i=0;i<input.length();i++) {
            currChar = input.charAt(i);
            if(Character.isLetterOrDigit(currChar)) {
                result += currChar;
            }
            else if(currChar == '(') {
                stack.push(currChar);
            }
            else if(currChar == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                if(!stack.isEmpty() && stack.peek() != '(') {

                }
                else {
                    stack.pop();
                }
            }
            else {
                while (!stack.isEmpty() && precedence(currChar) <= precedence(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(currChar);
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        InfixToPostFix infixToPostFix = new InfixToPostFix();
        // String postFix = infixToPostFix.infixToPostfix("a+b*c+d"); // abc*+d+
        String postFix = infixToPostFix.infixToPostfix("a+b*(c^d-e)^(f+g*h)-i");
        System.out.println(postFix);
    }


}
