package Lv2;

import java.util.Stack;

public class 올바른괄호 {

  public static void main(String[] args) {
    CorrectParentheses cp = new CorrectParentheses();
    boolean result = cp.solution("()()");
    System.out.println(result);
  }
}

class CorrectParentheses {
  boolean solution(String s) {
    boolean answer = true;

    Stack<Character> stack = new Stack<>();
    for(int i=0; i<s.length(); i++) {
      char c = s.charAt(i);

      if (!stack.isEmpty() && stack.peek() == '(' && c == ')') {
        stack.pop();
      } else {
        stack.push(c);
      }
    }

    if (!stack.isEmpty()) {
      answer = false;
    }

    return answer;
  }
}