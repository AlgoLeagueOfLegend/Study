import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17281 {

    static int N, ans = -1;

    static int[] players;
    static boolean[] selected;
    static int[][] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        selected = new boolean[10];
        players = new int[10];
        arr = new int[N][10];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1번 선수 = 4번 타자 결정
        players[4] = 1;
        selected[4] = true;

        perm(2);
        System.out.println(ans);

    }

    // 순열 시작
    private static void perm(int cnt) {

        if (cnt == 10) { // 순서 다 정함
            ans = Math.max(ans, game());
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!selected[i]) {
                selected[i] = true;
                players[i] = cnt;
                perm(cnt + 1);
                selected[i] = false;
            }
        }
    }

    // 게임 시작
    private static int game() {
        int start = 1;
        int score = 0;

        for (int i = 0; i < N; i++) {

            // 각 주자들의 위치를 저장하기 위한 배열( 아웃은 0번 인덱스에 저장 )
            int[] point = {0, 0, 0, 0, 0};

            // 아웃 3번 될때까지
            while (point[0] != 3) {
                run(point, arr[i][players[start]]);
                if (start == 9) { // 9번 선수 했으면 1로 변경
                    start = 1;
                } else {
                    start++;
                }
            }

            // 한 이닝 끝났을 때 점수
            score += point[4];
        }
        return score;
    }

    // 게임 진행 -> 선수 이동
    private static void run(int[] point, int n) {

        for (int i = 0; i < n; i++) {
            // 점수 저장
            point[4] += point[3];
            point[3] = point[2];
            point[2] = point[1];
            point[1] = 0;
        }

        // 공 친 주자의 위치 저장해야 함
        point[n]++;
    }
}