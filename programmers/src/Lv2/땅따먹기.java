package Lv2;

public class 땅따먹기 {
    public static void main(String[] args) {
        int[][] land = {{4, 3, 2, 1},{2, 2, 2, 1},{6, 6, 6, 4}, {8, 7, 6, 5}};
        EatTheLand etl = new EatTheLand();
        int result = etl.solution(land);
        System.out.println("result = " + result);
    }
}
class EatTheLand {
    int solution(int[][] land) {
        int answer = 0;

        for (int i = 1; i < land.length; i++) {
            land[i][0] += max(land[i-1][1], land[i-1][2], land[i-1][3]);
            land[i][1] += max(land[i-1][0], land[i-1][2], land[i-1][3]);
            land[i][2] += max(land[i-1][0], land[i-1][1], land[i-1][3]);
            land[i][3] += max(land[i-1][0], land[i-1][1], land[i-1][2]);
        }

        int last = land.length-1;
        for (int i = 0; i < land[last].length; i++) {
            answer = Math.max(answer, land[last][i]);
        }

        return answer;
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
