package projectCode20280.Algorithms;

import projectCode20280.Stacks.LinkedStack;

public class ParenthesesChecker {
    /*
    A function that takes a string of code as input and checks
    that all parentheses match each other. If a mistake is found it reports
    the error.
     */
    static void checkParentheses(String s) throws Exception {
        LinkedStack<Character> stack = new LinkedStack<>();
        char[] string = s.toCharArray();

        for (char c:string) {
            if(c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else if (c == ']' || c == ')' || c == '}') {
                if (stack.top() == null) {
                    throw new Exception("Error, right delimiter does not match");
                } else if (c == ']' && stack.top() != '[') {
                    throw new Exception("Error, delimiters do not match");
                } else if (c == ')' && stack.top() != '(') {
                    throw new Exception("Error, delimiters do not match");
                } else if (c == '}' && stack.top() != '{') {
                    throw new Exception("Error, delimiters do not match");
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            throw new Exception("Error, left delimiter does not match");
        }
    }

    public static void main(String args[]) {
        System.out.println("Testing following string: {[()]}");
        try {
            checkParentheses("{[()]}");
            System.out.println("Success!");
        } catch (Exception e) {
            System.out.println(e);
            //e.printStackTrace();
        }
        System.out.println();
        System.out.println("Testing following string: {[(])}");
        try {
            checkParentheses("{[(])}");
            System.out.println("Success!");
        } catch (Exception e) {
            System.out.println(e);
            //e.printStackTrace();
        }
        System.out.println();
        System.out.println("Testing following string: {{[[(())]]}}");
        try {
            checkParentheses("{{[[(())]]}}");
            System.out.println("Success!");
        } catch (Exception e) {
            System.out.println(e);
            //e.printStackTrace();
        }
        System.out.println();
        System.out.println("Testing following string: ][]][][[]][]][][[[");
        try {
            checkParentheses("][]][][[]][]][][[[");
            System.out.println("Success!");
        } catch (Exception e) {
            System.out.println(e);
            //e.printStackTrace();
        }
        System.out.println();
        System.out.println("Testing following string: (((abc))((d)))))");
        try {
            checkParentheses("(((abc))((d)))))");
            System.out.println("Success!");
        } catch (Exception e) {
            System.out.println(e);
            //e.printStackTrace();
        }
    }
}
