package Lv2;

import java.util.PriorityQueue;
import java.util.Stack;

public class 과제진행하기 {
    public static void main(String[] args) {
        String[][] plans = {
                {"science", "12:40", "50"},
                {"music", "12:20", "40"},
                {"history", "14:00", "30"},
                {"computer", "12:30", "100"}
        };
        String[] result = solution(plans);
        for (String s : result) {
            System.out.println(s);
        }
    }
    // name 과제명
    // start 과제 시작 시각
    // playtime 과제를 마치는 데 걸리는 시간
    private static String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int index = 0;

        PriorityQueue<Plan> pq = new PriorityQueue<>();
        for (int i = 0; i < plans.length; i++) {
            Plan plan = new Plan(plans[i][0], plans[i][1], plans[i][2]);
            pq.add(plan);
        }

        Stack<Plan> stack = new Stack<>();
        int h = 0;
        int m = 0;
        while(!pq.isEmpty()) {
            Plan plan = pq.peek();
            Plan now;
            Plan next;
            if (h == plan.h && m == plan.m) { // 새로운 과제를 시작할 시각
                now = pq.poll();
                if (pq.isEmpty()) {
                    answer[index++] = now.name;
                    break;
                }
                next = pq.peek();

            } else if (!stack.isEmpty()) { // 시간이 남았을 경우
                now = stack.pop();
                now.h = h;
                now.m = m;
                next = plan;
            } else {
                h = plan.h;
                m = plan.m;
                continue;
            }

            int minute = leftMinute(now, next);

            if (minute - now.playtime < 0) { // 못 끝낼 경우
                now.playtime = now.playtime - minute;
                stack.add(now);
                h = next.h;
                m = next.m;
            } else { // 과제를 끝냈을 경우
                answer[index++] = now.name;
                m = m + now.playtime;
                if (m >= 60) {
                    m -= 60;
                    h++;
                }
            }
        }

        while(!stack.isEmpty()) {
            answer[index++] = stack.pop().name;
        }

        return answer;
    }

    private static int leftMinute(Plan now, Plan next) {
        int h = next.h - now.h;
        int m = next.m - now.m;

        if (h > 0) {
            m += h * 60;
        }

        return m;
    }
}
class Plan implements Comparable<Plan> {
    String name;
    int h;
    int m;
    int playtime;

    public Plan(String name, String start, String playtime) {
        String[] clock = start.split(":");
        this.name = name;
        this.h = Integer.parseInt(clock[0]);
        this.m = Integer.parseInt(clock[1]);
        this.playtime = Integer.parseInt(playtime);
    }

    @Override
    public int compareTo(Plan o) {
        if (this.h == o.h) {
            return this.m - o.m;
        } else {
            return this.h - o.h;
        }
    }
}