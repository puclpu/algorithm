package Lv2;

import java.util.Stack;

public class 큰수만들기 {
    public static void main(String[] args) {
        BigNumber bn = new BigNumber();
        String result = bn.solution("91", 1);
        System.out.println("result = " + result);
    }
}

class BigNumber {
    public String solution(String number, int k) {
        String answer = "";

        int count = 0;

        Stack<Character> stack = new Stack<>();
        Stack<Character> tmp = new Stack<>();

        for (int i = number.length()-1; i >= 0; i--) {
            stack.add(number.charAt(i));
        }

        while(count < k) {
            if (stack.isEmpty()) {
                tmp.pop();
                count++;
                continue;
            }

            Character c = stack.pop();

            if (tmp.isEmpty() || tmp.peek() >= c) {
                tmp.add(c);
            } else if (tmp.peek() < c) {
                while(!tmp.isEmpty()) {
                    Character p = tmp.peek();
                    if (p >= c) {
                        break;
                    } else {
                        tmp.pop();
                        count++;
                    }
                    if (count == k) {
                        break;
                    }
                }
                tmp.add(c);
            }

        }

        while(!tmp.isEmpty()) {
            stack.add(tmp.pop());
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        answer = sb.toString();

        return answer;
    }

}