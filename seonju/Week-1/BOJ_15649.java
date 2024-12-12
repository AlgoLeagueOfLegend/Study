import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15649 {
    static int N, M;
    static boolean[] visited;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        numbers = new int[M];
        perm(0);
    }

    public static void perm(int cnt) {
        if (cnt == M) { // 다 골랐을 때
            for (int num : numbers) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {

            for (int i = 1; i < N + 1; i++) {
                if (!visited[i]) {
                    numbers[cnt] = i;
                    visited[i] = true;
                    perm(cnt + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
