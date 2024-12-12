import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_10819 차이를 최대로
public class BOJ_10819 {
    static int N;
    static int[] numbers, result;
    static boolean[] visited;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numbers = new int[N];
        result = new int[N];
        visited = new boolean[N];
        max = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        perm(0);
        System.out.println(max);
    }

    public static void perm(int depth) {
        if (depth == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(result[i] - result[i + 1]);
            }

            // 최대 갱신
            if (max < sum) {
                max = sum;
            }
            return;
        }

        // 순열 생성
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = numbers[i];
                perm(depth + 1);
                visited[i] = false;
            }
        }
    }
}
