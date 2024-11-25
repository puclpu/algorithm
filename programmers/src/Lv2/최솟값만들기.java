package Lv2;

import java.util.Arrays;

public class 최솟값만들기 {
    public static void main(String[] args) {
        int[] A = {1,4,2};
        int[] B = {5,4,4};
        MakeMinValue mmv = new MakeMinValue();
        int result = mmv.solution(A, B);
        System.out.println("result = " + result);
    }
}
class MakeMinValue
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length-1-i];
        }

        return answer;
    }
}