package terceiraEtapa;
import java.util.Stack;

public class Etapa3 {
    
    public static void main(String[] args) {
        Stack<Character> expression1 = new Stack<>();
        expression1.push('(');
        expression1.push('A');
        expression1.push('+');
        expression1.push('B');
        expression1.push(')');

        Stack<Character> expression2 = new Stack<>();
        expression2.push('A');
        expression2.push('+');
        expression2.push('B');
        expression2.push('(');

        System.out.println(checkBrackets(expression1));  // Output: true
        System.out.println(checkBrackets(expression2));  // Output: false
    }

    public static boolean checkBrackets(Stack<Character> s1){
        Stack<Character> stack = new Stack<>();

        while (!s1.isEmpty()) {
            char c = s1.pop();

            if (c == ')') {
                stack.push(c);
            } else if (c == '(') {
                if (stack.isEmpty() || stack.pop() != ')') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
