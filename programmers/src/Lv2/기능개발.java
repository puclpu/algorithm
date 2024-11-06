package Lv2;

import java.util.ArrayList;

public class 기능개발 {
    public static void main(String[] args) {
        int[] progresses = {95,90,99,99,80,99};
        int[] speeds = {1,1,1,1,1,1};

        FunctionDevelopment fd = new FunctionDevelopment();
        int[] result = fd.solution(progresses, speeds);
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}
class FunctionDevelopment {
    public int[] solution(int[] progresses, int[] speeds) {
        int depth = 0;
        ArrayList<Integer> list = new ArrayList<>();

        boolean[] visited = new boolean[progresses.length];

        while(depth < progresses.length) {
            boolean release = true;
            int count = 0;

            for (int i = 0; i < progresses.length; i++) {
                if (visited[i])
                    continue;

                progresses[i] += speeds[i];

                if (progresses[i] < 100) {
                    release = false;
                } else if (release) {
                    count++;
                    visited[i] = true;
                }
            }

            if (count > 0) {
                list.add(count);
                depth += count;
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}