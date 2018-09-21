package org.learn.hr.javaStack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    private static final Character[] openParentheses = {'(', '{', '['};
    
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(ClassLoader.getSystemResourceAsStream("javaStack2.txt"));

        while (sc.hasNext()) {
            String input=sc.next();
            checkParenthesesString(input);
        }
    }

    private static void checkParenthesesString(String input) {
        Stack<Character> parenthesesStack = new Stack<>();

        for (char c : input.toCharArray()) {
            if (Arrays.asList(openParentheses).contains(c)) {
                parenthesesStack.push(c);
            } else {
                switch (c) {
                    case ')':
                        if (popIfPeekMatches(parenthesesStack, '(')) {
                            break;
                        } else {
                            outputError();
                            return;
                        }
                    case '}':
                        if (!parenthesesStack.isEmpty() && parenthesesStack.peek().equals('{')) {
                            parenthesesStack.pop();
                            break;
                        } else {
                            outputError();
                            return;
                        }
                    case ']':
                        if (!parenthesesStack.isEmpty() && parenthesesStack.peek().equals('[')) {
                            parenthesesStack.pop();
                            break;
                        } else {
                            outputError();
                            return;
                        }
                }
            }
        }

        System.out.println(parenthesesStack.isEmpty() ? "true" : "false");

    }

    private static void outputError() {
        System.out.println("false");
    }

    private static <T> boolean popIfPeekMatches(Stack<T> stack, T match) {
        if (!stack.isEmpty() && stack.peek().equals(match)) {
            stack.pop();
            return true;
        }
        
        return false;
    }

}
