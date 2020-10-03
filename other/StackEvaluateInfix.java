import java.util.*;

public class StackEvaluateInfix {

    static int evaluateExpression(String exp) {
        if(exp.length() == 0) return 0;

        Stack<Integer> numbers = new Stack<Integer>();
        Stack<Integer> operators = new Stack<Integer>();

        for(int i=0; i < exp.length(); i++) {
            // current character
            char c = exp.charAt(i);

            if(Character.isDigit(c)) {
                // found number
                // parse the entire number (number can have multiple digits)
                int num = 0;
                while(Character.isDigit(c)) {
                    num = num*10 + (c-'0');
                    i++;

                    if(i<exp.length())
                        c = exp.charAt(j);
                    else
                        break;
                }
                // this is required since i gets incremented again in the for loop outside.
                // we may end up skipping a character
                // to avoid this, decrement i once
                i--;
                // push the number on the numbers stack
                numbers.push(num);
            } else if( c == '(') {
                // found (
                // push onto the operators stack
                operators.push(c);
            } else if(c == ')') {
                // found )
                // evaluate the entire bracket of ( to )
                while(!operators.empty() && !operators.peek() == '(') {
                    // calculate the output
                    int output = performOperation(numbers, operators);
                    // push the output on the stack
                    numbers.push(output);
                }
                // pop the open brace
                operators.pop(); 
            } else if(isOperator(c)) {
                // found operator
                // check the precedence of the current operator as compared to the operator on the stack
                // if its precedence is less, evaluate the operators on the stack first
                // if its precedence is more, push it on the operators stack
                while(!operators.empty() && precedence(c) <= precedence(operators.peek())) {
                    int output = performOperation(numbers, operators);
                    numbers.push(output);
                }
                // place the operator on the operators stack
                operators.push(c);
            }
        }

        // entire expression has been processed at this point
        // evaluate the remaining operations
        while(!operators.empty()) {
            int output = performOperation(numbers, operators);
            numbers.push(output);
        }

        return numbers.pop().intValue();
    }

    static int performOperation(Stack<Integer> numbers, Stack<Integer> operators) {
        int a = numbers.pop();
        int b = numbers.pop();
        int op = operators.pop();

        switch(op) {
            case '+':
                return b + a;
            case '-':
                return b - a;
            case '*':
                return b * a;
            case '/':
                if(a==0)
                    throw new UnsupportedOperationException("Cannot divide by 0");
                return b / a;
        }

        return 0;
    }

    static boolean isOperator(char c) {
        return (c =='+' || c == '-' || c == '*' || c == '/');
    }

    static int precedence(char op) {
        switch(op) {
            case '+': 
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }

        return -1;
    }

    public static void main(String args[]) {
        String expression = "2*(5+3)+8*4";
        System.out.println(evaluateExpression(expression));
        expression = "2 * (5 *(3+6))/15-2";
        System.out.println(evaluateExpression(expression));
    }
}