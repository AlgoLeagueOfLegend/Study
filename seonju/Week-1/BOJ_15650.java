import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15650 {
    static int N, M;
    static boolean[] visited;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[M];
        visited = new boolean[N + 1];

        perm(0, 1);
    }

    public static void perm(int cnt, int idx) {

        if (cnt == M) { // M개 고른 경우
            for (int val : numbers) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = idx; i <= N; i++) { // 1~N
            numbers[cnt] = i;
            perm(cnt + 1, i + 1);

        }
    }
}
