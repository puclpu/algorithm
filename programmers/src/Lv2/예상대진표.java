package Lv2;

import java.util.LinkedList;

public class 예상대진표 {
    public static void main(String[] args) {
        int result = solution(8, 4, 7);
        assert result == 3;
    }
    private static int solution(int n, int a, int b) {
        int answer = 0;

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int round = 0;
        while(!queue.isEmpty()) {
            int one = queue.pop();
            int theOther = queue.pop();

            if (one == a || theOther == a) {
                round++;
            }

            if (one == a && theOther == b || one == b && theOther == a) {
                answer = round;
                break;
            } else if (one == a || one == b) {
                queue.add(one);
            } else if (theOther == a || theOther == b) {
                queue.add(theOther);
            } else {
                queue.add(one);
            }
        }

        return answer;
    }
}
