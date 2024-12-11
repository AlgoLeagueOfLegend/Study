import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//BOJ_2422 한윤정이 이탈리아에 가서 아이스크림을 사먹는데
public class BOJ_2422 {

    //N: 아이스크림 수, M: 섞어먹으면 안되는 조합의 개수
    static int N, M;
    static boolean[][] isPossible;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        count = 0;

        isPossible = new boolean[N + 1][N + 1];

        // 섞어 먹으면 안되는 조합의 개수 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            isPossible[a][b] = true;
            isPossible[b][a] = true;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (isPossible[i][j]) continue; // 불가능한 조합일 때 -> 건너뜀
                for (int k = j + 1; k <= N; k++) {
                    if (isPossible[i][k] || isPossible[j][k]) continue; //  불가능한 조합일 때 -> 건너뜀
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
