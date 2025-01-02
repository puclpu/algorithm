package Lv2;

import java.util.Stack;

public class 괄호회전하기 {
    public static void main(String[] args) {
        int result = solution("}]()[{");
        assert result == 2;
    }
    private static int solution(String s) {
        int answer = 0;

        int len = s.length();

        for (int i = 0; i < len; i++) {
            String str = s.substring(i) + s.substring(0, i);
            if(isCorrectBracket(str)) {
                answer++;
            }
        }

        return answer;
    }

    private static boolean isCorrectBracket(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!stack.isEmpty() && isPairBracket(stack.peek(), c)) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isPairBracket(Character peek, char c) {
        if (peek == '(' && c == ')' ||
            peek == '{' && c == '}' ||
            peek == '[' && c == ']') {
            return true;
        } else {
            return false;
        }
    }
}
