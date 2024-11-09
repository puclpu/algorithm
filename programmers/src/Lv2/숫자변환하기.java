package Lv2;

import java.util.HashSet;
import java.util.LinkedList;

public class 숫자변환하기 {
    public static void main(String[] args) {
        NumberConversion conversion = new NumberConversion();
        int result = conversion.solution(2, 5, 4);
        System.out.println("result = " + result);
    }
}
class NumberConversion {
    public int solution(int x, int y, int n) {
        int answer = -1;

        HashSet<Integer> set = new HashSet<>();
        LinkedList<Number> queue = new LinkedList<>();
        queue.add(new Number(0, x));

        while(!queue.isEmpty()) {
            Number number = queue.pop();

            if (number.n == y) {
                answer = number.depth;
                break;
            }

            int depth = number.depth + 1;
            int[] operation = new int[3];
            operation[0] = number.n + n;
            operation[1] = number.n * 2;
            operation[2] = number.n * 3;

            for (int i : operation) {
                if (i <= y && !set.contains(i)) {
                    queue.add(new Number(depth, i));
                    set.add(i);
                }
            }
        }

        return answer;
    }
}
class Number {
    int depth;
    int n;

    public Number(int depth, int n) {
        this.depth = depth;
        this.n = n;
    }
}