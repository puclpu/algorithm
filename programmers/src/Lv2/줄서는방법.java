package Lv2;

import java.util.ArrayList;

public class 줄서는방법 {
    public static void main(String[] args) {
        StandingInLine sil = new StandingInLine();
        int[] result = sil.solution(3, 5);
        for (int i = 0; i < result.length; i++) {
            System.out.println("i = " + result[i]);
        }
    }
}
class StandingInLine {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        long num = 1;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
            num *= i;
        }

        k--;

        for (int i = 0; i < n; i++) {
            num /= (n - i);
            answer[i] = list.remove((int)(k/num));
            k = k % num;
        }

        return answer;
    }
}