package Lv2;

public class N개의최소공배수 {
    public static void main(String[] args) {
        int[] arr = {2,7,14};
        int result = solution(arr);
        assert result == 14;
    }
    private static int solution(int[] arr) {
        int tmp = lcm(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            tmp = lcm(tmp, arr[i]);
        }

        return tmp;
    }

    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
