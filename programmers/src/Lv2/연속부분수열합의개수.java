package Lv2;

import java.util.HashSet;

public class 연속부분수열합의개수 {
    public static void main(String[] args) {
        int[] elements = {7,9,1,1,4};
        int result = solution(elements);
        assert result == 18;
    }
    private static int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = elements.length-1; i >= 0; i--) { // len
            for (int j = 0; j < elements.length; j++) { // start
                int sum = 0;
                for (int k = j; k < j+i; k++) {
                    sum += elements[k % elements.length];
                }
                set.add(sum);
            }
        }

        return set.size();
    }
}
