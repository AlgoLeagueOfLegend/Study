import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ_15663 N과 M (9)
public class BOJ_15663 {
    static int N, M;
    static int[] numbers;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        visited = new boolean[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        perm(0);
    }

    public static void perm(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int num : result) {
                sb.append(num).append(' ');
            }
            System.out.println(sb.toString().trim());
            return;
        }

        int prev = -1; // 이전값과 다른지 확인
        for (int i = 0; i < N; i++) {
            if (!visited[i] && numbers[i] != prev) {
                visited[i] = true;
                result[depth] = numbers[i];
                prev = numbers[i];
                perm(depth + 1);
                visited[i] = false;
            }
        }
    }
}