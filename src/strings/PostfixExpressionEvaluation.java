package strings;

import java.util.Set;
import java.util.Stack;

public class PostfixExpressionEvaluation {

    public int operate(char operator, int num2, int num1) {
        int val = 0;
        switch (operator) {
            case '+':
                val = num1 + num2;
                break;
            case '-':
                val = num1 - num2;
                break;
            case '*':
                val = num1 * num2;
                break;
            case '/':
                val = num1 / num2;
                break;
            default:
                break;
        }
        return val;
    }

    public int evalPostfixExpression(String input) {
        char[] inputArr = input.toCharArray();
        Stack<Integer> stack = new Stack<>();
        Set<Character> operators = Set.of('+', '-', '*', '/');
        Character currChar;
        int resp;
        for(int i=0;i<inputArr.length;i++) {
            currChar = input.charAt(i);
            if(operators.contains(currChar)) {
                resp = operate(currChar, stack.pop(), stack.pop());
                stack.push(resp);
            }
            else {
                stack.push(Integer.parseInt(String.valueOf(currChar)));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        PostfixExpressionEvaluation evaluation = new PostfixExpressionEvaluation();
        int val = evaluation.evalPostfixExpression("512+4*+3-");
        System.out.println(val);
    }

}
