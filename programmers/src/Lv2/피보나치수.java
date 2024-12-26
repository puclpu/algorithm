package Lv2;

public class 피보나치수 {
    public static void main(String[] args) {
        int result = solution(3);
        System.out.println(result);
    }

    private static int solution(int n) {
        int answer = 0;

        int f0 = 0;
        int f1 = 1;
        int f2 = 1;

        for (int i = 2; i <= n; i++) {
            f2 = (f0 + f1) % 1234567;
            f0 = f1;
            f1 = f2;
        }
        answer = f2;

        return answer;
    }
}
