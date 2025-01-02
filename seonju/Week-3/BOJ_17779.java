import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17779 {

    static int N;
    static int[][] A;
    static int ppl = 0;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                ppl += A[i][j]; // 총 인구수
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int d1 = 1; d1 < N; d1++) {
                    for (int d2 = 1; d2 < N; d2++) {
                        if (i + d1 + d2 >= N) continue;
                        if (j - d1 < 0 || j + d2 >= N) continue;
                        find(i, j, d1, d2);
                    }
                }
            }
        }

        System.out.println(ans);
    }

    private static void find(int x, int y, int d1, int d2) {
        // 경계 확인
        boolean[][] visited = new boolean[N][N];

        //경계선 처리 대각선
        // 왼쪽 아래
        for (int i = 0; i <= d1; i++) {
            visited[x + i][y - i] = true;
            visited[x + d2 + i][y + d2 - i] = true;
        }

        // 오른쪽 위
        for (int i = 0; i <= d2; i++) {
            visited[x + i][y + i] = true;
            visited[x + d1 + i][y - d1 + i] = true;
        }

        int[] people = new int[6];
        int ppl_sum = 0;

        // 1
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (visited[i][j]) break;   // 경계선이면 끝
                people[1] += A[i][j];
            }
        }
        ppl_sum += people[1];

        // 2
        for (int i = 0; i <= x + d2; i++) {
            for (int j = N - 1; j > y; j--) {
                if (visited[i][j]) break;
                people[2] += A[i][j];
            }
        }
        ppl_sum += people[2];

        // 3
        for (int i = x + d1; i < N; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (visited[i][j]) break;
                people[3] += A[i][j];
            }
        }

        ppl_sum += people[3];

        // 4
        for (int i = x + d2 + 1; i < N; i++) {
            for (int j = N - 1; j >= y - d1 + d2; j--) {
                if (visited[i][j]) break;
                people[4] += A[i][j];
            }
        }

        ppl_sum += people[4];

        // 5
        people[5] = ppl - ppl_sum;    // 전체 인구수 - 다른 구역 인구수

        Arrays.sort(people);

        ans = Math.min(people[5] - people[1], ans);
    }

}