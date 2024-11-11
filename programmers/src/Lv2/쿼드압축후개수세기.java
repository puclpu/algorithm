package Lv2;

import java.util.LinkedList;

public class 쿼드압축후개수세기 {
    public static void main(String[] args) {
        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        QuadCompression qc = new QuadCompression();
        int[] result = qc.solution(arr);
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}
class QuadCompression {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];

        int n = arr.length;
        LinkedList<SArea> queue = new LinkedList<>();

        queue.add(new SArea(0, 0, n, n));

        while(!queue.isEmpty()) {
            SArea s = queue.pop();

            int bi = arr[s.sx][s.sy];
            boolean one = true;
            for (int i = s.sx; i < s.ex; i++) {
                for (int j = s.sy; j < s.ey; j++) {
                    if (arr[i][j] != bi) {
                        one = false;
                        break;
                    }
                }
                if (!one) {
                    break;
                }
            }

            if (one) { // 압축이 가능하다면
                answer[bi]++;
                continue;
            }

            int mx = s.sx + (s.ex-s.sx) / 2;
            int my = s.sy + (s.ey-s.sy) / 2;

            queue.add(new SArea(s.sx, s.sy, mx, my));
            queue.add(new SArea(mx, s.sy, s.ex, my));
            queue.add(new SArea(s.sx, my, mx, s.ey));
            queue.add(new SArea(mx, my, s.ex, s.ey));
        }

        return answer;
    }
}
class SArea {
    int sx;
    int sy;
    int ex;
    int ey;

    public SArea(int sx, int sy, int ex, int ey) {
        this.sx = sx;
        this.sy = sy;
        this.ex = ex;
        this.ey = ey;
    }
}