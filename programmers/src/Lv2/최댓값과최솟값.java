package Lv2;

import java.util.Arrays;

public class 최댓값과최솟값 {
    public static void main(String[] args) {
        MaxMinValue mmv = new MaxMinValue();
        String result = mmv.solution("1 2 3 4");
        System.out.println("result = " + result);
    }
}
class MaxMinValue {
    public String solution(String s) {
        String[] split = s.split(" ");
        int[] numbers = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            numbers[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(numbers);

        String answer = numbers[0] + " " + numbers[numbers.length-1];

        return answer;
    }
}