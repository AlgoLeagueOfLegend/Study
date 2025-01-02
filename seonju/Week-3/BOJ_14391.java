import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14391 {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        dfs(0, 0);
        System.out.println(ans);
    }

    public static void dfs(int depth, int sum) {
        if (depth == N * M) {   // 모든 칸 확인
            if (sum > ans) ans = sum;
            return;
        }

        int x = depth / M;  // 현재 행
        int y = depth % M;  // 현재 열

        if (visited[x][y])  // 이미 방문 -> 다음칸
            dfs(depth + 1, sum);
        else {
            //현재 위치
            int num = 0;
            visited[x][y] = true;
            num = arr[x][y];
            dfs(depth + 1, sum + num);  // 현재 위치 더하고 다음칸

            //세로로 자르는 경우
            int i, temp = num;
            for (i = x + 1; i < N; i++) {
                if (visited[i][y])  // 이미 방문
                    break;
                visited[i][y] = true;
                temp = temp * 10 + arr[i][y];   // 세로로 연결한 숫자
                dfs(depth + 1, sum + temp);
            }

            // 세로 방문처리 해제
            for (int j = x + 1; j < i; j++)
                visited[j][y] = false;

            //가로로 자르는 경우
            temp = num;
            for (i = y + 1; i < M; i++) {
                if (visited[x][i])
                    break;
                visited[x][i] = true;
                temp = temp * 10 + arr[x][i];   // 가로로 연결한 숫자
                dfs(depth + i - y + 1, sum + temp);
            }

            // 가로 방문처리 해제
            for (int j = y + 1; j < i; j++)
                visited[x][j] = false;

            //현재 위치 방문처리 해제
            visited[x][y] = false;
        }
    }
}